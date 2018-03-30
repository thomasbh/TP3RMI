import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionUsuarioControlador implements ActionListener {

    CreacionUsuarioVista view;
    MainModelo model;

    public CreacionUsuarioControlador(CreacionUsuarioVista v, MainModelo m) {
        view = v;
        model = m;
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equals("Cancelar")) {
            System.exit(1);
        } else if (evento.getActionCommand().equals("Validar")) {
            Usuario user = new Usuario(view.getNombre(), view.getDireccion(), view.getCorreo(), view.getTelefono(), view.getApodo());
            if (!model.registraUsuario(user)) {
                view.errorCreatingUser();
            } else {
                view.setVisible(false);
            }
            ;
        }
    }
}
