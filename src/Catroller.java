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

        switch (e.getActionCommand()) {
            case "Salir":
                System.exit(1);
            case "Conectarse":
                Usuario user = new Usuario(view.getRealName(), view.getUserDireccion(), view.getUserCorreo(), view.getUserTelefono(), view.getUserApodo(), myInterface);
                try {
                    if (!model.registrarUsuario(user)) {
                        view.errorCreatingUser();
                    } else {
                        view.setCurrentUser(user);
                        view.userSuccessfullyCreated();
                        view.updateRegistrarUsuario();
                    }
                } catch (RemoteException e1) {
                    System.err.println("Hubo un error al conectarse al servidor para registrar el usuario");
                    e1.printStackTrace();
                }
                break;
            case "Vender":
                Producto prod = new Producto(view.getSellingProductName(), view.getProductDesc(), view.getTiempoVenta(), view.getProductInitialPrice(), view.getCurrentUser());
                System.out.println("Enters here");
                try {
                    if (!model.ventaPermitida(prod)) {
                        view.ventaRefused();
                    } else {
                        view.cleanText("Vender");
                        view.ventaAccepted();
                        //view.addSellingProduct(prod);
                    }
                } catch (RemoteException e1) {
                    System.err.println("Hubo un error al poner a la venta el producto.");
                    e1.printStackTrace();
                }

                break;
            case "Mandar oferta": {
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
                        //view.addEstasGanandoProduct(view.getSelectedProduct());
                    }
                } catch (RemoteException e1) {
                    System.err.println("Hubo un error al mandar la oferta.");
                    e1.printStackTrace();
                }
                break;
            }
            case "Mandar contraoferta": {
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
                break;
            }
        }
    }

    // SET SELECTED PRODUCT DEPENDING ON SELECTED LIST

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>) e.getSource();
        String item = list.getSelectedValue();
        System.out.println("Value changed");
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
        switch (reason) {
            case "AddProductoAlCatalogo":
                view.addProductoAlCatalogo(p);
                break;
            case "AddEstasGanando":
                view.addEstasGanandoProduct(p);
                break;
            case "AddApuestaMas":
                view.addApuestaMas(p);
                break;
            case "AddVentaProd":
                view.addSellingProduct(p);
                break;
            case "AddVentaAcabada":
                view.addVentaAcabada(p);
                break;
            case "AddProductoGanado":
                view.addProductoGanado(p);
                break;
            case "AddProductoPerdido":
                view.addProductoPerdido(p);
                break;
            case "ProductoExpirado":
                view.removeProductoDelCatalogo(p);
                break;
            case "NewOfferOnOneOfYourProducts":
                view.newOfferOnYourProduct(p);
                break;
        }
    }

}
