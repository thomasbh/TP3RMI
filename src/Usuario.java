import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    private String apodo;
    private ArrayList vende;

    public Usuario(String nombre, String direccion, String correo, String telefono, String apodo) {
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

    public String getTelefono() {
        return telefono;
    }

    public String getApodo() {
        return apodo;
    }
}
