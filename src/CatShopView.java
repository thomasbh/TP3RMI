import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CatShopView {

    //other

    Usuario currentUser;
    Producto selectedProduct;
    DefaultListModel<String> modelMisVentasEnCurso;
    DefaultListModel<String> modelMisVentasAcabadas;
    DefaultListModel<String> modelCatalogoProductos;
    DefaultListModel<String> modelApuestaMas;
    DefaultListModel<String> modelEstasGanando;
    DefaultListModel<String> modelComprasGanadas;
    DefaultListModel<String> modelComprasPerdidas;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    // window

    JFrame catshop = new JFrame("CatShop");
    //Con la variable Font pones tipo y tamaño de letra
    Font fondo = new Font("Arial", Font.BOLD,15);
    Font fondo1 = new Font("Arial", Font.BOLD, 35);
    Font fondo2 = new Font("Arial", Font.BOLD, 20);
    Font fondo3 = new Font("Arial", Font.BOLD, 18);


    //registrar usuario botones
    Button botonSalir;
    Button botonConectarse;

    //vender producto botones
    Button botonVender;
    Button botonVaciarCamposVender;

    // Mis compras en curso - Apuesta mas
    Button botonApostarMas;

    //comprar un producto botones
    Button botonMandarOferta;

////////////////////////////////////////////////////////////////////////////

    // registrar usuario area
    JTextArea areaRealName;
    JTextArea areaDireccion;
    JTextArea areaTelefono;
    JTextArea areaCorreo;
    JTextArea areaNombreUsuario;

    //vender producto area
    JTextArea areaVenderProductName;
    JTextArea areaVenderProductDescripcion;
    JTextArea areaVenderTiempoLimite;
    JTextArea areaVenderPrecioInicial;

    // mis ventas area
    JList<String> listaVentasEnCurso;
    JTextArea areaNombreMisVentas;
    JTextArea areaDescripcionMisVentas;
    JTextArea areaPrecioActualMisVentas;
    JTextArea areaTiempoRestanteMisVentas;
    JList<String> listaVentasAcabadas;
    JTextArea areaVendidoA;
    JTextArea areaTelefonoAcabadas;
    JTextArea areaCorreoAcabadas;
    JTextArea areaPreciodeVenta;

    //comprar un Producto

    JList<String> listaProductosCatalogo;
    JTextArea areaName;
    JTextArea areaDescripcionProduc;
    JTextArea areaVendedor;
    JTextArea areaPrecioActual;
    JTextArea areaOferta;

    //Mis compras en curso
    JList<String> listadeApuestaMas;
    JList<String> listadeEstasGanando;
    JTextArea areaMandarOferta;
    JTextArea areaPrecioActualApuestaMas;
    JTextArea areaPrecioActualEstasGanando;

    // Mis compras acabadas
    JList<String> listaGane;
    JList<String> listaPerdi;
    JTextArea areaTelefonoGane;
    JTextArea areaCorreoGane;
    JTextArea areaPrecioGane;
    JTextArea areaPrecioPerdi;




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


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public CatShopView(){

        catshop.setSize(1450,1450);
        catshop.getContentPane().setBackground(Color.lightGray);
        catshop.setLocationRelativeTo(null);
        catshop.setLayout(null);
        catshop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/////////////////////////////BOTONES REGISTRAR USUARIO//////////////////////////////////////////////////////////////////

        // registrar usuario creacion botones
        botonConectarse = new Button("Conectarse");
        botonSalir = new Button("Eliminar");

        //registrar usuario tamaño y color de botones
        botonConectarse.setBounds(15, 325, 110, 35);
        botonConectarse.setForeground(Color.gray);
        botonSalir.setBounds(185, 325, 110, 35);
        botonSalir.setForeground(Color.gray);

        //registrar usuario Añado boton
        catshop.add(botonSalir);
        catshop.add(botonConectarse);

/////////////////////////////BOTONES VENDER PRODUCTO////////////////////////////////////////////////////////////////////

        //vender producto botones
        botonVender = new Button("Vender");
        botonVaciarCamposVender = new Button("Elimina");

        //vender producto tamaño y color de botones
        botonVender.setBounds(490, 325, 110, 35);
        botonVender.setForeground(Color.gray);
        botonVaciarCamposVender.setBounds(700, 325, 110, 35);
        botonVaciarCamposVender.setForeground(Color.gray);

        //vender producto añado botones
        catshop.add(botonVender);
        catshop.add(botonVaciarCamposVender);

/////////////////////////////BOTONES COMPRAR UN PRODUCTO ///////////////////////////////////////////////////////////////

        //comprar un producto botones
        botonMandarOferta = new Button("Mandar Oferta");

        //vender producto tamaño y color de botones
        botonMandarOferta.setBounds(185, 700, 110, 35);
        botonMandarOferta.setForeground(Color.gray);

        //vender producto añado botones
        catshop.add(botonMandarOferta);

/////////////////////////////BOTONES MIS COMPRAS EN CURSO///////////////////////////////////////////////////////////////

        //mis compras en curso botones
        botonApostarMas = new Button("Ofertar");

        //mis compras en cursov tamaño y color de botones
        botonApostarMas.setBounds(510, 650, 100, 20);
        botonApostarMas.setForeground(Color.gray);

        //mis compras en curso añado botones
        catshop.add(botonApostarMas);


////////////////////////////////AREA REGISTRAR USUARIO//////////////////////////////////////////////////////////////////

        // registrar usuario Creacion area de Texto
        areaRealName = new JTextArea();
        areaDireccion = new JTextArea();
        areaTelefono = new JTextArea();
        areaCorreo = new JTextArea();
        areaNombreUsuario = new JTextArea();

        //registrar usuario Tamaño del area de Texto con borde negro
        areaRealName.setBounds(100, 145, 200, 20);
        areaRealName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDireccion.setBounds(100, 175, 200, 20);
        areaDireccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefono.setBounds(100, 205, 200, 20);
        areaTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreo.setBounds(100,235, 200, 20);
        areaCorreo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaNombreUsuario.setBounds(100,265, 200, 20);
        areaNombreUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //registrar usuario Añado area de Texto
        catshop.add(areaRealName);
        catshop.add(areaDireccion);
        catshop.add(areaTelefono);
        catshop.add(areaCorreo);
        catshop.add(areaNombreUsuario);

//////////////////////////////////AREA VENDER PRODUCTO//////////////////////////////////////////////////////////////////

        // vender producto Creacion area de Texto
        areaVenderProductName = new JTextArea();
        areaVenderProductDescripcion = new JTextArea();
        areaVenderTiempoLimite = new JTextArea();
        areaVenderPrecioInicial = new JTextArea();

        //vender producto Tamaño del area de Texto con borde negro
        areaVenderProductName.setBounds(615, 145, 200, 20);
        areaVenderProductName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaVenderProductDescripcion.setBounds(615, 175, 200, 20);
        areaVenderProductDescripcion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaVenderTiempoLimite.setBounds(615, 205, 200, 20);
        areaVenderTiempoLimite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaVenderPrecioInicial.setBounds(615, 235, 200, 20);
        areaVenderPrecioInicial.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //vender producto Añado area de Texto
        catshop.add(areaVenderProductName);
        catshop.add(areaVenderProductDescripcion);
        catshop.add(areaVenderTiempoLimite);
        catshop.add(areaVenderPrecioInicial);

//////////////////////////////////AREA Mis Ventas///////////////////////////////////////////////////////////////////////

        // mis ventas Creacion area de Texto
        modelMisVentasEnCurso = new DefaultListModel<>();
        listaVentasEnCurso = new JList<>(modelMisVentasEnCurso);
        areaNombreMisVentas = new JTextArea();
        areaDescripcionMisVentas = new JTextArea();
        areaPrecioActualMisVentas = new JTextArea();
        areaTiempoRestanteMisVentas = new JTextArea();
        modelMisVentasAcabadas = new DefaultListModel<>();
        listaVentasAcabadas = new JList<>(modelMisVentasAcabadas);
        areaVendidoA = new JTextArea();
        areaTelefonoAcabadas = new JTextArea();
        areaCorreoAcabadas = new JTextArea();
        areaPreciodeVenta = new JTextArea();

        //mis ventas Tamaño del area de Texto con borde negro
        listaVentasEnCurso.setBounds(950, 145, 200, 65);
        listaVentasEnCurso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaNombreMisVentas.setBounds(950, 225, 200, 20);
        areaNombreMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDescripcionMisVentas.setBounds(950, 255, 200, 20);
        areaDescripcionMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioActualMisVentas.setBounds(950,285, 200, 20);
        areaPrecioActualMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTiempoRestanteMisVentas.setBounds(950, 315, 200, 20);
        areaTiempoRestanteMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        listaVentasAcabadas.setBounds(1160,145, 200, 65);
        listaVentasAcabadas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaVendidoA.setBounds(1160,225, 200, 20);
        areaVendidoA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefonoAcabadas.setBounds(1160,255, 200, 20);
        areaTelefonoAcabadas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreoAcabadas.setBounds(1160,285, 200, 20);
        areaCorreoAcabadas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPreciodeVenta.setBounds(1160,315, 200, 20);
        areaPreciodeVenta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //mis ventas Añado area de Texto
        catshop.add(listaVentasEnCurso);
        catshop.add(areaNombreMisVentas);
        catshop.add(areaDescripcionMisVentas);
        catshop.add(areaPrecioActualMisVentas);
        catshop.add(areaTiempoRestanteMisVentas);
        catshop.add(listaVentasAcabadas);
        catshop.add(areaVendidoA);
        catshop.add(areaTelefonoAcabadas);
        catshop.add(areaCorreoAcabadas);
        catshop.add(areaPreciodeVenta);

////////////////////////////////AREA COMPRAR UN PRODUCTO////////////////////////////////////////////////////////////////

        // comprar un producto Creacion area de Texto
        modelCatalogoProductos = new DefaultListModel<>();
        listaProductosCatalogo = new JList<>(modelCatalogoProductos);
        areaName = new JTextArea();
        areaDescripcionProduc = new JTextArea();
        areaVendedor = new JTextArea();
        areaOferta = new JTextArea();
        areaPrecioActual = new JTextArea();

        //comprar un producto  Tamaño del area de Texto con borde negro
        listaProductosCatalogo.setBounds(45, 485, 200, 65);
        listaProductosCatalogo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaName.setBounds(115, 575, 200, 20);
        areaName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDescripcionProduc.setBounds(115, 605, 200, 20);
        areaDescripcionProduc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaVendedor.setBounds(115,635, 200, 20);
        areaVendedor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioActual.setBounds(115,665, 200, 20);
        areaPrecioActual.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaOferta.setBounds(50,705, 100, 25);
        areaOferta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //comprar un producto Añado area de Texto
        catshop.add(listaProductosCatalogo);
        catshop.add(areaName);
        catshop.add(areaDescripcionProduc);
        catshop.add(areaVendedor);
        catshop.add(areaPrecioActual);
        catshop.add(areaOferta);

////////////////////////////////AREA MIS COMPRAS EN CURSO///////////////////////////////////////////////////////////////

        // mis compras en curso area de Texto
        modelApuestaMas = new DefaultListModel<>();
        listadeApuestaMas = new JList<>(modelApuestaMas);
        modelEstasGanando = new DefaultListModel<>();
        listadeEstasGanando = new JList<>(modelEstasGanando);
        areaMandarOferta = new JTextArea();
        areaPrecioActualApuestaMas = new JTextArea();
        areaPrecioActualEstasGanando = new JTextArea();

        //mis compras en curso Tamaño del area de Texto con borde negro
        listadeApuestaMas.setBounds(410, 510, 200, 65);
        listadeApuestaMas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaMandarOferta.setBounds(410,650, 90, 20);
        areaMandarOferta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioActualApuestaMas.setBounds(410,605, 200, 20);
        areaPrecioActualApuestaMas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        listadeEstasGanando.setBounds(620, 510, 200, 65);
        listadeEstasGanando.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioActualEstasGanando.setBounds(620,605, 200, 20);
        areaPrecioActualEstasGanando.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //mis compras en curso Añado area de Texto
        catshop.add(listadeApuestaMas);
        catshop.add(listadeEstasGanando);
        catshop.add(areaMandarOferta);
        catshop.add(areaPrecioActualApuestaMas);
        catshop.add(areaPrecioActualEstasGanando);

////////////////////////////////AREA MIS COMPRAS ACABADAS///////////////////////////////////////////////////////////////

        // mis compras en curso area de Texto
        modelComprasGanadas = new DefaultListModel<>();
        listaGane = new JList<>(modelComprasGanadas);
        modelComprasPerdidas = new DefaultListModel<>();
        listaPerdi = new JList<>(modelComprasPerdidas);
        areaTelefonoGane = new JTextArea();
        areaCorreoGane = new JTextArea();
        areaPrecioGane = new JTextArea();
        areaPrecioPerdi = new JTextArea();

        //mis compras en curso Tamaño del area de Texto con borde negro
        listaGane.setBounds(950, 510, 200, 65);
        listaGane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefonoGane.setBounds(950,635, 200, 20);
        areaTelefonoGane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreoGane.setBounds(950,680, 200, 20);
        areaCorreoGane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioGane.setBounds(950,725, 200, 20);
        areaPrecioGane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        listaPerdi.setBounds(1160, 510, 200, 65);
        listaPerdi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioPerdi.setBounds(1160,605, 200, 20);
        areaPrecioPerdi.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //mis compras en curso Añado area de Texto
        catshop.add(listaGane);
        catshop.add(listaPerdi);
        catshop.add(areaTelefonoGane);
        catshop.add(areaCorreoGane);
        catshop.add(areaPrecioGane);
        catshop.add(areaPrecioPerdi);


//////////////////////////////////ETIQUETAS REGISTRAR USUARIO///////////////////////////////////////////////////////////

        //registrar usuario Creacion de Etiquetas
        etiquetaUserName = new JLabel("Nombre:");
        etiquetaDireccion = new JLabel("Dirección:");
        etiquetaTelefono = new JLabel("Telefono:");
        etiquetaCorreo = new JLabel("Correo:");
        etiquetaNombreUsuario = new JLabel("Nickname:");

        // registrar usuario Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaUserName.setBounds(10, 145, 200, 20);
        etiquetaUserName.setFont(fondo);
        etiquetaDireccion.setBounds(10, 175, 100, 20);
        etiquetaDireccion.setFont(fondo);
        etiquetaTelefono.setBounds(10, 205, 200, 20);
        etiquetaTelefono.setFont(fondo);
        etiquetaCorreo.setBounds(10,235, 100, 20);
        etiquetaCorreo.setFont(fondo);
        etiquetaNombreUsuario.setBounds(10,265, 100, 20);
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
        etiquetaNombre.setBounds(490, 145, 200, 20);
        etiquetaNombre.setFont(fondo);
        etiquetaDescripcion.setBounds(490, 175, 100, 20);
        etiquetaDescripcion.setFont(fondo);
        etiquetaTiempoimite.setBounds(490, 205, 200, 20);
        etiquetaTiempoimite.setFont(fondo);
        etiquetaPrecio.setBounds(490,235, 100, 20);
        etiquetaPrecio.setFont(fondo);

        //vender producto Añado etiqueta
        catshop.add(etiquetaNombre);
        catshop.add(etiquetaDescripcion);
        catshop.add(etiquetaTiempoimite);
        catshop.add(etiquetaPrecio);

//////////////////////////////////ETIQUETAS MIS VENTAS//////////////////////////////////////////////////////////////////

        //mis ventas Creacion de Etiquetas
        etiquetaEnCurso = new JLabel("En Curso");
        etiquetaAcabadas = new JLabel("Acabadas");

        //mis ventas Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaEnCurso.setBounds(990, 115, 200, 20);
        etiquetaEnCurso.setFont(fondo3);
        etiquetaAcabadas.setBounds(1195, 115, 100, 20);
        etiquetaAcabadas.setFont(fondo3);


        //mis ventas Añado etiqueta
        catshop.add(etiquetaEnCurso);
        catshop.add(etiquetaAcabadas);

//////////////////////////////////ETIQUETAS COMPRAR UN PRODUCTO ////////////////////////////////////////////////////////

        //comprar un producto Creacion de Etiquetas
        etiquetaName = new JLabel("Nombre:");
        etiquetaDescripcionProduc = new JLabel("Descripción:");
        etiquetaVendedor = new JLabel("Vendedor:");
        etiquetaPrecioActual = new JLabel("Precio Actual:");

        //comprar un producto Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaName.setBounds(10, 575, 200, 20);
        etiquetaName.setFont(fondo);
        etiquetaDescripcionProduc.setBounds(10, 605, 100, 20);
        etiquetaDescripcionProduc.setFont(fondo);
        etiquetaVendedor.setBounds(10, 635, 200, 20);
        etiquetaVendedor.setFont(fondo);
        etiquetaPrecioActual.setBounds(10,665, 100, 20);
        etiquetaPrecioActual.setFont(fondo);

        //comprar un producto Añado etiqueta
        catshop.add(etiquetaName);
        catshop.add(etiquetaDescripcionProduc);
        catshop.add(etiquetaVendedor);
        catshop.add(etiquetaPrecioActual);

//////////////////////////////////ETIQUETAS MIS COMPRAS EN CURSO ///////////////////////////////////////////////////////

        //mis ventas Creacion de Etiquetas
        etiquetaApuestaMas = new JLabel("Apuesta más");
        etiquetaEstasGanando = new JLabel("Estas Ganando");
        etiquetaPrecioActualApuestaMas = new JLabel("Precio Actual");
        etiquetaPrecioActualEstasGanando = new JLabel("Precio Actual");

        //mis ventas Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaApuestaMas.setBounds(410, 485, 200, 20);
        etiquetaApuestaMas.setFont(fondo3);
        etiquetaEstasGanando.setBounds(620, 485, 200, 20);
        etiquetaEstasGanando.setFont(fondo3);
        etiquetaPrecioActualApuestaMas.setBounds(410, 580, 200, 20);
        etiquetaPrecioActualApuestaMas.setFont(fondo);
        etiquetaPrecioActualEstasGanando.setBounds(620, 580, 100, 20);
        etiquetaPrecioActualEstasGanando.setFont(fondo);


        //mis ventas Añado etiqueta
        catshop.add(etiquetaApuestaMas);
        catshop.add(etiquetaEstasGanando);
        catshop.add(etiquetaPrecioActualApuestaMas);
        catshop.add(etiquetaPrecioActualEstasGanando);


//////////////////////////////////ETIQUETAS MIS COMPRAS ACABADAS////////////////////////////////////////////////////////

        //mis ventas Creacion de Etiquetas
        etiquetaGane = new JLabel("Gané");
        etiquetaPerdi = new JLabel("Perdí");
        etiquetaContactodelVendedor = new JLabel("Contacto del Vendedor");
        etiquetaTelefonodelVendedor = new JLabel("Teléfono");
        etiquetaCorreodelVendedor = new JLabel("Correo");
        etiquetaPrecioFinal = new JLabel("Precio Final");
        etiquetaVendidoAPrecio = new JLabel("Vendido a Precio");


        //mis ventas Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaGane.setBounds(950, 485, 200, 20);
        etiquetaGane.setFont(fondo3);
        etiquetaPerdi.setBounds(1160, 485, 200, 20);
        etiquetaPerdi.setFont(fondo3);
        etiquetaContactodelVendedor.setBounds(950, 580, 200, 20);
        etiquetaContactodelVendedor.setFont(fondo);
        etiquetaTelefonodelVendedor.setBounds(950, 610, 200, 20);
        etiquetaTelefonodelVendedor.setFont(fondo);
        etiquetaCorreodelVendedor.setBounds(950, 660, 200, 20);
        etiquetaCorreodelVendedor.setFont(fondo);
        etiquetaPrecioFinal.setBounds(950, 700, 200, 20);
        etiquetaPrecioFinal.setFont(fondo);
        etiquetaVendidoAPrecio.setBounds(1160, 580, 200, 20);
        etiquetaVendidoAPrecio.setFont(fondo);


        //mis ventas Añado etiqueta
        catshop.add(etiquetaGane);
        catshop.add(etiquetaPerdi);
        catshop.add(etiquetaContactodelVendedor);
        catshop.add(etiquetaTelefonodelVendedor);
        catshop.add(etiquetaCorreodelVendedor);
        catshop.add(etiquetaPrecioFinal);
        catshop.add(etiquetaVendidoAPrecio);



//////////////////////////////////ETIQUETAS TITULO//////////////////////////////////////////////////////////////////////
        // Creacion Etiquetas titulo
        etiquetaCatShop = new JLabel("CatShop");
        etiquetaRegistrarUsuario = new JLabel("Registrar Usuario");
        etiquetaVenderunProducto = new JLabel("Vender un Producto");
        etiquetaMisVentas = new JLabel("Mis Ventas");
        etiquetaComprarunProducto = new JLabel("Comprar un Producto");
        etiquetaMisComprasenCurso = new JLabel("Mis Compras en Curso");
        etiquetaMisComprasAcabadas = new JLabel("Mis Compras Acabadas");



        //titulo Tamaño de etiqueta y tipo y tamaño de letra
        etiquetaCatShop.setBounds(650,10,350,45);
        etiquetaCatShop.setFont(fondo1);
        etiquetaCatShop.setForeground(Color.GREEN);
        etiquetaRegistrarUsuario.setBounds(10, -5, 400, 200);
        etiquetaRegistrarUsuario.setFont(fondo2);
        etiquetaVenderunProducto.setBounds(490, -5,200,200);
        etiquetaVenderunProducto.setFont(fondo2);
        etiquetaMisVentas.setBounds(950, -5,200,200);
        etiquetaMisVentas.setFont(fondo2);
        etiquetaComprarunProducto.setBounds(10, 355,300,200);
        etiquetaComprarunProducto.setFont(fondo2);
        etiquetaMisComprasenCurso.setBounds(490, 355,300,200);
        etiquetaMisComprasenCurso.setFont(fondo2);
        etiquetaMisComprasAcabadas.setBounds(950, 355,300,200);
        etiquetaMisComprasAcabadas.setFont(fondo2);


        // titulo añado etiquetas
        catshop.add(etiquetaCatShop);
        catshop.add(etiquetaRegistrarUsuario);
        catshop.add(etiquetaVenderunProducto);
        catshop.add(etiquetaMisVentas);
        catshop.add(etiquetaComprarunProducto);
        catshop.add(etiquetaMisComprasenCurso);
        catshop.add(etiquetaMisComprasAcabadas);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Para ver la ventana
        catshop.setVisible(true);


    }

    public void asignarActionListener(ActionListener controlador) {
        botonConectarse.addActionListener(controlador);
        botonVender.addActionListener(controlador);
    }

    public void asignarListSelectionListener(ListSelectionListener controlador) {
        listaVentasEnCurso.addListSelectionListener(controlador);
        listaVentasAcabadas.addListSelectionListener(controlador);
    }

    public Producto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Producto prod) {
        selectedProduct = prod;
    }

    public void setSelectedSellingProduct(Producto p) {
        System.out.println("Selected this product " + p.getNombre());
        areaNombreMisVentas.setText(p.getNombre());
        areaDescripcionMisVentas.setText(p.getDescripcion());
        areaPrecioActualMisVentas.setText(String.valueOf(p.getPrecioActual()));
        String date = sdf.format(p.getLimite().getTime());
        areaTiempoRestanteMisVentas.setText(date);
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Usuario user) {
        currentUser = user;
    }

    public String getRealName() {
        return areaRealName.getText();
    }

    public String getUserDireccion() {
        return areaDireccion.getText();
    }

    public String getUserCorreo() {
        return areaCorreo.getText();
    }

    public String getUserTelefono() {
        return areaTelefono.getText();
    }

    public String getUserApodo() {
        return areaNombreUsuario.getText();
    }

    public String getProductName() {
        return areaVenderProductName.getText();
    }

    public String getProductDesc() {
        return areaVenderProductDescripcion.getText();
    }

    public int getTiempoVenta() {
        return Integer.parseInt(areaVenderTiempoLimite.getText());
    }

    public float getProductInitialPrice() {
        return Float.parseFloat(areaVenderPrecioInicial.getText());
    }

    public float getMontoContraOferta() {
        return 200.0f;
    }
    // TO IMPLEMENT PROPERLY

    public float getMontoOferta() {
        return 200.0f;
    }

    public JList getListaVentasEnCurso() {
        return listaVentasEnCurso;
    }

    public JList<String> getListaVentasAcabadas() {
        return listaVentasAcabadas;
    }

    public JList<String> getListaProductosCatalogo() {
        return listaProductosCatalogo;
    }

    public JList<String> getListadeApuestaMas() {
        return listadeApuestaMas;
    }

    public JList<String> getListadeEstasGanando() {
        return listadeEstasGanando;
    }

    public JList<String> getListaGane() {
        return listaGane;
    }

    public JList<String> getListaPerdi() {
        return listaPerdi;
    }

    // SUCCESS OR ERROR MESSAGES

    public void errorCreatingUser() {
        JOptionPane.showMessageDialog(catshop,
                "Este apodo ya existe, favor de seleccionar otro",
                "Error creating user",
                JOptionPane.ERROR_MESSAGE);
    }

    public void userSuccessfullyCreated() {
        JOptionPane.showMessageDialog(catshop,
                "Usuario creado y conectado a la tienda",
                "User successfully created",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void offerDeclined() {
        JOptionPane.showMessageDialog(catshop,
                "Lo sentimos, no se pudo realizar esta oferta.",
                "Offer declined",
                JOptionPane.ERROR_MESSAGE);
    }

    public void offerAccepted() {
        JOptionPane.showMessageDialog(catshop,
                "Su oferta ha sido aceptada.",
                "Offer accepted",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void ventaRefused() {
        JOptionPane.showMessageDialog(catshop,
                "Lo sentimos, no se puede vender este producto con tal nombre.",
                "Venta no aceptada",
                JOptionPane.ERROR_MESSAGE);
    }

    public void ventaAccepted() {
        JOptionPane.showMessageDialog(catshop,
                "Su producto está en el mercado.",
                "Venta aceptada",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // UPDATE VIEW

    public void updateRegistrarUsuario() {
        System.out.println(currentUser.getApodo());
        etiquetaRegistrarUsuario.setText("Bienvenido a CatShop, " + currentUser.getApodo() + " :)");
        etiquetaUserName.setVisible(false);
        areaRealName.setVisible(false);
        etiquetaTelefono.setVisible(false);
        areaTelefono.setVisible(false);
        etiquetaDireccion.setVisible(false);
        areaDireccion.setVisible(false);
        etiquetaCorreo.setVisible(false);
        areaCorreo.setVisible(false);
        areaNombreUsuario.setVisible(false);
        etiquetaNombreUsuario.setVisible(false);
        botonConectarse.setVisible(false);
    }

    public void updateListComprasPossibles(ArrayList<Producto> prod) {
        for (Producto p : prod) {
            modelCatalogoProductos.addElement(p.getNombre());
        }
    }

    public void addEstasGanandoProduct(Producto p) {
        modelEstasGanando.addElement(p.getNombre());
    }

    public String[] getEstasGanando() {
        String[] arrayGanando = (String[]) modelEstasGanando.toArray();
        return arrayGanando;
    }

    public void updateListApuestaMas(ArrayList<String> prodToAdd) {
        for (String s : prodToAdd) {
            modelApuestaMas.addElement(s);
        }
    }

    public void addSellingProduct(Producto prod) {
        modelMisVentasEnCurso.addElement(prod.getNombre());
    }

}
