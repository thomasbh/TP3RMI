import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionUsuarioControlador implements ActionListener {


    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equals("Cancelar")) {
            System.exit(1);
        } else if (evento.getActionCommand().equals("Validar")) {

        }
    }
}
