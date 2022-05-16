package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controlador.Main.CrearCalendario;

public class VAdmin {
    private JTabbedPane VentanaAdmins;
    private JPanel PanelPrincipal;
    private JPanel CContrato;
    private JPanel CJugador;
    private JPanel CEquipo;
    private JPanel CEntrenador;
    private JPanel CAsistente;
    private JPanel CCalendario;
    private JPanel CAPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel NNombre;
    private JLabel NApellido;
    private JLabel NSueldo;
    private JLabel NNacimiento;
    private JLabel NNacionalidad;
    private JLabel NNickname;
    private JLabel NEntrenador;
    private JTextField Nombre;
    private JTextField Apellido;
    private JTextField Sueldo;
    private JTextField Nacimiento;
    private JTextField Nacionalidad;
    private JTextField Nickname;
    private JComboBox Entrenador;
    private JPanel CCPrincipal;
    private JLabel NJugador;
    private JLabel NEquipo;
    private JLabel FInicio;
    private JComboBox Codejugador;
    private JLabel FFinal;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox Codeequipo;
    private JLabel Aviso;
    private JPanel CEQPrincipal;
    private JLabel NFecha;
    private JLabel NCiudad;
    private JTextField textField3;
    private JLabel NEsponsor;
    private JTextField textField4;
    private JLabel NDueño;
    private JTextField textField5;
    private JPanel CJPrincipal;
    private JLabel NROL;
    private JComboBox ROL;
    private JPanel CEPrincipal;
    private JButton crearCalendarioButton;

    public VAdmin() {
        crearCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearCalendario();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PruebaVentana");
        frame.setContentPane(new VAdmin().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JTabbedPane getVentanaAdmins() {
        return VentanaAdmins;
    }

    public void setVentanaAdmins(JTabbedPane ventanaAdmins) {
        VentanaAdmins = ventanaAdmins;
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        PanelPrincipal = panelPrincipal;
    }

    public JButton getCrearCalendarioButton() {
        return crearCalendarioButton;
    }

    public void setCrearCalendarioButton(JButton crearCalendarioButton) {
        this.crearCalendarioButton = crearCalendarioButton;
    }
}


