import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainVista {

    private Usuario currentUser;
    JFrame principal;
    JPanel panel;
    JTextArea welcome;
    JMenuBar mb;

    // acceder a la tienda
    JMenu accederALaTienda;
    JMenuItem conectarse;

    // comprar
    JMenu comprar;
    JMenuItem adquirirUnProd;
    JMenu misCompras;
    JMenuItem ganando;
    JMenuItem apuestaMas;
    JMenuItem ganaste;
    JMenuItem perdiste;

    //vender
    JMenu vender;
    JMenuItem venderUnProducto;
    JMenu misVentas;
    JMenuItem enCurso;
    JMenuItem acabadas;



    public MainVista() {
        principal = new JFrame("Gato shop");
        panel = new JPanel();

        //Menubar
        mb = new JMenuBar();
        accederALaTienda = new JMenu("Acceder a la tienda");
        mb.add(accederALaTienda);
        principal.setJMenuBar(mb);

        //Menuitem
        conectarse = new JMenuItem("Registrarse");
        accederALaTienda.add(conectarse);

        //Text
        welcome = new JTextArea(20, 60);
        welcome.setEditable(false);
        welcome.setText("Bienvenido a Gato Shop! \n" +
                "Registrate para conectarte a la tienda.\n");
        panel.add(welcome);
        principal.add(panel);

        principal.addWindowListener(new CloseHandler());
        principal.pack();
        principal.setVisible(true);

    }

    public void setCurrentUser(Usuario currentUser) {
        this.currentUser = currentUser;
    }

    public void asignarActionListener(ActionListener controlador) {
        conectarse.addActionListener(controlador);
    }

    public void updateMenuBar() {
        System.out.println("pasa por aquí");
        mb.remove(accederALaTienda);
        principal.setJMenuBar(mb);

        comprar = new JMenu("Comprar");
        vender = new JMenu("Vender");
        mb.add(comprar);
        mb.add(vender);
        principal.setJMenuBar(mb);

        //comprar

        adquirirUnProd = new JMenuItem("Adquirir un producto");
        misCompras = new JMenu("Mis compras");
        ganando = new JMenuItem("Ganando");
        apuestaMas = new JMenuItem("Apuesta mas");
        ganaste = new JMenuItem("Ganaste");
        perdiste = new JMenuItem("Perdiste");

        comprar.add(adquirirUnProd);
        comprar.add(misCompras);
        misCompras.add(ganando);
        misCompras.add(apuestaMas);
        misCompras.addSeparator();
        misCompras.add(ganaste);
        misCompras.add(perdiste);

        // vender


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
