
public class Principal {

    public static void main(String args[]) {

        SubastaVista vista;
        MainVista try1;
        VenderProductoVista ventaproducto;
        SubastaControlador controlador;
        SubastaModelo modelo;
        try1 = new MainVista();
        ventaproducto = new VenderProductoVista();
        vista = new SubastaVista();
        modelo = new SubastaModelo();
        controlador = new SubastaControlador(vista, modelo);
        //SubastaVista vista;
        MainVista view;
        MainControlador ctrl;
        MainModelo model;

        view = new MainVista();
        model = new MainModelo();
        ctrl = new MainControlador(view, model);

        view.asignarActionListener(ctrl);


        //SubastaControlador controlador;
        //SubastaModelo modelo;
        //vista = new SubastaVista();
        //modelo = new SubastaModelo();
        //controlador = new SubastaControlador(vista, modelo);

        //vista.asignarActionListener(controlador);
        //vista.asignarListSelectionListener(controlador);
    }
}
