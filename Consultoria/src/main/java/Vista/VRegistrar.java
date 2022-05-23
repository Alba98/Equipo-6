package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Controlador.Main;
import Excepciones.Validaciones;

/**
 * VENTANA REGISTRAR
 * @author Equipo-6
 */
public class VRegistrar {
    private JPanel pPrincipal;
    private JTextField tfNombre;
    private JTextField tfCorreo;
    private JTextField tfFechaNacimiento;
    private JPasswordField tfcontraseña;
    private JButton registrarButton;
    private JButton bLogIn;
    private JCheckBox ckVer;


    /**
     *
     * CONTRUCTOR DE LA VENTANA REGISTRAR
     *
     * @param email correo electronico del usuario a registar
     *
     **/
    public VRegistrar(String email) {
        tfCorreo.setText(email);
        tfcontraseña.setEchoChar('*');

        registrarButton.setBorderPainted(false);
        registrarButton.setFocusable(false);
        registrarButton.setRolloverEnabled(true);

        bLogIn.setBorderPainted(false);
        bLogIn.setFocusable(false);
        bLogIn.setRolloverEnabled(true);

        registrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registrarButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                registrarButton.setBackground(UIManager.getColor("control"));
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        bLogIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bLogIn.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bLogIn.setBackground(UIManager.getColor("control"));
            }
        });

        bLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.volverLogInRegistrar();
            }
        });

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
    }

    /**
     *
     * REGISTAR UN NUEVO USUARIO EN LA BBDD
     *
     **/
    private void registrarUsuario() {
        if ( validarRegistrarUsuario() ) {
            try {
                Main.registrarUsuario(tfNombre.getText(), tfcontraseña.getText(), tfCorreo.getText(), tfFechaNacimiento.getText());
            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }

    }

    /**
     *
     * VALIDAR REGISTRAR USUARIO
     *
     **/
    private boolean validarRegistrarUsuario() {
        return (Validaciones.validarTexto(tfNombre) &&  Validaciones.validarTexto(tfcontraseña) &&
                Validaciones.validarEmail(tfCorreo) &&  Validaciones.validarFecha(tfFechaNacimiento));
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


