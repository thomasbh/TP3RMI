import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControlador implements ActionListener {

    MainVista view;
    MainModelo model;


    public MainControlador(MainVista v, MainModelo m) {
        view = v;
        model = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registrarse")) {
            CreacionUsuarioVista view2 = new CreacionUsuarioVista();
            view2.setVisible(true);
            CreacionUsuarioControlador ctrl2 = new CreacionUsuarioControlador(view2, model);
            view2.asignarActionListener(ctrl2);
            view.setCurrentUser(model.getLastUser());
            System.out.println("hola");
            view.updateMenuBar();
            System.out.println("hola 1");

        }

    }
}
