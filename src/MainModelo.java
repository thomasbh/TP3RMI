
import java.util.ArrayList;
import java.util.Calendar;

public class MainModelo {

    ArrayList<Usuario> usuarios;
    ArrayList<Producto> productos;
    ArrayList<Oferta> ofertas;

    public MainModelo() {

        usuarios = new ArrayList<>();
        productos = new ArrayList<>();
        ofertas = new ArrayList<>();
    }

    public boolean registraUsuario(Usuario user) {

        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                if (usuario.getApodo() == user.getApodo())
                    return false; // not a new nickname
            }
        }
        System.out.println("Agregando un nuevo usuario de apodo: " + user.getApodo());
        usuarios.add(user);
        return true;
    }

    public boolean agregaProductoALaVenta(Producto p) {

        if (!productos.isEmpty()) {
            for (Producto prod : productos) {
                if (prod.getNombre().equals(p.getNombre()))
                    return false; // not a new product name
            }
        }

        System.out.println("Agregando un nuevo producto: " + p.getNombre());
        productos.add(p);
        return true;
        /*
        if (!productos.containsKey(producto)) {

            System.out.println("Agregando un nuevo producto: " + producto);
            productos.put(producto,
                    new InformacionProducto(vendedor,
                            producto,
                            precioInicial));
            return true;

        } else

            return false;
            */
    }

    public boolean agregaOferta(Oferta oferta) {
        /*
        if (!ofertas.isEmpty()) {
            for (Oferta of : ofertas) {
                if (prod.getNombre().equals(p.getNombre()))
                    return false; // not a new product name
            }
        }

        System.out.println("Agregando un nuevo producto: " + p.getNombre());
        productos.add(p);
        return true;

        if (productos.containsKey(producto)) {

            InformacionProducto infoProd;
            infoProd = (InformacionProducto) productos.get(producto);

            if (infoProd.actualizaPrecio(monto)) {

                ofertas.put(producto + comprador,
                        new InformacionOferta(comprador,
                                producto,
                                monto));
                return true;

            } else

                return false;

        } else

            return false;
            */
        return true;
    }

    public ArrayList<Producto> obtieneCatalogoActivo() {
        ArrayList<Producto> productosActivos = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getLimite().compareTo(Calendar.getInstance()) <= 0) {
                productosActivos.add(p);
            }
        }
        return productosActivos;
    }

    public ArrayList<Producto> obtieneProductosExpirados() {
        ArrayList<Producto> productosExpirados = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getLimite().compareTo(Calendar.getInstance()) >= 0) {
                productosExpirados.add(p);
            }
        }
        return productosExpirados;
    }


    public Usuario getLastUser() {
        int sizeOfList = usuarios.size();
        return usuarios.get(sizeOfList - 1);
    }
}
