package Vista;
import Controlador.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VLogin {
    public JPanel pPrincipal;
    private JTextField tFCorreo;
    private JButton loginButton;
    private JLabel tFContraseña;
    private JPasswordField contra;
    private JCheckBox ckVer;


    public VLogin() {
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
                if (tFCorreo.getText() == "Select Email from usuarios")
                {
                    if (tFCorreo.getText() == "Select Email from usuarios where cod_rol = 01")
                        Main.VentanaAdmin();
                    else
                    if (tFCorreo.getText() == "Select Email from usuarios where cod_rol = 02")
                        Main.VUsuario();
                }
                else
                {
                    Main.CrearCuenta();
                }
            }
        });
    }
}



