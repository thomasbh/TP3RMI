
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class SubastaModelo {

    ArrayList<Usuario> usuarios;
    ArrayList<Producto> productos;
    ArrayList<Oferta> ofertas;

    public SubastaModelo() {

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

    public ArrayList obtieneCatalogo() {

        return productos;
    }
}
