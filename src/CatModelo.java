import java.util.Hashtable;
import java.util.Vector;

public class CatModelo {

    Hashtable usuarios;
    Hashtable productos;
    Hashtable ofertas;

    public CatModelo() {

        usuarios = new Hashtable();
        productos = new Hashtable();
        ofertas = new Hashtable();
    }

    public boolean registraUsuario(Usuario user) {

        if (!usuarios.containsKey(user.getApodo())) {

            System.out.println("Agregando un nuevo usuario: " + user.getNombre());
            usuarios.put(user.getApodo(), user);
            return true;

        } else

            return false;
    }

    public boolean ventaPermitida(Producto producto) {
        if (!productos.containsKey(producto.getNombre())) {

            System.out.println("Agregando un nuevo producto: " + producto.getNombre());
            productos.put(producto.getNombre(), producto);
            return true;

        } else

            return false;
    }

    public boolean ofertaAceptada(Oferta oferta) {

        if (productos.containsValue(oferta.getProducto())) {

            Producto prod = oferta.getProducto();

            if (prod.actualizaPrecio(oferta.getMontoOferta())) {

                prod.addOferta(oferta);
                if (ofertas.contains(prod.getNombre())) {
                    ofertas.replace(prod.getNombre(), oferta);
                } else {
                    ofertas.put(prod.getNombre(), oferta);
                }

                return true;

            } else

                return false;

        } else

            return false;
    }

    public Producto getThisProduct(String name) {
        Producto wanted = (Producto) productos.get(name);
        return wanted;
    }

    public Usuario getThisUser(String nickname) {
        Usuario user = (Usuario) usuarios.get(nickname);
        return user;
    }

    public Vector obtieneCatalogo() {

        Vector resultado;

        resultado = new Vector(productos.values());

        return resultado;
    }
}