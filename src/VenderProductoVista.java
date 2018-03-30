import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;

public class VenderProductoVista extends JFrame  {

    JFrame venderProductos = new JFrame("Vender Productos");
    //Con la variable Font pones tipo y tamaño de letra
    Font fondo = new Font("Arial", Font.BOLD,15);
    Font fondo1 = new Font("Arial", Font.BOLD, 25);

    Button botonSalva;
    Button botonElimina;

    JTextArea areaNombre;
    JTextArea areaDescripcion;
    JTextArea areaFechaLimite;
    JTextArea areaPrecio;

    JLabel etiquetaNombre;
    JLabel etiquetaDescripcion;
    JLabel etiquetaFechalimite;
    JLabel etiquetaPrecio;
    JLabel etiquetaVendeProducto;

    public VenderProductoVista(){

        venderProductos.setSize(650,350);
        venderProductos.getContentPane().setBackground(Color.lightGray);
        venderProductos.setLocationRelativeTo(null);
        venderProductos.setLayout(null);
        venderProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creacion botones

        botonSalva = new Button("Salvar");
        botonElimina = new Button("Elimina");

        //tamaño y color de botones

        botonSalva.setBounds(425, 260, 110, 35);
        botonSalva.setForeground(Color.gray);
        botonElimina.setBounds(125, 260, 110, 35);
        botonElimina.setForeground(Color.gray);


        // Añado boton


        venderProductos.add(botonElimina);
        venderProductos.add(botonSalva);


        // Creacion area de Texto

        areaNombre = new JTextArea();
        areaDescripcion = new JTextArea();
        areaFechaLimite = new JTextArea();
        areaPrecio = new JTextArea();

        //Tamaño del area de Texto con borde negro

        areaNombre.setBounds(300, 50, 200, 20);
        areaNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDescripcion.setBounds(300, 80, 100, 20);
        areaDescripcion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaFechaLimite.setBounds(300, 110, 200, 20);
        areaFechaLimite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecio.setBounds(300,140, 100, 20);
        areaPrecio.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Añado area de Texto

        venderProductos.add(areaNombre);
        venderProductos.add(areaDescripcion);
        venderProductos.add(areaFechaLimite);
        venderProductos.add(areaPrecio);

        //Creacion de Etiquetas

        etiquetaNombre = new JLabel("Nombre del Producto:");
        etiquetaDescripcion = new JLabel("Descripción:");
        etiquetaFechalimite = new JLabel("Fecha Límite:");
        etiquetaPrecio = new JLabel("Precio Inicial:");
        etiquetaVendeProducto = new JLabel("Vende tu Producto");

        // Tamaño de etiqueta y tipo y tamaño de letra

        etiquetaNombre.setBounds(100, 50, 200, 20);
        etiquetaNombre.setFont(fondo);
        etiquetaDescripcion.setBounds(100, 80, 100, 20);
        etiquetaDescripcion.setFont(fondo);
        etiquetaFechalimite.setBounds(100, 110, 200, 20);
        etiquetaFechalimite.setFont(fondo);
        etiquetaPrecio.setBounds(100,140, 100, 20);
        etiquetaPrecio.setFont(fondo);
        etiquetaVendeProducto.setBounds(190,10,300,20);
        etiquetaVendeProducto.setFont(fondo1);

        //  Añado etiqueta

        venderProductos.add(etiquetaNombre);
        venderProductos.add(etiquetaDescripcion);
        venderProductos.add(etiquetaFechalimite);
        venderProductos.add(etiquetaPrecio);
        venderProductos.add(etiquetaVendeProducto);

        //Para ver la ventana
        venderProductos.setVisible(true);


    }
}
