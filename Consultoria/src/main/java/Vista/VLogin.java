package Vista;
import Controlador.Main;
import Excepciones.Validaciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VLogin {
    public JPanel pPrincipal;
    private JTextField tFCorreo;
    private JButton loginButton;
    private JLabel tFContraseña;
    private JPasswordField contra;
    private JCheckBox ckVer;


    public VLogin() {
        contra.setEchoChar('*');
        /*
        tFCorreo.setText("admin@gmail.com");
        contra.setText("admin");
        */
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



