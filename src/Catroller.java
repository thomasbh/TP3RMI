import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Catroller implements ActionListener, ListSelectionListener {

    CatModelo model;
    CatShopView view;

    public Catroller(CatShopView v, CatModelo m) {
        model = m;
        view = v;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("<<" + e.getActionCommand() + ">>");

        if (e.getActionCommand().equals("Salir")) {
            System.exit(1);
        } else if (e.getActionCommand().equals("Conectarse")) {
            Usuario user = new Usuario(view.getRealName(), view.getUserDireccion(), view.getUserCorreo(), view.getUserTelefono(), view.getUserApodo());
            if (!model.registraUsuario(user)) {
                view.errorCreatingUser();
            } else {
                view.setCurrentUser(user);
                view.userSuccessfullyCreated(); //create success message
                view.updateRegistrarUsuario();
            }
        } else if (e.getActionCommand().equals("Mandar oferta")) {
            Oferta oferta = new Oferta(view.getCurrentUser(), view.getSelectedProduct(), view.getMontoOferta());
            if (!model.ofertaAceptada(oferta)) {
                view.offerDeclined();
            } else {
                view.offerAccepted();
            }
        } else if (e.getActionCommand().equals("Vender")) {
            Producto prod = new Producto(view.getProductName(), view.getProductDesc(), view.getTiempoVenta(), view.getProductInitialPrice(), view.getCurrentUser());
            System.out.println("Enters here");
            if (!model.ventaPermitida(prod)) {
                view.ventaRefused();
            } else {
                view.ventaAccepted();
            }

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        String item = (String) list.getSelectedValue();
        if (item != null) {
            System.out.println(item);
            Producto prod = model.getThisProduct(item);
            view.setSelectedProduct(prod); //use selectedProduct to uddate only selected info
        }
    }
}
