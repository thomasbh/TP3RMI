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
    Font fondo2 = new Font("Arial", Font.BOLD, 35);


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

    public CatShopView(){

        catshop.setSize(1450,1450);
        catshop.getContentPane().setBackground(Color.lightGray);
        catshop.setLocationRelativeTo(null);
        catshop.setLayout(null);
        catshop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // registrar usuario creacion botones

        botonConectarse = new Button("Conectarse");
        botonEliminar = new Button("Eliminar");

        //tamaño y color de botones

        botonConectarse.setBounds(15, 220, 110, 35);
        botonConectarse.setForeground(Color.gray);
        botonEliminar.setBounds(135, 220, 110, 35);
        botonEliminar.setForeground(Color.gray);


        // Añado boton


        catshop.add(botonEliminar);
        catshop.add(botonConectarse);


        // Creacion area de Texto

        areaUserName = new JTextArea();
        areaDireccion = new JTextArea();
        areaTelefono = new JTextArea();
        areaCorreo = new JTextArea();
        areaNombreUsuario = new JTextArea();

        //Tamaño del area de Texto con borde negro

        areaUserName.setBounds(100, 50, 200, 20);
        areaUserName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaDireccion.setBounds(100, 80, 100, 20);
        areaDireccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTelefono.setBounds(100, 110, 200, 20);
        areaTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaCorreo.setBounds(100,140, 100, 20);
        areaCorreo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaNombreUsuario.setBounds(100,170, 100, 20);
        areaNombreUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Añado area de Texto

        catshop.add(areaUserName);
        catshop.add(areaDireccion);
        catshop.add(areaTelefono);
        catshop.add(areaCorreo);
        catshop.add(areaNombreUsuario);

        //Creacion de Etiquetas

        etiquetaUserName = new JLabel("User Name:");
        etiquetaDireccion = new JLabel("Dirección:");
        etiquetaTelefono = new JLabel("Telefono:");
        etiquetaCorreo = new JLabel("Correo:");
        etiquetaNombreUsuario = new JLabel("Nombre:");
        etiquetaCatShop = new JLabel("Cat Shop");

        // Tamaño de etiqueta y tipo y tamaño de letra

        etiquetaUserName.setBounds(10, 50, 200, 20);
        etiquetaUserName.setFont(fondo);
        etiquetaDireccion.setBounds(10, 80, 100, 20);
        etiquetaDireccion.setFont(fondo);
        etiquetaTelefono.setBounds(10, 110, 200, 20);
        etiquetaTelefono.setFont(fondo);
        etiquetaCorreo.setBounds(10,140, 100, 20);
        etiquetaCorreo.setFont(fondo);
        etiquetaNombreUsuario.setBounds(10,170, 100, 20);
        etiquetaNombreUsuario.setFont(fondo);


        //titulo etiquetas
        etiquetaCatShop.setBounds(650,10,350,45);
        etiquetaCatShop.setFont(fondo1);
        //etiquetaCatShop.setForeground(Color.orange);


        //  Añado etiqueta

        catshop.add(etiquetaUserName);
        catshop.add(etiquetaDireccion);
        catshop.add(etiquetaTelefono);
        catshop.add(etiquetaCorreo);
        catshop.add(etiquetaNombreUsuario);




        // titulo etiquetas
        catshop.add(etiquetaCatShop);

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
