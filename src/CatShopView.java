import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import java.awt.Font;

public class CatShopView {

    JFrame catshop = new JFrame("Cat Shop");
    //Con la variable Font pones tipo y tamaño de letra
    Font fondo = new Font("Arial", Font.BOLD,15);
    Font fondo1 = new Font("Arial", Font.BOLD, 35);
    Font fondo2 = new Font("Arial", Font.BOLD, 20);


    //registrar usuario botones
    Button botonEliminar;
    Button botonConectarse;

    //vender producto botones
    Button botonVender;
    Button botonElimina;

    // Mis compras en curso - Apuesta mas
    Button botonMandar;

    //comprar un producto botones
    Button botonMandarOferta;

////////////////////////////////////////////////////////////////////////////

    // registrar usuario area
    JTextArea areaUserName;
    JTextArea areaDireccion;
    JTextArea areaTelefono;
    JTextArea areaCorreo;
    JTextArea areaNombreUsuario;

    //vender producto area
    JTextArea areaNombre;
    JTextArea areaDescripcion;
    JTextArea areaTiempoLimite;
    JTextArea areaPrecioInicial;

////////////////////////////////////////////////////////////////////////////

    //registrar usuario etiquetas
    JLabel etiquetaUserName;
    JLabel etiquetaDireccion;
    JLabel etiquetaTelefono;
    JLabel etiquetaCorreo;
    JLabel etiquetaNombreUsuario;

    //vender un producto etiquetas
    JLabel etiquetaNombre;
    JLabel etiquetaDescripcion;
    JLabel etiquetaTiempoimite;
    JLabel etiquetaPrecio;

    //comprar un producto
    JLabel etiquetaName;
    JLabel etiquetaDescripcionProduc;
    JLabel etiquetaVendedor;
    JLabel etiquetaPrecioActual;

    // mis compras en curso etiquetas
    JLabel etiquetaApuestaMas;
    JLabel etiquetaEstasGanando;
    JLabel etiquetaPrecioActualApuestaMas;
    JLabel etiquetaPrecioActualEstasGanando;

    //mis ventas etiquetas
    JLabel etiquetaEnCurso;
    JLabel etiquetaNombreMisVentas;
    JLabel etiquetaDescripcionMisVentas;
    JLabel etiquetaPrecioActualMisVentas;
    JLabel etiquetaTiempoRestante;
    JLabel etiquetaAcabadas;
    JLabel etiquetaVendidoA;
    JLabel etiquetaTelefonoAcabadas;
    JLabel etiquetaCorreoAcabadas;
    JLabel etiquetaPreciodeVenta;

    //mis compras acabadas
    JLabel etiquetaGane;
    JLabel etiquetaContactodelVendedor;
    JLabel etiquetaTelefonodelVendedor;
    JLabel etiquetaCorreodelVendedor;
    JLabel etiquetaPrecioFinal;
    JLabel etiquetaPerdi;
    JLabel etiquetaVendidoAPrecio;

    // titulos etiqueta
    JLabel etiquetaCatShop;
    JLabel etiquetaRegistrarUsuario;
    JLabel etiquetaVenderunProducto;
    JLabel etiquetaMisVentas;
    JLabel etiquetaComprarunProducto;
    JLabel etiquetaMisComprasenCurso;
    JLabel etiquetaMisComprasAcabadas;

////////////////////////////////////////////////////////////////////////////

    public CatShopView(){

        catshop.setSize(1450,1450);
        catshop.getContentPane().setBackground(Color.lightGray);
        catshop.setLocationRelativeTo(null);
        catshop.setLayout(null);
        catshop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/////////////////////////////BOTONES REGISTRAR USUARIO//////////////////////////////////////////////////////////////////

        // registrar usuario creacion botones
        botonConectarse = new Button("Conectarse");
        botonEliminar = new Button("Eliminar");

        //registrar usuario tamaño y color de botones
        botonConectarse.setBounds(15, 250, 110, 35);
        botonConectarse.setForeground(Color.gray);
        botonEliminar.setBounds(135, 250, 110, 35);
        botonEliminar.setForeground(Color.gray);

        //registrar usuario Añado boton
        catshop.add(botonEliminar);
        catshop.add(botonConectarse);

/////////////////////////////BOTONES VENDER PRODUCTO////////////////////////////////////////////////////////////////////

        //vender producto botones
        botonVender = new Button("Vender");
        botonElimina = new Button("Elimina");

        //vender producto tamaño y color de botones
        botonVender.setBounds(450, 250, 110, 35);
        botonVender.setForeground(Color.gray);
        botonElimina.setBounds(585, 250, 110, 35);
        botonElimina.setForeground(Color.gray);

        //vender producto añado botones
        catshop.add(botonVender);
        catshop.add(botonElimina);


////////////////////////////////AREA REGISTRAR USUARIO//////////////////////////////////////////////////////////////////

        // registrar usuario Creacion area de Texto
        areaUserName = new JTextArea();
        areaDireccion = new JTextArea();
        areaTelefono = new JTextArea();
        areaCorreo = new JTextArea();
        areaNombreUsuario = new JTextArea();

        //registrar usuario Tamaño del area de Texto con borde negro
        areaUserName.setBounds(100, 85, 200, 20);
        areaUserName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDireccion.setBounds(100, 115, 200, 20);
        areaDireccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefono.setBounds(100, 145, 200, 20);
        areaTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreo.setBounds(100,175, 200, 20);
        areaCorreo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaNombreUsuario.setBounds(100,205, 200, 20);
        areaNombreUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //registrar usuario Añado area de Texto
        catshop.add(areaUserName);
        catshop.add(areaDireccion);
        catshop.add(areaTelefono);
        catshop.add(areaCorreo);
        catshop.add(areaNombreUsuario);

//////////////////////////////////AREA VENDER PRODUCTO//////////////////////////////////////////////////////////////////

        // vender producto Creacion area de Texto
        areaNombre = new JTextArea();
        areaDescripcion = new JTextArea();
        areaTiempoLimite = new JTextArea();
        areaPrecioInicial = new JTextArea();

        //vender producto Tamaño del area de Texto con borde negro
        areaNombre.setBounds(570, 95, 200, 20);
        areaNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDescripcion.setBounds(570, 125, 200, 20);
        areaDescripcion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTiempoLimite.setBounds(570, 155, 200, 20);
        areaTiempoLimite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioInicial.setBounds(570,185, 200, 20);
        areaPrecioInicial.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //vender producto Añado area de Texto
        catshop.add(areaNombre);
        catshop.add(areaDescripcion);
        catshop.add(areaTiempoLimite);
        catshop.add(areaPrecioInicial);

//////////////////////////////////ETIQUETAS REGISTRAR USUARIO///////////////////////////////////////////////////////////

        //registrar usuario Creacion de Etiquetas
        etiquetaUserName = new JLabel("User Name:");
        etiquetaDireccion = new JLabel("Dirección:");
        etiquetaTelefono = new JLabel("Telefono:");
        etiquetaCorreo = new JLabel("Correo:");
        etiquetaNombreUsuario = new JLabel("Nombre:");

        // registrar usuario Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaUserName.setBounds(10, 85, 200, 20);
        etiquetaUserName.setFont(fondo);
        etiquetaDireccion.setBounds(10, 115, 100, 20);
        etiquetaDireccion.setFont(fondo);
        etiquetaTelefono.setBounds(10, 145, 200, 20);
        etiquetaTelefono.setFont(fondo);
        etiquetaCorreo.setBounds(10,175, 100, 20);
        etiquetaCorreo.setFont(fondo);
        etiquetaNombreUsuario.setBounds(10,205, 100, 20);
        etiquetaNombreUsuario.setFont(fondo);

        //  registrar usuario Añado etiqueta
        catshop.add(etiquetaUserName);
        catshop.add(etiquetaDireccion);
        catshop.add(etiquetaTelefono);
        catshop.add(etiquetaCorreo);
        catshop.add(etiquetaNombreUsuario);

//////////////////////////////////ETIQUETAS VENDER PRODUCTO/////////////////////////////////////////////////////////////

        //vender producto Creacion de Etiquetas
        etiquetaNombre = new JLabel("Nombre:");
        etiquetaDescripcion = new JLabel("Descripción:");
        etiquetaTiempoimite = new JLabel("Tiempo Limite:");
        etiquetaPrecio = new JLabel("Precio Inicial:");

        //vender producto Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaNombre.setBounds(450, 95, 200, 20);
        etiquetaNombre.setFont(fondo);
        etiquetaDescripcion.setBounds(450, 125, 100, 20);
        etiquetaDescripcion.setFont(fondo);
        etiquetaTiempoimite.setBounds(450, 155, 200, 20);
        etiquetaTiempoimite.setFont(fondo);
        etiquetaPrecio.setBounds(450,185, 100, 20);
        etiquetaPrecio.setFont(fondo);

        //vender producto Añado etiqueta
        catshop.add(etiquetaNombre);
        catshop.add(etiquetaDescripcion);
        catshop.add(etiquetaTiempoimite);
        catshop.add(etiquetaPrecio);

//////////////////////////////////ETIQUETAS TITULO//////////////////////////////////////////////////////////////////////
        // Creacion Etiquetas titulo
        etiquetaCatShop = new JLabel("Cat Shop");
        etiquetaRegistrarUsuario = new JLabel("Registrar Usuario");
        etiquetaVenderunProducto = new JLabel("Vender un Producto");

        //titulo Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaCatShop.setBounds(650,10,350,45);
        etiquetaCatShop.setFont(fondo1);
        //etiquetaCatShop.setForeground(Color.orange);
        etiquetaRegistrarUsuario.setBounds(10, -35,200,200);
        etiquetaRegistrarUsuario.setFont(fondo2);
        etiquetaVenderunProducto.setBounds(450, -35,200,200);
        etiquetaVenderunProducto.setFont(fondo2);

        // titulo añado etiquetas
        catshop.add(etiquetaCatShop);
        catshop.add(etiquetaRegistrarUsuario);
        catshop.add(etiquetaVenderunProducto);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Para ver la ventana
        catshop.setVisible(true);


    }
}