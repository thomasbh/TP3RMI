import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import java.awt.Font;

public class CatShopView {

    //other

    Usuario currentUser;
    Producto selectedProduct;

    // window

    JFrame catshop = new JFrame("Cat Shop");
    //Con la variable Font pones tipo y tamaño de letra
    Font fondo = new Font("Arial", Font.BOLD,15);
    Font fondo1 = new Font("Arial", Font.BOLD, 35);
    Font fondo2 = new Font("Arial", Font.BOLD, 20);
    Font fondo3 = new Font("Arial", Font.BOLD, 18);


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

    // mis ventas area
    JTextArea areaListaEnCurso;
    JTextArea areaNombreMisVentas;
    JTextArea areaDescripcionMisVentas;
    JTextArea areaPrecioActualMisVentas;
    JTextArea areaTiempoRestante;
    JTextArea areaListaAcabadas;
    JTextArea areaVendidoA;
    JTextArea areaTelefonoAcabadas;
    JTextArea areaCorreoAcabadas;
    JTextArea areaPreciodeVenta;

    //comprar un Producto
    JTextArea areaListaProductos;
    JTextArea areaName;
    JTextArea areaDescripcionProduc;
    JTextArea areaVendedor;
    JTextArea areaPrecioActual;
    JTextArea areaOferta;


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
    JLabel etiquetaListaenCurso;
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
        botonConectarse.setBounds(15, 325, 110, 35);
        botonConectarse.setForeground(Color.gray);
        botonEliminar.setBounds(185, 325, 110, 35);
        botonEliminar.setForeground(Color.gray);

        //registrar usuario Añado boton
        catshop.add(botonEliminar);
        catshop.add(botonConectarse);

/////////////////////////////BOTONES VENDER PRODUCTO////////////////////////////////////////////////////////////////////

        //vender producto botones
        botonVender = new Button("Vender");
        botonElimina = new Button("Elimina");

        //vender producto tamaño y color de botones
        botonVender.setBounds(490, 325, 110, 35);
        botonVender.setForeground(Color.gray);
        botonElimina.setBounds(700, 325, 110, 35);
        botonElimina.setForeground(Color.gray);

        //vender producto añado botones
        catshop.add(botonVender);
        catshop.add(botonElimina);

/////////////////////////////BOTONES COMPRAR UN PRODUCTO ///////////////////////////////////////////////////////////////

        //comprar un producto botones
        botonMandarOferta = new Button("Mandar Oferta");

        //vender producto tamaño y color de botones
        botonMandarOferta.setBounds(185, 700, 110, 35);
        botonMandarOferta.setForeground(Color.gray);

        //vender producto añado botones
        catshop.add(botonMandarOferta);

////////////////////////////////AREA REGISTRAR USUARIO//////////////////////////////////////////////////////////////////

        // registrar usuario Creacion area de Texto
        areaUserName = new JTextArea();
        areaDireccion = new JTextArea();
        areaTelefono = new JTextArea();
        areaCorreo = new JTextArea();
        areaNombreUsuario = new JTextArea();

        //registrar usuario Tamaño del area de Texto con borde negro
        areaUserName.setBounds(100, 145, 200, 20);
        areaUserName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDireccion.setBounds(100, 175, 200, 20);
        areaDireccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefono.setBounds(100, 205, 200, 20);
        areaTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreo.setBounds(100,235, 200, 20);
        areaCorreo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaNombreUsuario.setBounds(100,265, 200, 20);
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
        areaNombre.setBounds(615, 145, 200, 20);
        areaNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDescripcion.setBounds(615, 175, 200, 20);
        areaDescripcion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTiempoLimite.setBounds(615, 205, 200, 20);
        areaTiempoLimite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioInicial.setBounds(615,235, 200, 20);
        areaPrecioInicial.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //vender producto Añado area de Texto
        catshop.add(areaNombre);
        catshop.add(areaDescripcion);
        catshop.add(areaTiempoLimite);
        catshop.add(areaPrecioInicial);

//////////////////////////////////AREA Mis Ventas///////////////////////////////////////////////////////////////////////

        // mis ventas Creacion area de Texto
        areaListaEnCurso = new JTextArea();
        areaNombreMisVentas = new JTextArea();
        areaDescripcionMisVentas = new JTextArea();
        areaPrecioActualMisVentas = new JTextArea();
        areaTiempoRestante = new JTextArea();
        areaListaAcabadas = new JTextArea();
        areaVendidoA = new JTextArea();
        areaTelefonoAcabadas = new JTextArea();
        areaCorreoAcabadas = new JTextArea();
        areaPreciodeVenta = new JTextArea();

        //mis ventas Tamaño del area de Texto con borde negro
        areaListaEnCurso.setBounds(950, 145, 200, 65);
        areaListaEnCurso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaNombreMisVentas.setBounds(950, 225, 200, 20);
        areaNombreMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDescripcionMisVentas.setBounds(950, 255, 200, 20);
        areaDescripcionMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPrecioActualMisVentas.setBounds(950,285, 200, 20);
        areaPrecioActualMisVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTiempoRestante.setBounds(950,315, 200, 20);
        areaTiempoRestante.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaListaAcabadas.setBounds(1160,145, 200, 65);
        areaListaAcabadas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaVendidoA.setBounds(1160,225, 200, 20);
        areaVendidoA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefonoAcabadas.setBounds(1160,255, 200, 20);
        areaTelefonoAcabadas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreoAcabadas.setBounds(1160,285, 200, 20);
        areaCorreoAcabadas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaPreciodeVenta.setBounds(1160,315, 200, 20);
        areaPreciodeVenta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //mis ventas Añado area de Texto
        catshop.add(areaListaEnCurso);
        catshop.add(areaNombreMisVentas);
        catshop.add(areaDescripcionMisVentas);
        catshop.add(areaPrecioActualMisVentas);
        catshop.add(areaTiempoRestante);
        catshop.add(areaListaAcabadas);
        catshop.add(areaVendidoA);
        catshop.add(areaTelefonoAcabadas);
        catshop.add(areaCorreoAcabadas);
        catshop.add(areaPreciodeVenta);

////////////////////////////////AREA COMPRAR UN PRODUCTO////////////////////////////////////////////////////////////////

        // comprar un producto Creacion area de Texto
        areaListaProductos = new JTextArea();
        areaName = new JTextArea();
        areaDescripcionProduc = new JTextArea();
        areaVendedor = new JTextArea();
        areaOferta = new JTextArea();
        areaPrecioActual = new JTextArea();

        //comprar un producto  Tamaño del area de Texto con borde negro
        areaListaProductos.setBounds(45, 485, 200, 65);
        areaListaProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        catshop.add(areaListaProductos);
        catshop.add(areaName);
        catshop.add(areaDescripcionProduc);
        catshop.add(areaVendedor);
        catshop.add(areaPrecioActual);
        catshop.add(areaOferta);

//////////////////////////////////ETIQUETAS REGISTRAR USUARIO///////////////////////////////////////////////////////////

        //registrar usuario Creacion de Etiquetas
        etiquetaUserName = new JLabel("User Name:");
        etiquetaDireccion = new JLabel("Dirección:");
        etiquetaTelefono = new JLabel("Telefono:");
        etiquetaCorreo = new JLabel("Correo:");
        etiquetaNombreUsuario = new JLabel("Nombre:");

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

//////////////////////////////////ETIQUETAS TITULO//////////////////////////////////////////////////////////////////////
        // Creacion Etiquetas titulo
        etiquetaCatShop = new JLabel("Cat Shop");
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
        etiquetaRegistrarUsuario.setBounds(10, -5,200,200);
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
    }

    public Producto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Producto prod) {
        selectedProduct = prod;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Usuario user) {
        currentUser = user;
    }

    public String getUserName() {
        return areaUserName.getText();
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

    // TO IMPLEMENT PROPERLY

    public String getProductName() {
        return "Product Name";
    }

    public String getProductDesc() {
        return "Product desc";
    }

    public int getTiempoVenta() {
        return 30;
    }

    public float getProductInitialPrice() {
        return 150.0f;
    }

    public float getMontoOferta() {
        return 200.0f;
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

}
