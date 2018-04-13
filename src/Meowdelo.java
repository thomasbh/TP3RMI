import java.util.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Meowdelo implements ServerInterface {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Hashtable ofertas;
    private Hashtable usuarios;
    private Hashtable productos;
    private Hashtable oldProductos;
    private boolean updateEnabled = false;

    // =============
    //  CONSTRUCTOR
    // =============

    Meowdelo() {

        usuarios = new Hashtable();
        productos = new Hashtable();
        ofertas = new Hashtable();
        oldProductos = new Hashtable();
    }

    // ======
    //  MAIN
    // ======

    public static void main(String args[]) {

        try {
            Meowdelo meow = new Meowdelo();
            ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(meow, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Model", stub);
            System.err.println("The server of catshop is ready!");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString() + " :(");
            e.printStackTrace();
        }
    }

    // ======================
    //  REGISTRAR EL USUARIO
    // ======================

    public synchronized boolean registrarUsuario(Usuario user) throws RemoteException {

        if (!usuarios.containsKey(user.getApodo())) {

            System.out.println("Agregando un nuevo usuario: " + user.getNombre());
            usuarios.put(user.getApodo(), user);
            if (!productos.isEmpty()) {
                for (Object o : productos.values()) {
                    Producto p = (Producto) o;
                    user.getHisInterface().update("AddProductoAlCatalogo", p);
                }
            }
            return true;

        } else

            return false;
    }

    // ===============================
    //  PRUEBA VALIDEZ VENTA + OFERTA
    // ===============================

    public synchronized boolean ventaPermitida(Producto producto) throws RemoteException {
        if (!productos.containsKey(producto.getNombre())) {
            System.out.println("Agregando un nuevo producto: " + producto.getNombre());
            productos.put(producto.getNombre(), producto);
            updateAfterSellingAProduct(producto);
            if (!updateEnabled) {
                updateProductList();
                updateEnabled = true;
            }
            return true;
        } else
            return false;
    }

    public synchronized boolean ofertaAceptada(Oferta oferta) throws RemoteException {
        for (Object o : productos.values()) {
            Producto p = (Producto) o;
            if (oferta.getProducto().getNombre().equals(p.getNombre())) {
                p = oferta.getProducto();

                if (p.actualizaPrecio(oferta.getMontoOferta())) {

                    for (Object key : productos.keySet()) {
                        String s = (String) key;
                        if (s.equals(p.getNombre())) {
                            productos.replace(key, p);
                        }
                    }
                    p.addOferta(oferta);

                    if (ofertas.containsKey(p.getNombre())) {
                        ofertas.replace(p.getNombre(), oferta);
                    } else {
                        ofertas.put(p.getNombre(), oferta);
                    }
                    updateAfterSendingAnOffer(oferta);

                    return true;

                } else

                    return false;

            }
            // if product name doesn't even exist, which is weird
        }
        return false;
    }

    // ===============================================
    //  ACCIONES A TOMAR SI EL CHEQUEO ESTUVO EXITOSO
    // ===============================================

    private void updateAfterSellingAProduct(Producto p) throws RemoteException {
        for (Object o : usuarios.values()) {
            Usuario u = (Usuario) o;
            if (p.getVendedor().getApodo().equals(u.getApodo()))
                u.getHisInterface().update("AddVentaProd", p);
            else
                u.getHisInterface().update("AddProductoAlCatalogo", p);
        }
    }

    private void updateAfterSendingAnOffer(Oferta oferta) throws RemoteException {
        System.out.println("======== DEBUG AFTER SENDING OFFER ========");
        for (Object o : usuarios.values()) {
            Usuario u = (Usuario) o;
            System.out.println("USUARIO ANALIZADO = " + u.getApodo());
            System.out.println("VENDEDOR = " + oferta.getProducto().getVendedor().getApodo());
            System.out.println("NUEVO GANADOR (COMPRADOR POTENCIAL) = " + oferta.getCompradorPotencial().getApodo());
            if (oferta.getProducto().getVendedor().getApodo().equals(u.getApodo())) {
                System.out.println("Oye vendedor : " + u.getApodo());
                u.getHisInterface().update("NewOfferOnOneOfYourProducts", oferta.getProducto());
            } else if (oferta.getCompradorPotencial().getApodo().equals(u.getApodo())) {
                System.out.println("Este usuario esta ganando: " + u.getApodo());
                u.getHisInterface().update("AddEstasGanando", oferta.getProducto());
            } else {
                if (!oferta.getProducto().getUsuariosInteresados().isEmpty()) {
                    for (Usuario interesado : oferta.getProducto().getUsuariosInteresados()) {
                        System.out.println("Apodo del intersado analizado (para entrar al ultimo if): " + interesado.getApodo());
                        System.out.println("condition de l'if: " + !(interesado.getApodo().equals(oferta.getCompradorPotencial().getApodo())));
                        if (interesado.getApodo().equals(u.getApodo())) {
                            if (!(u.getApodo().equals(oferta.getCompradorPotencial().getApodo()))) {
                                System.out.println("the interested user is the analized user + is NOT the winner");
                                u.getHisInterface().update("AddApuestaMas", oferta.getProducto());
                            }
                        }

                        /*if (!(interesado.getApodo().equals(oferta.getCompradorPotencial().getApodo()))) {
                            System.out.println("The interested user is different from the last buyer " + u.getApodo());

                        }*/

                    }
                }
            }
        }
    }

    // ========
    //  GETTER
    // ========

    public Producto getThisProduct(String productName) {
        Producto wanted = null;
        String existingProductName = null;
        for (Object key : productos.keySet()) {
            existingProductName = (String) key;
            if (existingProductName.equals(productName))
                wanted = (Producto) productos.get(key);
        }
        if (wanted == null) {
            for (Object key : oldProductos.keySet()) {
                existingProductName = (String) key;
                if (existingProductName.equals(productName))
                    wanted = (Producto) oldProductos.get(key);
            }
        }
        return wanted;
    }

    // ===================================================
    //  ACTULIZACION DE LA LISTA DE LOS PRODUCTOS VALIDOS
    // ===================================================

    private void updateProductList() {
        final Runnable runnable = () -> {
            if (!productos.isEmpty()) {
                for (Object o : productos.values()) {
                    Producto p = (Producto) o;
                    if (p.getLimite().compareTo(Calendar.getInstance()) <= 0) {
                        productos.remove(p.getNombre());
                        oldProductos.put(p.getNombre(), p);
                        p.setGanador();
                        for (Object objusuario : usuarios.values()) {
                            Usuario u = (Usuario) objusuario;
                            System.out.println("==========DEBUG=============");
                            System.out.println("Usuario analizado = " + u.getApodo());
                            System.out.println("Vendedor del producto = " + p.getVendedor().getApodo());
                            System.out.println("Ganador del producto = " + p.getGanador().getApodo());
                            try {
                                if (p.getVendedor().getApodo().equals(u.getApodo())) {
                                    System.out.println("VENDEDOR OK");
                                    u.getHisInterface().update("AddVentaAcabada", p);
                                } else if (p.getGanador().getApodo().equals(u.getApodo())) {
                                    System.out.println("GANADOR OK");
                                    u.getHisInterface().update("AddProductoGanado", p);
                                }

                                else {
                                    //if (p.getUsuariosInteresados().contains(u))
                                    boolean interesadoFound = false;
                                    for (Usuario interesado : p.getUsuariosInteresados()) {
                                        if (interesado.getApodo().equals(u.getApodo())) {
                                            interesadoFound = true;
                                            System.out.println("Perdedor OK = " + interesado.getApodo());
                                            u.getHisInterface().update("AddProductoPerdido", p);
                                            break;
                                        }
                                    }
                                    if (!interesadoFound) {
                                        System.out.println("Otro usuario OK " + u.getApodo());
                                        u.getHisInterface().update("ProductoExpirado", p);
                                    }
                                }
                            } catch (RemoteException e) {
                                System.err.println("Hubo un problema al actualizar la lista de los productos.");
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        final ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(runnable, 5, 1, TimeUnit.SECONDS);
    }
}