package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VUsuario extends JDialog {
    private JPanel pPrincipal;
    private JPanel PInfo;
    private JPanel PClasificacion;
    private JPanel PJornada;
    private JLabel lClasificacion;
    private JLabel jJornada;
    private JPanel jInfoEquipo;
    private JTextField tfNombre;
    private JLabel jNombreE;
    private JTextField tfDuenioE;
    private JLabel jDuenioE;
    private JLabel jResultadoE;
    private JTextField tfResultadoE;
    private JTextField tfNumJornada;
    private JLabel jNumJornada;
    private JLabel jFechaJornada;
    private JLabel jFechaPartido;
    private JLabel jCodPartido;
    private JTextField tfCodPartido;
    private JTextField tfFechaJornada;
    private JTextField tfFechaPartido;
    private JTextField tfNomEquipo;
    private JButton bClasificacion;
    private JButton bJornada;
    private JButton bLogout;
    private JLabel info;
    private JPanel panelPruebas;

    public VUsuario() {
        setContentPane(pPrincipal);
        setModal(true);
        //Parrafo de Información del TextArea:
        String text=
                "OPCIONES DE LA VENTANA:<br><br>"+
                "Seleccione el boton CLASIFICACION para conocer la <br> clasificacion actual de la liga<br><br>" +
                "Seleccione el boton JORNADA para conocer los datos <br> sobre la ultima jornada<br><br>" +
                "Seleccione el boton LOG OUT para cerrar sesión y salir <br> de la aplicacion<br>"
                ;
        //JLabel
        info.setText("<html>" + text + "</html>");
        //Opciones esteticas de los botones
        bClasificacion.setBorderPainted(false);
        bClasificacion.setFocusable(false);
        bClasificacion.setRolloverEnabled(true);

        bJornada.setBorderPainted(false);
        bJornada.setFocusable(false);
        bJornada.setRolloverEnabled(true);

        bLogout.setBorderPainted(false);
        bLogout.setFocusable(false);
        bLogout.setRolloverEnabled(true);

        //Paneles de opciones invisibles
        PInfo.setVisible(true);
        PClasificacion.setVisible(false);
        PJornada.setVisible(false);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        bClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PClasificacion.setVisible(true);
                PInfo.setVisible(false);
                PJornada.setVisible(false);
            }
        });
        bJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PJornada.setVisible(true);
                PClasificacion.setVisible(false);
                PClasificacion.setVisible(false);
            }
        });
        bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bClasificacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bClasificacion.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bClasificacion.setBackground(UIManager.getColor("control"));
            }
        });
        bJornada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bJornada.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bJornada.setBackground(UIManager.getColor("control"));
            }
        });
        bLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bLogout.setBackground(Color.PINK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bLogout.setBackground(UIManager.getColor("control"));
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VUsuario V1 = new VUsuario();
        V1.pack();
        V1.setLocationRelativeTo(null);
        V1.setVisible(true);
        System.exit(0);
    }
}
