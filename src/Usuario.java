public class Usuario {
    private String nombre;
    private String direccion;
    private String correo;
    private int telefono;
    private String apodo;

    public Usuario(String nombre, String direccion, String correo, int telefono, String apodo) {
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

    public int getTelefono() {
        return telefono;
    }

    public String getApodo() {
        return apodo;
    }
}
