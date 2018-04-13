
public class Principal {

    public static void main(String args[]) {

        CatShopView catshopview = new CatShopView();
        Meowdelo modelo = new Meowdelo();
        Catroller controlador = new Catroller(catshopview, modelo);
        catshopview.asignarActionListener(controlador);
        catshopview.asignarListSelectionListener(controlador);

    }
}
