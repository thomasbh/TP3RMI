import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        } else if (e.getActionCommand().equals("Vender")) {
            Producto prod = new Producto(view.getProductName(), view.getProductDesc(), view.getTiempoVenta(), view.getProductInitialPrice(), view.getCurrentUser());
            System.out.println("Enters here");
            if (!model.ventaPermitida(prod)) {
                view.ventaRefused();
            } else {
                view.ventaAccepted();
                view.addSellingProduct(prod);
            }

        } else if (e.getActionCommand().equals("Mandar oferta")) {
            Oferta oferta = new Oferta(view.getCurrentUser(), view.getSelectedProduct(), view.getMontoOferta());
            if (!model.ofertaAceptada(oferta)) {
                view.offerDeclined();
            } else {
                view.offerAccepted();
                view.addEstasGanandoProduct(view.getSelectedProduct());
            }
        } else if (e.getActionCommand().equals("Actualizar lista productos a comprar")) {
            ArrayList<Producto> productosEnVenta = model.obtieneCatalogoActivo();
            System.out.println("Updating catalogue");
            view.updateListComprasPossibles(productosEnVenta);

        } else if (e.getActionCommand().equals("Actualizar lista apuesta más")) {
            String[] arrayGanando = view.getEstasGanando();
            ArrayList<String> tienesQueApostarMas = new ArrayList<>();
            for (String s : arrayGanando) {
                if (!model.sigueGanando(view.getCurrentUser(), s)) {
                    tienesQueApostarMas.add(s);
                }
            }
            view.updateListApuestaMas(tienesQueApostarMas);
        } else if (e.getActionCommand().equals("Mandar contraoferta")) {
            Oferta oferta = new Oferta(view.getCurrentUser(), view.getSelectedProduct(), view.getMontoContraOferta());
            if (!model.ofertaAceptada(oferta)) {
                view.offerDeclined();
            } else {
                view.offerAccepted();
                view.addEstasGanandoProduct(view.getSelectedProduct());
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>) e.getSource();
        String item = list.getSelectedValue();
        System.out.println("Value changed");
        if (list == view.getListaVentasEnCurso())
            if (item != null) {
                System.out.println(item);
                Producto prod = model.getThisProduct(item);
                view.setSelectedSellingProduct(prod); //use selectedProduct to uddate only selected info
            }
    }
}
