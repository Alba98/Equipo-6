package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Main;

public class VRegistrar {
    private JPanel pPrincipal;
    private JTextField tfNombre;
    private JTextField tfCorreo;
    private JTextField tfFechaNacimiento;
    private JTextField tfcontraseña;
    private JButton registrarButton;


    public VRegistrar() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VRegistrar");
        frame.setContentPane(new VRegistrar().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }
}


