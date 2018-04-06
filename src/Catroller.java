import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Catroller implements ActionListener, ListSelectionListener, ClientInterface {

    //Meowdelo model;
    static CatShopView view;
    private ServerInterface model;
    static ClientInterface myInterface;

    public Catroller(CatShopView v, Meowdelo m) {
        model = m;
        view = v;
    }

    public Catroller(CatShopView v, ServerInterface m) {
        model = m;
        view = v;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            Registry registry = LocateRegistry.getRegistry();
            ServerInterface model = (ServerInterface) registry.lookup("Model");
            // vista;
            Catroller catroller = new Catroller(view = new CatShopView(), model);
            view.asignarActionListener(catroller);
            view.asignarListSelectionListener(catroller);
            myInterface = (ClientInterface) UnicastRemoteObject.exportObject(catroller, 0);
            model.register(myInterface);
            System.out.println("Client ready and registered");
        } catch (Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("<<" + e.getActionCommand() + ">>");

        if (e.getActionCommand().equals("Salir")) {
            System.exit(1);
        } else if (e.getActionCommand().equals("Conectarse")) {
            Usuario user = new Usuario(view.getRealName(), view.getUserDireccion(), view.getUserCorreo(), view.getUserTelefono(), view.getUserApodo(), myInterface);
            try {
                if (!model.registrarUsuario(user)) {
                    view.errorCreatingUser();
                } else {
                    view.setCurrentUser(user);
                    view.userSuccessfullyCreated(); //create success message
                    view.updateRegistrarUsuario();
                }
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al conectarse al servidor para registrar el usuario");
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Vender")) {
            Producto prod = new Producto(view.getSellingProductName(), view.getProductDesc(), view.getTiempoVenta(), view.getProductInitialPrice(), view.getCurrentUser());
            System.out.println("Enters here");
            try {
                if (!model.ventaPermitida(prod)) {
                    view.ventaRefused();
                } else {
                    view.ventaAccepted();
                    //view.addSellingProduct(prod);
                }
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al poner a la venta el producto.");
                e1.printStackTrace();
            }

        } else if (e.getActionCommand().equals("Mandar oferta")) {
            Oferta oferta = null;
            try {
                oferta = new Oferta(view.getCurrentUser(), model.getThisProduct(view.getSelectedProductOfCatalog()), view.getMontoOferta());
            } catch (RemoteException e1) {
                System.err.println("No fue possible crear la oferta.");
                e1.printStackTrace();
            }
            try {
                if (!model.ofertaAceptada(oferta)) {
                    view.offerDeclined();
                } else {
                    view.offerAccepted();
                    //view.addEstasGanandoProduct(view.getSelectedProduct());
                }
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al mandar la oferta.");
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Actualizar lista productos a comprar")) {
            ArrayList<Producto> productosEnVenta = null;
            try {
                productosEnVenta = model.obtieneCatalogoActivo();
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al obtener el catalogo de productos en venta");
                e1.printStackTrace();
            }
            System.out.println("Updating catalogue");
            view.updateListComprasPossibles(productosEnVenta);

        } else if (e.getActionCommand().equals("Actualizar lista apuesta más")) {
            String[] arrayGanando = view.getEstasGanando();
            ArrayList<String> tienesQueApostarMas = new ArrayList<>();
            for (String s : arrayGanando) {
                try {
                    if (!model.sigueGanando(view.getCurrentUser(), s)) {
                        tienesQueApostarMas.add(s);
                    }
                } catch (RemoteException e1) {
                    System.err.println("Hubo un error al obtener la lista de productos que necesitan otra oferta");
                    e1.printStackTrace();
                }
            }
            view.updateListApuestaMas(tienesQueApostarMas);
        } else if (e.getActionCommand().equals("Mandar contraoferta")) {
            Oferta oferta = null;
            try {
                oferta = new Oferta(view.getCurrentUser(), model.getThisProduct(view.getSelectedProductOfApuestaMas()), view.getMontoContraOferta());
            } catch (RemoteException e1) {
                System.err.println("No fue possible crear la contraoferta.");
                e1.printStackTrace();
            }
            try {
                if (!model.ofertaAceptada(oferta)) {
                    view.offerDeclined();
                } else {
                    view.offerAccepted();
                    //view.addEstasGanandoProduct(view.getSelectedProduct());
                }
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al agregar su contraoferta");
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>) e.getSource();
        String item = list.getSelectedValue();
        System.out.println("Value changed");
        if (item != null) {
            System.out.println(item);
            Producto prod = null;
            try {
                prod = model.getThisProduct(item);
            } catch (RemoteException e1) {
                System.err.println("Hubo un problema recuperando el Producto " + item);
                e1.printStackTrace();
            }
            if (list == view.getListaVentasEnCurso())
                view.setSelectedProduct("Mis ventas en curso", prod); //use selectedProduct to uddate only selected info
            else if (list == view.getListaVentasAcabadas())
                view.setSelectedProduct("Acabadas", prod);
            else if (list == view.getListaProductosCatalogo())
                view.setSelectedProduct("Catalogo", prod);
            else if (list == view.getListadeEstasGanando())
                view.setSelectedProduct("Ganando", prod);
            else if (list == view.getListadeApuestaMas())
                view.setSelectedProduct("Perdiendo", prod);
                // implement from here
            else if (list == view.getListaGane())
                view.setSelectedProduct("Gane", prod);
            else if (list == view.getListaPerdi())
                view.setSelectedProduct("Perdi", prod);
        }
    }

    public void update(String reason, Producto p) throws RemoteException {
        if (reason.equals("AddProductoAlCatalogo"))
            view.addProductoAlCatalogo(p);
        else if (reason.equals("AddEstasGanando"))
            view.addEstasGanandoProduct(p);
        else if (reason.equals("AddApuestaMas"))
            view.addApuestaMas(p);
        else if (reason.equals("AddVentaProd"))
            view.addSellingProduct(p);
        else if (reason.equals("AddVentaAcabada"))
            view.addVentaAcabada(p);
        else if (reason.equals("AddProductoGanado"))
            view.addProductoGanado(p);
        else if (reason.equals("AddProductoPerdido"))
            view.addProductoPerdido(p);
        else if (reason.equals("ProductoExpirado"))
            view.removeProductoDelCatalogo(p);
    }

}
