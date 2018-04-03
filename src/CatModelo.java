import java.util.*;

public class CatModelo {

    Hashtable usuarios;
    Hashtable productos;
    Hashtable ventasEnCurso;
    Hashtable ventasAcabadas;
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

    public ArrayList<Producto> obtieneCatalogoActivo() {
        ArrayList<Producto> productosActivos = new ArrayList<>();

        for (Object o : productos.values()) {
            Producto p = (Producto) o;
            if (p.getLimite().compareTo(Calendar.getInstance()) <= 0) {
                productosActivos.add(p);
            }
        }
        return productosActivos;
    }

    public ArrayList<Producto> obtieneProductosExpirados() {
        ArrayList<Producto> productosExpirados = new ArrayList<>();

        for (Object o : productos.values()) {
            Producto p = (Producto) o;
            if (p.getLimite().compareTo(Calendar.getInstance()) >= 0) {
                productosExpirados.add(p);
            }
        }
        return productosExpirados;
    }

    public List<Producto> getProductosGanados(Usuario user) {
        ArrayList<Producto> productosGanados = new ArrayList<>();
        for (Producto p : obtieneProductosExpirados()) {
            if (p.getGanador() == user) {
                productosGanados.add(p);
            }
        }
        return productosGanados;
    }

    public List<Producto> getProductosPerdidos(Usuario user) {
        ArrayList<Producto> productosPerdidos = new ArrayList<>();
        for (Producto p : obtieneProductosExpirados()) {
            if (p.getGanador() != user) {
                productosPerdidos.add(p);
            }
        }
        return productosPerdidos;
    }

    public boolean sigueGanando(Usuario u, String prodAComprobar) {
        Producto productoAComprobar = (Producto) productos.get(prodAComprobar);
        List<Oferta> ofertasOnThisProd = productoAComprobar.getOfertas();
        // if the last offer on this product is of the same buyer, return true
        if (ofertasOnThisProd.get(ofertasOnThisProd.size() - 1).getCompradorPotencial() == u) {
            return true;
        } else {
            return false;
        }
    }
}