import java.util.Calendar;

public class Oferta {
    private Usuario compradorPotencial;
    private Producto producto;
    private Calendar fechaOferta;
    private float montoOferta;

    public Oferta(Usuario usuario, Producto prod, float montoOferta) {
        compradorPotencial = usuario;
        Calendar now = Calendar.getInstance();
        fechaOferta = now;
        producto = prod;
        this.montoOferta = montoOferta;
    }

    public Usuario getCompradorPotencial() {
        return compradorPotencial;
    }

    public Producto getProducto() {
        return producto;
    }

    public Calendar getFechaOferta() {
        return fechaOferta;
    }

    public float getMontoOferta() {
        return montoOferta;
    }
}