package Vista;
import Controlador.Main;
import Excepciones.Validaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VLogin {
    public JPanel pPrincipal;
    private JTextField tFCorreo;
    private JButton loginButton;
    private JLabel tFContraseña;
    private JPasswordField contra;
    private JCheckBox ckVer;


    public VLogin() {
        loginButton.setBorderPainted(false);
        loginButton.setFocusable(false);
        loginButton.setRolloverEnabled(true);


        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.setBackground(UIManager.getColor("control"));
            }
        });

        contra.setEchoChar('*');

        tFCorreo.setText("alba@gmail.com");
        contra.setText("Hola");

        ckVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ckVer.isSelected())
                 {
                     contra.setEchoChar((char)0);

                }else{
                    contra.setEchoChar('*');
                }
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //validarEmail
                login();
            }
        });
        tFCorreo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Validaciones.validarEmail(tFCorreo);
            }
        });
        contra.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

            }
        });
    }

    private void login() {
        JPasswordField psswrd = contra;
        psswrd.setEchoChar((char)0);
        Main.login(tFCorreo.getText(), psswrd.getPassword());

        /*
        if (tFCorreo.getText() == "Select Email from usuarios")
        {
            if (tFCorreo.getText() == "Select Email from usuarios where cod_rol = 01")
                Main.VentanaAdmin();
            else
            if (tFCorreo.getText() == "Select Email from usuarios where cod_rol = 02")
                Main.VentanaUsuario();
        }
        else
        {
            Main.CrearCuenta();*
        }
        */

    }
}



