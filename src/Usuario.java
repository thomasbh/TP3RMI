import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String direccion;
    private String correo;
    private long telefono;
    private String apodo;
    private ArrayList vende;

    public Usuario(String nombre, String direccion, String correo, long telefono, String apodo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.apodo = apodo;
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

    public long getTelefono() {
        return telefono;
    }

    public String getApodo() {
        return apodo;
    }
}
