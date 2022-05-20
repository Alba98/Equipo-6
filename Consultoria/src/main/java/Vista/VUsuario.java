package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VUsuario {

    public JPanel pPrincipal;
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
    private JTextField tfResultadoAdm;
    private JButton BResultadoAdm;
    private JPanel PAdmin;
    private JLabel AResultado;
    private JPanel pTest;
    private JTextArea taResultados;

    public VUsuario(boolean admin) {

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

        //Jornadas admin
        PAdmin.setVisible(admin);


        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        bClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PInfo.setVisible(false);
                // PClasificacion.setVisible(true);
                // PJornada.setVisible(false);

                getClasificacion();
            }
        });
        bJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PInfo.setVisible(false);
                // PJornada.setVisible(true);
                // PAdmin.setVisible(admin);
                // PClasificacion.setVisible(false);
                // PClasificacion.setVisible(false);

                getJornadas();
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

        /* Creo que habría que añadir aquí el boolean y ver como intentar conectarlo */
        BResultadoAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfResultadoAdm.getText() == "0-0");
            }
        });

    }

    private void getJornadas() {
        taResultados.setText( Main.getResultadosJornadas());

    }

    private void getClasificacion() {
        taResultados.setText( Main.getClasificacion());

    }

    private void onCancel() {
        // add your code here if necessary
   //     dispose();
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

}
