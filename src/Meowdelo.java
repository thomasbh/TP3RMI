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
    Hashtable ofertas;
    Hashtable usuarios;
    Hashtable productos;
    private ArrayList<ClientInterface> callbackMe;
    Hashtable oldProductos;

    public Meowdelo() {

        usuarios = new Hashtable();
        productos = new Hashtable();
        ofertas = new Hashtable();
        callbackMe = new ArrayList<>();
    }

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

    public void register(ClientInterface cltint) {
        callbackMe.add(cltint);
    }

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

    public synchronized boolean ventaPermitida(Producto producto) throws RemoteException {
        if (!productos.containsKey(producto.getNombre())) {
            System.out.println("Agregando un nuevo producto: " + producto.getNombre());
            productos.put(producto.getNombre(), producto);
            updateAfterSellingAProduct(producto);
            return true;
        } else
            return false;
    }

    public synchronized boolean ofertaAceptada(Oferta oferta) throws RemoteException {

        if (productos.containsValue(oferta.getProducto())) {

            Producto prod = oferta.getProducto();

            if (prod.actualizaPrecio(oferta.getMontoOferta())) {

                prod.addOferta(oferta);

                if (ofertas.containsKey(prod.getNombre())) {
                    ofertas.replace(prod.getNombre(), oferta);
                } else {
                    ofertas.put(prod.getNombre(), oferta);
                }
                updateAfterSendingAnOffer(oferta);

                return true;

            } else

                return false;

        } else

            return false;
    }

    // regresa un producto en la lista de objetos en venta o ya vendido

    public Producto getThisProduct(String productName) {
        Producto wanted;
        if (productos.containsKey(productName))
            wanted = (Producto) productos.get(productName);
        else
            wanted = (Producto) oldProductos.get(productName);
        return wanted;
    }

    public Usuario getThisUser(String nickname) {
        Usuario user = (Usuario) usuarios.get(nickname);
        return user;
    }

    public ArrayList<Producto> obtieneCatalogoActivo() {
        ArrayList<Producto> productosActivos = new ArrayList<>();

        for (Object o : productos.values()) {
            Producto p = (Producto) o;
            if (p.getLimite().compareTo(Calendar.getInstance()) <= 0) {
                productosActivos.add(p);
            }
        }
        return productosActivos;
    }

    public ArrayList<Producto> obtieneProductosExpirados() {
        ArrayList<Producto> productosExpirados = new ArrayList<>();

        for (Object o : productos.values()) {
            Producto p = (Producto) o;
            if (p.getLimite().compareTo(Calendar.getInstance()) >= 0) {
                productosExpirados.add(p);
            }
        }
        return productosExpirados;
    }

    public List<Producto> getProductosGanados(Usuario user) {
        ArrayList<Producto> productosGanados = new ArrayList<>();
        for (Producto p : obtieneProductosExpirados()) {
            if (p.getGanador() == user) {
                productosGanados.add(p);
            }
        }
        return productosGanados;
    }

    public List<Producto> getProductosPerdidos(Usuario user) {
        ArrayList<Producto> productosPerdidos = new ArrayList<>();
        for (Producto p : obtieneProductosExpirados()) {
            if (p.getGanador() != user) {
                productosPerdidos.add(p);
            }
        }
        return productosPerdidos;
    }

    public boolean sigueGanando(Usuario u, String prodAComprobar) {
        Producto productoAComprobar = (Producto) productos.get(prodAComprobar);
        List<Oferta> ofertasOnThisProd = productoAComprobar.getOfertas();
        // if the last offer on this product is of the same buyer, return true
        if (ofertasOnThisProd.get(ofertasOnThisProd.size() - 1).getCompradorPotencial() == u) {
            return true;
        } else {
            return false;
        }
    }


    public void updateAfterSellingAProduct(Producto p) throws RemoteException {
        for (Object o : usuarios.values()) {
            Usuario u = (Usuario) o;
            if (p.getVendedor() == u)
                u.getHisInterface().update("AddVentaProd", p);
            else
                u.getHisInterface().update("AddProductoAlCatalogo", p);
        }
    }

    public void updateAfterSendingAnOffer(Oferta oferta) throws RemoteException {
        for (Object o : usuarios.values()) {
            Usuario u = (Usuario) o;
            if (oferta.getProducto().getVendedor().getApodo().equals(u.getApodo()))
                u.getHisInterface().update("NewOfferOnOneOfYourProducts", oferta.getProducto());
            else if (oferta.getCompradorPotencial().getApodo().equals(u))
                u.getHisInterface().update("AddEstasGanando", oferta.getProducto());
            else {
                //if (oferta.getProducto().getUsuariosInteresados().contains(u)) {
                for (Usuario interesado : oferta.getProducto().getUsuariosInteresados()) {
                    if (interesado.getApodo().equals(u.getApodo()))
                        u.getHisInterface().update("AddApuestaMas", oferta.getProducto());
                }
            }
        }
    }


    public void updateProductList() {
        final Runnable runnable = () -> {
            if (!productos.isEmpty()) {
                for (Object o : productos.values()) {
                    Producto p = (Producto) o;
                    if (p.getLimite().compareTo(Calendar.getInstance()) >= 0) {
                        oldProductos.put(p.getNombre(), p);
                        p.setGanador();
                        for (Object objusuario : usuarios.values()) {
                            Usuario u = (Usuario) objusuario;
                            try {
                                if (p.getVendedor().getApodo().equals(u.getApodo()))
                                    u.getHisInterface().update("AddVentaAcabada", p);
                                else if (p.getGanador().getApodo().equals(u.getApodo()))
                                    u.getHisInterface().update("AddProductoGanado", p);
                                else {
                                    //if (p.getUsuariosInteresados().contains(u))
                                    for (Usuario interesado : p.getUsuariosInteresados()) {
                                        if (interesado.getApodo().equals(u.getApodo()))
                                            u.getHisInterface().update("AddProductoPerdido", p);
                                    }
                                    u.getHisInterface().update("ProductoExpirado", p);
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