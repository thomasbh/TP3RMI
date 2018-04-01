
public class Principal {

    public static void main(String args[]) {

        CatShopView catshopview = new CatShopView();
        CatModelo modelo = new CatModelo();
        Catroller controlador = new Catroller(catshopview, modelo);
        catshopview.asignarActionListener(controlador);
        catshopview.asignarListSelectionListener(controlador);


        //vista.asignarActionListener(controlador);
        //vista.asignarListSelectionListener(controlador);
    }
}
