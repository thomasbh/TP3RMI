import java.util.ArrayList;
import java.util.List;

public class ComprasGanasteControlador {

    ComprasGanasteVista view;
    MainModelo modelo;

    public ComprasGanasteControlador(ComprasGanasteVista v, MainModelo m) {
        view = v;
        modelo = m;
    }

    public List<Producto> getProductosGanados(Usuario user) {
        ArrayList<Producto> productosGanados = new ArrayList<>();
        for (Producto p : modelo.obtieneProductosExpirados()) {
            if (p.getGanador() == user) {
                productosGanados.add(p);
            }
        }

        return productosGanados;
    }
}