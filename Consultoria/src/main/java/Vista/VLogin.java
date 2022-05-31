package Vista;
import Controlador.Main;
import Excepciones.Validaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * VENTANA LOG IN
 * @author Equipo-6
 */
public class VLogin {
    private JPanel pPrincipal;
    private JTextField tFCorreo;
    private JButton loginButton;
    private JLabel tFContraseña;
    private JPasswordField contra;
    private JCheckBox ckVer;

    /**
     *
     * CONTRUCTOR DE LA VENTANA LOGIN
     *
     **/
    public VLogin() {
        loginButton.setBorderPainted(false);
        loginButton.setFocusable(false);
        loginButton.setRolloverEnabled(true);


        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(150,237,217));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginButton.setBackground(UIManager.getColor("control"));
            }
        });

        contra.setEchoChar('*');
        
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
            public void actionPerformed(ActionEvent e) {
                if(Validaciones.validarEmail(tFCorreo)) {
                    login();
                }
            }
        });

    }

    /**
     *
     * HACER LOGIN EN LA BBDD
     *
     **/
    private void login() {
        JPasswordField psswrd = contra;
        psswrd.setEchoChar((char)0);
        Main.login(tFCorreo.getText(), psswrd.getPassword());
    }

    /**
     *
     * GETTER JPANEL PRINCIPAL DE LA VENTANA
     *
     * @return pPrincipal
     *
     **/
    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}



