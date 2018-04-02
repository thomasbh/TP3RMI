import java.util.Calendar;
import java.util.List;

public class Producto {

    private String nombre;
    private String descripcion;
    private Calendar inicio;
    private Calendar limite;
    private float precioInicial;
    private float precioActual;
    private Usuario vendedor;
    private Usuario ganador;
    private List<Oferta> ofertas;

    public Producto(String nombre, String descripcion, int tiempoAgregar, float precio, Usuario vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = Calendar.getInstance();
        limite = inicio;
        limite.add(Calendar.SECOND, tiempoAgregar);
        precioInicial = precio;
        precioActual = precioInicial;
        this.vendedor = vendedor;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public Calendar getLimite() {
        return limite;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecioInicial() {
        return precioInicial;
    }

    public float getPrecioActual() {
        return precioActual;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void setGanador() {
        Oferta lastoferta = ofertas.get(ofertas.size() - 1);
        ganador = lastoferta.getCompradorPotencial();
    }

    public void addOferta(Oferta oferta) {
        //Oferta oferta = new Oferta(usuario, this, precio);
        ofertas.add(oferta);
    }

    public boolean actualizaPrecio(float monto) {

        if (monto > precioActual) {
            precioActual = monto;
            return true;
        } else
            return false;
    }
}
