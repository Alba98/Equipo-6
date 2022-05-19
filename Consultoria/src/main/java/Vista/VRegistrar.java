package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Main;
import Excepciones.Validaciones;

public class VRegistrar {
    private JPanel pPrincipal;
    private JTextField tfNombre;
    private JTextField tfCorreo;
    private JTextField tfFechaNacimiento;
    private JPasswordField tfcontraseña;
    private JButton registrarButton;
    private JCheckBox ckVer;


    public VRegistrar(String email) {
        tfCorreo.setText(email);
        tfcontraseña.setEchoChar('*');
/*
        tfNombre.setText("test");
        tfFechaNacimiento.setText("03/05/1998");
        tfcontraseña.setText("test");
*/
        
        ckVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ckVer.isSelected())
                {
                    tfcontraseña.setEchoChar((char)0);

                }else{
                    tfcontraseña.setEchoChar('*');
                }
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        if ( validarRegistrarUsuario() ) {
            try {
                Main.registrarUsuario(tfNombre.getText(), tfcontraseña.getText(), tfCorreo.getText(), tfFechaNacimiento.getText());
            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }

    }

    private boolean validarRegistrarUsuario() {
        return (Validaciones.validarTexto(tfNombre) &&  Validaciones.validarTexto(tfcontraseña) &&
                Validaciones.validarEmail(tfCorreo) &&  Validaciones.validarFecha(tfFechaNacimiento));
    }


    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }
}


