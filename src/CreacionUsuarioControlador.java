import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionUsuarioControlador implements ActionListener {

    CreacionUsuarioVista view;

    public CreacionUsuarioControlador(CreacionUsuarioVista v) {
        view = v;
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equals("Cancelar")) {
            System.exit(1);
        } else if (evento.getActionCommand().equals("Validar")) {
            Usuario user = new Usuario(view.getNombre(), view.getDireccion(), view.getCorreo(), view.getTelefono(), view.getApodo());
        }
    }
}
