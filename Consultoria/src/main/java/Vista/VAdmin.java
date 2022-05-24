package Vista;

import Controlador.Main;
import Excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * VENTANA ADMINISTADOR + INSERCION DE DATOS A LA BBDD
 * @author Equipo-6
 */
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
    private JTextField fechaPrimeraJornada;

    /**
     *
     * CONTRUCTOR DE LA VENTANA DE ADMINISTRADOR
     *
     **/
    public VAdmin()  {

        try {
            tJNombre.requestFocus();
            llenarCBRoles(cbJROL);
            llenarCB(cbAEntrenador, Main.getEntrenadores());
            llenarCBBorrar();
            actualizarCBEquipo();
        }
        catch (Exception ex) {
            Validaciones.mostrarError(ex.getMessage());
        }

        //Aesthetics botonones:
        AestheticsBotones();

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
                if (Validaciones.validarFecha(fechaPrimeraJornada)) {
                    String fechaPrimeraJ = fechaPrimeraJornada.getText();
                    crearCalendario(fechaPrimeraJ);
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
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });
        tEqNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                actualizarCBEquipo();
                
            }
        });
    VentanaAdmins.addComponentListener(new ComponentAdapter() { } );VentanaAdmins.addContainerListener(new ContainerAdapter() { } );
        bBJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jugadorBorrar = (String) cbBJugadores.getSelectedItem();

                try {
                    boolean seleccionado = jugadorBorrar != "-Ninguno selecccionado--";
                    if(seleccionado) {
                        Main.borrarJugador(jugadorBorrar);
                        llenarCB(cbBJugadores, Main.getJugadores());
                    }
                    else
                        Validaciones.mostrarError("selecione un jugador");
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
                    boolean seleccionado = nomEntre != "-Ninguno selecccionado--";
                    if(seleccionado) {
                        Main.borrarEntrenador(nomEntre);
                        llenarCB(cbBEntrenadores, Main.getEntrenadores());
                    }
                    else
                        Validaciones.mostrarError("selecione un entrenador");
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
                    boolean seleccionado = nomAsis != "-Ninguno selecccionado-";
                    if(seleccionado) {
                        Main.borrarAsistente(nomAsis);
                        llenarCB(cbBAsistentes, Main.getAsistentes());
                    }
                    else
                        Validaciones.mostrarError("selecione un asistente");
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
                    boolean equipoSeleccionado = nomEqui != "-Ninguno selecccionado-";
                    if(equipoSeleccionado) {
                        Main.borrarEquipo(nomEqui);
                        llenarCB(cbBEquipos, Main.getEquipos());
                    }
                    else
                        Validaciones.mostrarError("selecione un asistente");
                }
                catch (Exception ex){
                    Validaciones.mostrarError(ex.getMessage());
                }
            }
        });
        CBorrar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                llenarCBBorrar();
            }
        });


        CJugador.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                resetJugador();
            }
        });

        CEntrenador.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                resetEntrenador();
            }
        });

        CAsistente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                resetAsistente();
            }
        });

        CEquipo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                resetEquipos();
            }
        });
        VentanaAdmins.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                llenarCBBorrar();
                actualizarCBEquipo();
            }
        });
    }

    /**
     *
     * ACTUALIZAR CB BORRAR
     *
     **/
    private void llenarCBBorrar() {
        try {
            llenarCB(cbBJugadores, Main.getJugadores());
            llenarCB(cbBEntrenadores, Main.getEntrenadores());
            llenarCB(cbBAsistentes, Main.getAsistentes());
            llenarCB(cbBEquipos, Main.getEquipos());
        }
        catch (Exception ex) {
            Validaciones.mostrarError(ex.getMessage());
        }
    }


    /**
     *
     * AESTHETIC DE LOS BOTONES DE LA VETANANA
     *
     **/
    private void AestheticsBotones() {
        aestheticBoton(crearCalendarioButton);
        aestheticBoton(bJRegistrar);
        aestheticBoton(bJRestart);
        aestheticBoton(bERegistrar);
        aestheticBoton(bERestart);
        aestheticBoton(bARegistrar);
        aestheticBoton(bARestart);
        aestheticBoton(bEqRegistar);
        aestheticBoton(bEqRestart);
        aestheticBoton(bBJugadores);
        aestheticBoton(bBEntrenadores);
        aestheticBoton(bBAsistentes);
        aestheticBoton(bBEquipos);
    }

    /**
     *
     * AESTHETIC BOTON
     *
     * @param boton
     *
     **/
    private void aestheticBoton(JButton boton) {
        boton.setBorderPainted(false);
        boton.setFocusable(false);
        boton.setRolloverEnabled(true);
    }

    /**
     *
     * CREAR CALENDARIO PARTIDOS
     *
     *
     * @param fechaPrimeraJ*/
    private void crearCalendario(String fechaPrimeraJ) {
        try {
            Main.CrearCalendario();
            Main.irVUsuario();
        } catch (Exception ex) {
            Validaciones.mostrarError(ex.getMessage());
        }
    }

    /**
     *
     * REGISTRAR UN JUGADOR EN LA BBDD
     *
     **/
    private void registrarJugador() {
        if ( validarRegistrarJugador() ) {
            try {
                boolean rolValido = cbJROL.getSelectedItem().toString() != "-Ninguno selecccionado-";
                if(rolValido) {
                    Main.registrarJugador(tJNombre.getText(), tJApellido.getText(), tJSueldo.getText(),
                            tJFNacimiento.getText(), tJPais.getText(), tJNickname.getText(),
                            cbJROL.getSelectedItem().toString());
                }
                else
                    Validaciones.mostrarError("selecione un rol");

            } catch (Exception e) {
               Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    /**
     *
     * VALIDAR CAMPOS REGISTO JUGADOR
     *
     **/
    private boolean validarRegistrarJugador() {
        return (Validaciones.validarTexto(tJNombre) &&  Validaciones.validarTexto(tJApellido) &&
                Validaciones.validarFloat(tJSueldo) &&  Validaciones.validarFecha(tJFNacimiento) &&
                Validaciones.validarTexto(tJPais) &&    Validaciones.validarTexto(tJNickname));
    }

    /**
     *
     * RESET VALORES DE JUGADORES
     *
     **/
    private void resetJugador() {
        tJNombre.setText("");
        tJApellido.setText("");
        tJSueldo.setText("");
        tJFNacimiento.setText("");
        tJPais.setText("");
        tJNickname.setText("");
        cbJROL.setSelectedIndex(0);
    }

    /**
     *
     * LLENAR COMBOBOX CON LOS POSIBLES ROLES DE LOS JUGADORES
     *
     * @param cb JComboBox
     *
     **/
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

    /**
     *
     * REGISTRAR UN ENTRENADOR EN LA BBDD
     *
     **/
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

    /**
     *
     * VALIDAR CAMPOS REGISTO ENTRENADORES
     *
     **/
    private boolean validarRegistrarEntrenador() {
        return (Validaciones.validarTexto(tENombre) &&  Validaciones.validarTexto(tEApellido) &&
                Validaciones.validarFloat(tESueldo) &&  Validaciones.validarFecha(tEFNacimiento) &&
                Validaciones.validarTexto(tEPais) &&    Validaciones.validarTexto(tENickname));
    }

    /**
     *
     * RESET VALORES DE ENTRENADORES
     *
     **/
    private void resetEntrenador() {
        tENombre.setText("");
        tEApellido.setText("");
        tESueldo.setText("");
        tEFNacimiento.setText("");
        tEPais.setText("");
        tENickname.setText("");
    }

    /**
     *
     * REGISTRAR UN ASISTENTE EN LA BBDD
     *
     **/
    private void registrarAsistente() {
        if ( validarRegistrarAsistente() ) {
            try {
                boolean seleccionado = cbAEntrenador.getSelectedItem().toString() != "-Ninguno selecccionado-";
                if(seleccionado) {
                    Main.registrarAsistente(tANombre.getText(), tAApellido.getText(), tASueldo.getText(),
                            tAFNacimiento.getText(), tAPais.getText(), tANickname.getText(),
                            cbAEntrenador.getSelectedItem().toString());
                }
                else
                    Validaciones.mostrarError("selecione un asistente");
            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    /**
     *
     * VALIDAR CAMPOS REGISTO ASISTENET
     *
     **/
    private boolean validarRegistrarAsistente() {
        return (Validaciones.validarTexto(tANombre) &&  Validaciones.validarTexto(tAApellido) &&
                Validaciones.validarFloat(tASueldo) &&  Validaciones.validarFecha(tAFNacimiento) &&
                Validaciones.validarTexto(tAPais) &&    Validaciones.validarTexto(tANickname));
    }

    /**
     *
     * RESET VALORES DE ASISTENETES
     *
     **/
    private void resetAsistente() {
        tANombre.setText("");
        tAApellido.setText("");
        tASueldo.setText("");
        tAFNacimiento.setText("");
        tAPais.setText("");
        tANickname.setText("");
        cbAEntrenador.setSelectedIndex(0);
        llenarCBEntrenadores(cbAEntrenador);
    }

    private void llenarCBEntrenadores(JComboBox cb) {
        try {
            ArrayList<String> entrenadores = Main.getEntrenadores();
            cb.removeAllItems();
            cb.addItem("-Ninguno selecccionado-");
            cb.setSelectedIndex(0);
            for (String entrenador : entrenadores) {
                cb.addItem(entrenador);
            }
        } catch (Exception e) {
            Validaciones.mostrarError(e.getMessage());
        }
    }

    private void registrarEquipos() {
        if ( validarRegistrarEquipos() ) {
            try {
                Main.registrarEquipo(tEqNombre.getText(), tEqFecha.getText(), tEqCiudad.getText(),
                        tEqSponsor.getText(), tEqDuenio.getText());
            } catch (Exception e) {
                Validaciones.mostrarError(e.getMessage());
            }
        }
    }

    /**
     *
     * VALIDAR CAMPOS REGISTO EQUIPO
     *
     **/
    private boolean validarRegistrarEquipos() {
        return (Validaciones.validarTexto(tEqNombre) &&  Validaciones.validarFecha(tEqFecha) &&
                Validaciones.validarTexto(tEqCiudad) &&  Validaciones.validarTexto(tEqSponsor) &&
                Validaciones.validarTexto(tEqDuenio));
    }

    /**
     *
     * RESET VALORES DE EQUIPOS
     *
     **/
    private void resetEquipos() {
        tEqNombre.setText("");
        tEqNombre.setText("");
        tEqFecha.setText("");
        tEqCiudad.setText("");
        tEqSponsor.setText("");
        tEqDuenio.setText("");
        actualizarCBEquipo();
    }

    /**
     *
     * ACTUALIZAR CB EQUIPOS
     *
     **/
    private void actualizarCBEquipo() {
        try {
            llenarCB(cbEqEntre, Main.getEntrenadores());
            llenarCB(cbEqAsistente, Main.getAsistentes());
            llenarCB(cbEqTOP, Main.getToplaners());
            llenarCB(cbEqSuplente, Main.getJugadores());
            llenarCB(cbEqJGL, Main.getJunglers());
            llenarCB(cbEqMID, Main.getMidlaners());
            llenarCB(cbEqADC, Main.getADCarrys());
            llenarCB(cbEqSUPP, Main.getSupports());
        } catch (Exception ex) {
            Validaciones.mostrarError(ex.getMessage());
        }
    }

    /**
     *
     * LLENAR COMBOBOX GENERICO
     *
     * @param cb JComboBox
     * @param lista Array con los valores con los q llenar la box
     *
     **/
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

    /**
     *
     * GETTER JPANEL PRINCIPAL DE LA VENTANA
     *
     * @return pPrincipal
     *
     **/
    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


