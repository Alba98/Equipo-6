package Vista;

import Controlador.Main;
import Excepciones.Validaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * VENTANA USUARIO
 * @author Equipo-6
 */
public class VUsuario {

    public JPanel pPrincipal;
    private JPanel PInfo;
    private JPanel PClasificacion;
    private JPanel PJornada;
    private JLabel lClasificacion;
    private JLabel jJornada;
    private JPanel jInfoEquipo;
    private JButton bClasificacion;
    private JButton bJornada;
    private JButton bLogout;
    private JLabel info;
    private JTextField tfResultadoAdm;
    private JButton BResultadoAdm;
    private JPanel PAdmin;
    private JButton bResultados;
    private JTextArea taCalsificacion;
    private JTextArea taJornada;
    private JComboBox cbPartidos;
    private JButton bActualizar;
    private JTextField tResultado;
    private JButton bAdmin;

    TreeMap<Integer, String> partidos;

    /**
     *
     * CONTRUCTOR DE LA VENTANA USUARIO
     *
     * @param admin detemina si accedes como usuario o adminsitrador
     *
     **/
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

        bResultados.setBorderPainted(false);
        bResultados.setFocusable(false);
        bResultados.setRolloverEnabled(true);

        bLogout.setBorderPainted(false);
        bLogout.setFocusable(false);
        bLogout.setRolloverEnabled(true);


        //Paneles de opciones invisibles
        PInfo.setVisible(true);
        PClasificacion.setVisible(false);
        PJornada.setVisible(false);
        PAdmin.setVisible(false);

        //Jornadas admin
        {
            bResultados.setVisible(admin);
            bAdmin.setVisible(admin);
            if(admin)
            llenarCBPartidos(cbPartidos);
        }

        aestheticBoton(bActualizar);
        aestheticBoton(bAdmin);

        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        bClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PInfo.setVisible(false);
                PAdmin.setVisible(false);
                PClasificacion.setVisible(true);
                PJornada.setVisible(false);

                getClasificacion();
            }
        });
        bJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PInfo.setVisible(false);
                PAdmin.setVisible(false);
                PJornada.setVisible(true);
                PClasificacion.setVisible(false);

                getJornadas();
            }
        });

        bResultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PInfo.setVisible(false);
                PAdmin.setVisible(true);
                PJornada.setVisible(false);
                PClasificacion.setVisible(false);
            }
        });

        bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.volverLogInUsuario();
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

        bResultados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bResultados.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bResultados.setBackground(UIManager.getColor("control"));
            }
        });
        bActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarResulado();
            }
        });
        bAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.irVAdmin();
            }
        });
    }

    private void aestheticBoton(JButton boton) {
        boton.setBorderPainted(false);
        boton.setFocusable(false);
        boton.setRolloverEnabled(true);
    }

    /**
     *
     * ACTUALIZA EL RESULTADO DEL PARTIDO
     *
     **/
    private void actualizarResulado() {
        try {
            String partido = cbPartidos.getSelectedItem().toString();
            boolean partidoSeleccionado = partido != "-Ninguno selecccionado-";
            if(partidoSeleccionado) {
                int cod_partido = 0;
                for (Map.Entry<Integer, String> entry : partidos.entrySet()) {
                    if (entry.getValue() == partido)
                        cod_partido = entry.getKey();
                }

                Main.actualizaResutlado(cod_partido, tResultado.getText());
            }
            else
                Validaciones.mostrarError("seleccione un partido");
        } catch (Exception e) {
            Validaciones.mostrarError(e.getMessage());
        }
    }

    /**
     *
     * LLENAR COMBOBOX CON LOS PARTIDOS
     *
     * @param cb JComboBox
     *
     **/
    private void llenarCBPartidos(JComboBox cb)  {
        try {
            partidos = Main.getPartidosEquipo();
            cb.removeAllItems();
            cb.addItem("-Ninguno selecccionado-");
            cb.setSelectedIndex(0);

            for (Map.Entry<Integer, String> entry : partidos.entrySet()) {
                cb.addItem(entry.getValue());
            }
        } catch (Exception e) {
            Validaciones.mostrarError(e.getMessage());
        }
    }

    /**
     *
     * LLENAR DATOS XML JORANDA
     *
     **/
    private void getJornadas() {
        taJornada.setText( Main.getResultadosJornadas());

    }

    /**
     *
     * LLENAR DATOS XML CLASIFICACION
     *
     **/
    private void getClasificacion() {
        taCalsificacion.setText( Main.getClasificacion());

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
