import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class CreacionUsuarioVista {
    private JFrame principal;
    private JTextField nombre;
    private JTextField direccion;
    private JTextField correo;
    private JFormattedTextField telefono;
    private JTextField apodo;
    private JButton validar;
    private JButton cancelar;

    public CreacionUsuarioVista() {

        Container panel;

        principal = new JFrame("Creacion de usuario");
        panel = principal.getContentPane();
        panel.setLayout(new GridLayout(0, 2));
        nombre = new JTextField();
        panel.add(new JLabel("Nombre"));
        panel.add(nombre);
        direccion = new JTextField();
        panel.add(new JLabel("Direccion"));
        panel.add(direccion);
        correo = new JTextField();
        panel.add(new JLabel("Correo"));
        panel.add(correo);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Long.class);
        formatter.setMinimum(0L);
        formatter.setMaximum(9999999999L);
        formatter.setAllowsInvalid(false);
        telefono = new JFormattedTextField(formatter);

        panel.add(new JLabel("Telefono"));
        panel.add(telefono);
        apodo = new JTextField();
        panel.add(new JLabel("Apodo"));
        panel.add(apodo);

        cancelar = new JButton("Cancelar");
        panel.add(cancelar);

        validar = new JButton("Validar");
        panel.add(validar);

        principal.setSize(200, 200);
        principal.setVisible(false);
    }

    public void setVisible(boolean visi) {
        principal.setVisible(visi);
    }

    public void asignarActionListener(ActionListener controlador) {
        cancelar.addActionListener(controlador);
        validar.addActionListener(controlador);
    }

    public String getNombre() {
        return nombre.getText();
    }

    public String getDireccion() {
        return direccion.getText();
    }

    public String getCorreo() {
        return correo.getText();
    }

    public String getTelefono() {
        return telefono.getText();
    }

    public String getApodo() {
        return apodo.getText();
    }

    public void errorCreatingUser() {
        JOptionPane.showMessageDialog(principal,
                "Este apodo ya existe, favor de seleccionar otro",
                "Error creating user",
                JOptionPane.ERROR_MESSAGE);
    }

}
