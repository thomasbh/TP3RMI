import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class CreacionUsuarioVista {
    JFrame principal;
    JTextField nombre;
    JTextField direccion;
    JTextField correo;
    JFormattedTextField telefono;
    JTextField apodo;
    JButton validar;
    JButton cancelar;

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
        formatter.setMinimum(0);
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
        principal.setVisible(true);
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
}