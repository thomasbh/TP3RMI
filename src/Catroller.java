import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Catroller implements ActionListener, ListSelectionListener, ClientInterface {

    private static CatShopView view;
    private ServerInterface model;
    private static ClientInterface myInterface;

    Catroller(CatShopView v, Meowdelo m) {
        model = m;
        view = v;
    }

    private Catroller(CatShopView v, ServerInterface m) {
        model = m;
        view = v;
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            Registry registry = LocateRegistry.getRegistry();
            ServerInterface model = (ServerInterface) registry.lookup("Model");
            Catroller catroller = new Catroller(view = new CatShopView(), model);
            view.asignarActionListener(catroller);
            view.asignarListSelectionListener(catroller);
            myInterface = (ClientInterface) UnicastRemoteObject.exportObject(catroller, 0);
            System.out.println("Client ready");
        } catch (Exception e) {
            System.err.println("Hubo un error al crear el cliente.");
            e.printStackTrace();
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
            try {
                if (!model.ventaPermitida(prod)) {
                    view.ventaRefused();
                } else {
                    view.cleanText("Vender");
                    view.ventaAccepted();
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
                    view.cleanText("Catalogo");
                    view.offerAccepted();
                }
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al mandar la oferta.");
                e1.printStackTrace();
            }
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
                    view.cleanText("ApuestaMas");
                    view.offerAccepted();
                }
            } catch (RemoteException e1) {
                System.err.println("Hubo un error al agregar su contraoferta");
                e1.printStackTrace();
            }
        }
    }

    // SET SELECTED PRODUCT DEPENDING ON SELECTED LIST

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>) e.getSource();
        String item = list.getSelectedValue();
        if (item != null) {
            Producto prod = null;
            try {
                prod = model.getThisProduct(item);
            } catch (RemoteException e1) {
                System.err.println("Hubo un problema recuperando el Producto " + item);
                e1.printStackTrace();
            }
            if (list == view.getListaVentasEnCurso())
                view.setSelectedProduct("Mis ventas en curso", prod); //use selectedProduct to update only selected info
            else if (list == view.getListaVentasAcabadas())
                view.setSelectedProduct("Acabadas", prod);
            else if (list == view.getListaProductosCatalogo())
                view.setSelectedProduct("Catalogo", prod);
            else if (list == view.getListadeEstasGanando())
                view.setSelectedProduct("Ganando", prod);
            else if (list == view.getListadeApuestaMas())
                view.setSelectedProduct("Perdiendo", prod);
            else if (list == view.getListaGane())
                view.setSelectedProduct("Gane", prod);
            else if (list == view.getListaPerdi())
                view.setSelectedProduct("Perdi", prod);
        }
    }

    // ACTUALIZAR LAS ZONAS DE TEXTO DE LA VISTA

    public void update(String reason, Producto p) {
        System.out.println("enters in update method with reason: " + reason);
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
        else if (reason.equals("NewOfferOnOneOfYourProducts"))
            view.newOfferOnYourProduct(p);
    }

}
