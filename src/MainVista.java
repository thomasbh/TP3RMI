import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainVista {

    private Usuario currentUser;
    JFrame principal;
    JPanel panel;
    JTextArea welcome;
    JMenuBar mb;
    JMenu connect;
    JMenuItem conectarse;


    public MainVista() {
        principal = new JFrame("Gato shop");
        panel = new JPanel();

        //Menubar
        mb = new JMenuBar();
        connect = new JMenu("Acceder a la tienda");
        mb.add(connect);
        principal.setJMenuBar(mb);

        //Menuitem
        conectarse = new JMenuItem("Registrarse");
        connect.add(conectarse);

        //Text
        welcome = new JTextArea(20, 60);
        welcome.setEditable(false);
        welcome.setText("Bienvenido a Gato Shop! \n" +
                "Registrate para conectarte a la tienda.\n");
        principal.add(panel);

        principal.addWindowListener(new CloseHandler());
        principal.pack();
        principal.setVisible(true);

    }


    public void asignarActionListener(ActionListener controlador) {
        conectarse.addActionListener(controlador);
    }


    /*---------------------------------------------------------------------
     * classes used in main Window
     *--------------------------------------------------------------------*/
    private class CloseHandler extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
