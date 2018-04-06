import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    private String apodo;
    private ArrayList vende;
    private ClientInterface hisInterface;

    public Usuario(String nombre, String direccion, String correo, String telefono, String apodo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.apodo = apodo;
    }

    public Usuario(String nombre, String direccion, String correo, String telefono, String apodo, ClientInterface clientInterface) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.apodo = apodo;
        this.hisInterface = clientInterface;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getApodo() {
        return apodo;
    }

    public ClientInterface getHisInterface() {
        return hisInterface;
    }

    public void setHisInterface(ClientInterface hisInterface) {
        this.hisInterface = hisInterface;
    }
}
