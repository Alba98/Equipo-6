package Vista;

import Controlador.Main;
import Excepciones.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    private JLabel NNombre;
    private JLabel NApellido;
    private JLabel NSueldo;
    private JLabel NNacimiento;
    private JLabel NNacionalidad;
    private JLabel NNickname;
    private JLabel NEntrenador;
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

    private JTextField tANombre;
    private JTextField tAApellido;
    private JTextField tASueldo;
    private JTextField tAFNacimiento;
    private JTextField tAPais;
    private JTextField tANickname;
    private JComboBox cbAEntrenador;
    private JButton bARegistrar;
    private JButton bARestart;

    public VAdmin() {

        tJNombre.requestFocus();
        llenarCBRoles(cbJROL);
        llenarCBEntrenadores(cbAEntrenador);

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

        crearCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearCalendario();
            }
        });

        tANombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                llenarCBEntrenadores(cbAEntrenador);
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


