import java.util.Date;
import java.util.List;

public class Producto {

    private int clave;
    private String nombre;
    private String descripcion;
    private Date limite;
    private float precio;
    private Usuario vendedor;
    private Usuario ganador;
    private List<Oferta> ofertas;

    public Producto(int clave, String nombre, String descripcion, Date limite, float precio, Usuario vendedor) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.limite = limite;
        this.precio = precio;
        this.vendedor = vendedor;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getLimite() {
        return limite;
    }

    public float getPrecio() {
        return precio;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void addOferta(Usuario usuario, float precio) {
        Oferta oferta = new Oferta(usuario, this, precio);
        ofertas.add(oferta);
    }
}
