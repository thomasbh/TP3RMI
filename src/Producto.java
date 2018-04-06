import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Producto implements Serializable {

    private String nombre;
    private String descripcion;
    private Calendar inicio;
    private Calendar limite;
    private float precioInicial;
    private float precioActual;
    private Usuario vendedor;
    private Usuario ganador;
    private ArrayList<Oferta> ofertas = new ArrayList<>();

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

    public ArrayList<Oferta> getOfertas() {
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
        Oferta lastoferta;
        if (!ofertas.isEmpty()) {
            lastoferta = ofertas.get(ofertas.size() - 1);
            ganador = lastoferta.getCompradorPotencial();
        } else
            ganador = null;
    }

    public void addOferta(Oferta oferta) {
        ofertas.add(oferta);
    }

    public boolean actualizaPrecio(float monto) {

        if (monto > precioActual) {
            precioActual = monto;
            System.out.println("Nuevo precio: " + precioActual);
            return true;
        } else
            return false;
    }

    public Usuario getLastUsuario() {
        return ofertas.get(ofertas.size() - 1).getCompradorPotencial();
    }

    public ArrayList<Usuario> getUsuariosInteresados() {
        ArrayList<Usuario> usuariosInteresados = new ArrayList<>();
        for (Oferta oferta : ofertas) {
            if (!usuariosInteresados.contains(oferta.getCompradorPotencial())) {
                usuariosInteresados.add(oferta.getCompradorPotencial());
            }
        }
        return usuariosInteresados;
    }

}
