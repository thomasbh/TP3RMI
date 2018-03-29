import java.util.Date;

public class Oferta {
    private String apodoUsuario;
    private int claveDelProducto;
    private Date fechaOferta;
    private float montoOferta;

    public Oferta(Usuario usuario, Producto producto, float montoOferta) {
        apodoUsuario = usuario.getApodo();
        claveDelProducto = producto.getClave();
        Date now = new Date();
        fechaOferta = now;
        this.montoOferta = montoOferta;
    }


}
