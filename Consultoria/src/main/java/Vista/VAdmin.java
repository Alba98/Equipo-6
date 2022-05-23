package Vista;

import Controlador.Main;
import Excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VAdmin {
    private JTabbedPane VentanaAdmins;
    private JPanel PanelPrincipal;
    private JPanel CJugador;
    private JPanel CEquipo;
    private JPanel CEntrenador;
    private JPanel CAsistente;
    private JPanel CCalendario;
    private JPanel CAPrincipal;
    private JLabel NNombre;
    private JLabel NApellido;
    private JLabel NSueldo;
    private JLabel NNacimiento;
    private JLabel NNacionalidad;
    private JLabel NNickname;
    private JLabel NEntrenador;
    private JPanel CEQPrincipal;
    private JLabel NFecha;
    private JLabel NCiudad;
    private JLabel NEsponsor;
    private JLabel NDueño;
    private JPanel CJPrincipal;
    private JLabel NROL;
    private JComboBox cbJROL;
    private JPanel CEPrincipal;
    private JButton crearCalendarioButton;
    // jugadores
    private JTextField tJNombre;
    private JTextField tJApellido;
    private JTextField tJSueldo;
    private JTextField tJFNacimiento;
    private JTextField tJPais;
    private JTextField tJNickname;
    private JButton bJRegistrar;
    private JButton bJRestart;

    //Entrenadores
    private JTextField tENombre;
    private JTextField tEApellido;
    private JTextField tESueldo;
    private JTextField tEFNacimiento;
    private JTextField tEPais;
    private JTextField tENickname;
    private JButton bERegistrar;
    private JButton bERestart;

    //Asistentes

    private JLabel lANombre;
    private JLabel lAApellido;
    private JLabel lASueldo;
    private JLabel lAFechaNac;
    private JLabel lAPaiS;
    private JLabel lANickname;
    private JTextField tANombre;
    private JTextField tAApellido;
    private JTextField tASueldo;
    private JTextField tAFNacimiento;
    private JTextField tAPais;
    private JTextField tANickname;
    private JComboBox cbAEntrenador;
    private JButton bARegistrar;
    private JButton bARestart;

    // Equipos
    private JTextField tEqNombre;
    private JTextField tEqFecha;
    private JTextField tEqCiudad;
    private JTextField tEqSponsor;
    private JTextField tEqDuenio;
    private JButton bEqRegistar;
    private JButton bEqRestart;
    private JComboBox cbEqEntre;
    private JLabel lEqEntrenador;
    private JLabel lEqSTAFF;
    private JLabel lEqAsistente;
    private JComboBox cbEqAsistente;
    private JLabel lEqTOP;
    private JComboBox cbEqTOP;
    private JLabel lEqJugadore;
    private JLabel lEqJGL;
    private JComboBox cbEqJGL;
    private JComboBox cbEqMID;
    private JLabel lEqMID;
    private JLabel lEqADC;
    private JComboBox cbEqADC;
    private JComboBox cbEqSUPP;
    private JLabel lEqSUPP;
    private JComboBox cbEqSuplente;
    private JLabel lEqSuplente;
    private JPanel CBorrar;
    private JComboBox cbBJugadores;
    private JButton bBJugadores;
    private JComboBox cbBEntrenadores;
    private JButton bBEntrenadores;
    private JComboBox cbBAsistentes;
    private JButton bBAsistentes;
    private JComboBox cbBEquipos;
    private JButton bBEquipos;

    public VAdmin()  {

        try {
            tJNombre.requestFocus();
            llenarCBRoles(cbJROL);
            llenarCB(cbAEntrenador, Main.getEntrenadores());
            llenarCB(cbBJugadores, Main.getSuplentes());
            llenarCB(cbBEntrenadores, Main.getEntrenadores());
            llenarCB(cbBAsistentes, Main.getAsistentes());
            llenarCB(cbBEquipos, Main.getEquipos());
        }
        catch (Exception ex) {
            Validaciones.mostrarError(ex.getMessage());
        }

        //Aestetics botonones:

        crearCalendarioButton.setBorderPainted(false);
        crearCalendarioButton.setFocusable(false);
        crearCalendarioButton.setRolloverEnabled(true);

        bJRegistrar.setBorderPainted(false);
        bJRegistrar.setFocusable(false);
        bJRegistrar.setRolloverEnabled(true);

        bJRestart.setBorderPainted(false);
        bJRestart.setFocusable(false);
        bJRestart.setRolloverEnabled(true);

        bERegistrar.setBorderPainted(false);
        bERegistrar.setFocusable(false);
        bERegistrar.setRolloverEnabled(true);

        bERestart.setBorderPainted(false);
        bERestart.setFocusable(false);
        bERestart.setRolloverEnabled(true);

        bARegistrar.setBorderPainted(false);
        bARegistrar.setFocusable(false);
        bARegistrar.setRolloverEnabled(true);

        bARestart.setBorderPainted(false);
        bARestart.setFocusable(false);
        bARestart.setRolloverEnabled(true);

        bEqRegistar.setBorderPainted(false);
        bEqRegistar.setFocusable(false);
        bEqRegistar.setRolloverEnabled(true);

        bEqRestart.setBorderPainted(false);
        bEqRestart.setFocusable(false);
        bEqRestart.setRolloverEnabled(true);

        bBJugadores.setBorderPainted(false);
        bBJugadores.setFocusable(false);
        bBJugadores.setRolloverEnabled(true);

        bBEntrenadores.setBorderPainted(false);
        bBEntrenadores.setFocusable(false);
        bBEntrenadores.setRolloverEnabled(true);

        bBAsistentes.setBorderPainted(false);
        bBAsistentes.setFocusable(false);
        bBAsistentes.setRolloverEnabled(true);

        bBEquipos.setBorderPainted(false);
        bBEquipos.setFocusable(false);
        bBEquipos.setRolloverEnabled(true);

        //funciones MouseListener de los botones:

        crearCalendarioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                crearCalendarioButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                crearCalendarioButton.setBackground(UIManager.getColor("control"));
            }
        });

        bJRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bJRegistrar.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bJRegistrar.setBackground(UIManager.getColor("control"));
            }
        });

        bJRestart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bJRestart.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bJRestart.setBackground(UIManager.getColor("control"));
            }
        });

        bERegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bERegistrar.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bERegistrar.setBackground(UIManager.getColor("control"));
            }
        });

        bERestart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bERestart.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bERestart.setBackground(UIManager.getColor("control"));
            }
        });

        bARegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bARegistrar.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bARegistrar.setBackground(UIManager.getColor("control"));
            }
        });

        bARestart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bARestart.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bARestart.setBackground(UIManager.getColor("control"));
            }
        });

        bEqRegistar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bEqRegistar.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bEqRegistar.setBackground(UIManager.getColor("control"));
            }
        });

        bEqRestart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bEqRestart.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bEqRestart.setBackground(UIManager.getColor("control"));
            }
        });

        bBJugadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bBJugadores.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bBJugadores.setBackground(UIManager.getColor("control"));
            }
        });

        bBEntrenadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bBEntrenadores.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bBEntrenadores.setBackground(UIManager.getColor("control"));
            }
        });

        bBAsistentes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bBAsistentes.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bBAsistentes.setBackground(UIManager.getColor("control"));
            }
        });

        //Actiones listeners:

        bJRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarJugador();
            }
        });

        bJRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetJugador();
            }
        });

        bERegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEntrenador();
            }
        });

        bERestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetEntrenador();
            }
        });

        bERegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEntrenador();
            }
        });

        bERestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetEntrenador();
            }
        });

        bARegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAsistente();
            }
        });

        bARestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAsistente();
            }
        });

        bEqRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEquipos();
            }
        });

        bEqRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetEquipos();
            }
        });

        crearCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.CrearCalendario();
                    Main.VentanaUsuario(true);
                } catch (Exception ex) {
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });

        tANombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                try {
                    llenarCB(cbAEntrenador, Main.getEntrenadores());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        tEqNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                try {
                    llenarCB(cbEqEntre, Main.getEntrenadores());
                    llenarCB(cbEqAsistente, Main.getAsistentes());
                    llenarCB(cbEqTOP, Main.getToplaners());
                    llenarCB(cbEqSuplente, Main.getSuplentes());
                    llenarCB(cbEqJGL, Main.getJunglers());
                    llenarCB(cbEqMID, Main.getMidlaners());
                    llenarCB(cbEqADC, Main.getADCarrys());
                    llenarCB(cbEqSUPP, Main.getSupports());
                } catch (Exception ex) {
                    Validaciones.mostrarError(ex.getMessage());
                }

            }
        });
    VentanaAdmins.addComponentListener(new ComponentAdapter() { } );VentanaAdmins.addContainerListener(new ContainerAdapter() { } );
        bBJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jugadorBorrar = (String) cbBJugadores.getSelectedItem();
                try {
                    Main.borrarJugador(jugadorBorrar);
                    llenarCB(cbBJugadores, Main.getSuplentes());
                } catch (Exception ex) {
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });
        bBEntrenadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomEntre = (String) cbBEntrenadores.getSelectedItem();
                try {
                    Main.borrarEntrenador(nomEntre);
                    llenarCB(cbBEntrenadores, Main.getEntrenadores());
                }
                catch (Exception ex){
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });
        bBAsistentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomAsis = (String) cbBAsistentes.getSelectedItem();
                try {
                    Main.borrarAsistente(nomAsis);
                    llenarCB(cbBAsistentes, Main.getAsistentes());
                }
                catch (Exception ex){
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });
        bBEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomEqui = (String) cbBEquipos.getSelectedItem();
                try {
                    Main.borrarEquipo(nomEqui);
                    llenarCB(cbBEquipos, Main.getEquipos());
                }
                catch (Exception ex){
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });
    }

    private void registrarJugador() {
        if ( validarRegistrarJugador() ) {
            try {
                boolean rolValido = cbJROL.getSelectedItem().toString() != "-Ninguno selecccionado-";
                if(rolValido) {
                    Main.registrarJugador(tJNombre.getText(), tJApellido.getText(), tJSueldo.getText(),
                            tJFNacimiento.getText(), tJPais.getText(), tJNickname.getText(),
                            cbJROL.getSelectedItem().toString());
                }
            } catch (Exception e) {
               Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    private boolean validarRegistrarJugador() {
        return (Validaciones.validarTexto(tJNombre) &&  Validaciones.validarTexto(tJApellido) &&
                Validaciones.validarFloat(tJSueldo) &&  Validaciones.validarFecha(tJFNacimiento) &&
                Validaciones.validarTexto(tJPais) &&    Validaciones.validarTexto(tJNickname));
    }

    private void resetJugador() {
        tJNombre.setText("");
        tJApellido.setText("");
        tJSueldo.setText("");
        tJFNacimiento.setText("");
        tJPais.setText("");
        tJNickname.setText("");
        cbJROL.setSelectedIndex(0);
    }

    private void llenarCBRoles(JComboBox cb) {
        try {
            ArrayList<String> roles = new ArrayList<String>(
                    Arrays.asList("TOP", "JGL", "MID", "ADC", "SUPP"));
            cb.removeAllItems();
            cb.addItem("-Ninguno selecccionado-");
            cb.setSelectedIndex(0);
            for (String rol : roles) {
                cb.addItem(rol);
            }
        } catch (Exception e) {
            Validaciones.mostrarError(e.getMessage());
        }
    }

    private void registrarEntrenador() {
        if ( validarRegistrarEntrenador() ) {
            try {
                Main.registrarEntrenador(tENombre.getText(), tEApellido.getText(), tESueldo.getText(),
                                         tEFNacimiento.getText(), tEPais.getText(), tENickname.getText());

            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    private boolean validarRegistrarEntrenador() {
        return (Validaciones.validarTexto(tENombre) &&  Validaciones.validarTexto(tEApellido) &&
                Validaciones.validarFloat(tESueldo) &&  Validaciones.validarFecha(tEFNacimiento) &&
                Validaciones.validarTexto(tEPais) &&    Validaciones.validarTexto(tENickname));
    }

    private void resetEntrenador() {
        tENombre.setText("");
        tEApellido.setText("");
        tESueldo.setText("");
        tEFNacimiento.setText("");
        tEPais.setText("");
        tENickname.setText("");
    }

    private void registrarAsistente() {
        if ( validarRegistrarAsistente() ) {
            try {
                boolean rolValido = cbJROL.getSelectedItem().toString() != "-Ninguno selecccionado--";
                if(rolValido) {
                    Main.registrarAsistente(tANombre.getText(), tAApellido.getText(), tASueldo.getText(),
                            tAFNacimiento.getText(), tAPais.getText(), tANickname.getText(),
                            cbAEntrenador.getSelectedItem().toString());
                }
            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    private boolean validarRegistrarAsistente() {
        return (Validaciones.validarTexto(tANombre) &&  Validaciones.validarTexto(tAApellido) &&
                Validaciones.validarFloat(tASueldo) &&  Validaciones.validarFecha(tAFNacimiento) &&
                Validaciones.validarTexto(tAPais) &&    Validaciones.validarTexto(tANickname));
    }

    private void resetAsistente() {
        tANombre.setText("");
        tAApellido.setText("");
        tASueldo.setText("");
        tAFNacimiento.setText("");
        tAPais.setText("");
        tANickname.setText("");
        cbAEntrenador.setSelectedIndex(0);
    }

    private void registrarEquipos() {
        if ( validarRegistrarAsistente() ) {
            try {
                Main.registrarEquipo(tEqNombre.getText(), tEqFecha.getText(), tEqCiudad.getText(),
                        tEqSponsor.getText(), tEqDuenio.getText());
            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    private boolean validarRegistrarEquipos() {
        return (Validaciones.validarTexto(tEqNombre) &&  Validaciones.validarFecha(tEqFecha) &&
                Validaciones.validarTexto(tEqCiudad) &&  Validaciones.validarTexto(tEqSponsor) &&
                Validaciones.validarTexto(tEqDuenio));
    }

    private void resetEquipos() {
        tEqNombre.setText("");
        tEqFecha.setText("");
        tEqCiudad.setText("");
        tEqSponsor.setText("");
        tEqDuenio.setText("");
    }

    private void llenarCB(JComboBox cb, ArrayList<String> lista) {
        try {
            cb.removeAllItems();
            cb.addItem("-Ninguno selecccionado-");
            cb.setSelectedIndex(0);
            for (String item : lista) {
                cb.addItem(item);
            }
        } catch (Exception e) {
            Validaciones.mostrarError(e.getMessage());
        }
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


