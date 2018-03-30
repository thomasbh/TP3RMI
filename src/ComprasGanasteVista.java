import javax.swing.*;
import java.awt.*;

public class ComprasGanasteVista {

    private Usuario user;
    private JFrame principal;
    private DefaultComboBoxModel productos;
    private JLabel labelLista;
    private JList listaProductosGanados;

    public ComprasGanasteVista(Usuario usuario) {
        user = usuario;
        principal = new JFrame("Productos que ganaste");

        Container panel;
        panel = principal.getContentPane();
        panel.setLayout(new BorderLayout());
        labelLista = new JLabel("Selecciona uno de tus productos para ver a qué precio lo adquiriste y para contactar al vendedor.");
        panel.add(labelLista, BorderLayout.NORTH);
        productos = new DefaultComboBoxModel();
        listaProductosGanados = new JList(productos);
        listaProductosGanados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProductosGanados.setLayoutOrientation(JList.VERTICAL);
        JScrollPane listaScroller = new JScrollPane(listaProductosGanados);
        listaScroller.setPreferredSize(new Dimension(250, 80));
        panel.add(listaScroller, BorderLayout.CENTER);
        principal.pack();
        principal.setSize(400, 400);
        principal.setVisible(true);
    }

    public void agregaProducto(Producto prod) {

        productos.addElement(prod.getNombre());
    }
}
