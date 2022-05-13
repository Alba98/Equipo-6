package Vista;

import com.company.Main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdmin {
    private JPanel PanelPrincipal;
    private JMenuBar MenuAdmin;
    private JMenu MenuCalendario;
    private JMenu MenuRegistrar;
    private JMenu MenuSalir;
    private JMenuItem MenuCalSeguro;
    private JMenuItem RegistrarEquipo;
    private JMenuItem RegistrarContrato;
    private JMenu RegistrarPersona;
    private JMenuItem RegistrarJugador;
    private JMenuItem RegistrarEntrenador;
    private JMenuItem RegistrarAsistente;
    private JMenuItem MenuSalConfirmar;
    private JPanel PanelMenu;
    private JPanel PanelCuerpo;
    private JLabel TextoBienvenida;
/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaAdmin");
        frame.setContentPane(new VentanaAdmin().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
*/


    public VentanaAdmin() {

       MenuCalSeguro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearCalendario();
                //return;
            }
        });

        RegistrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearEquipo();
                //return;
            }
        });

        RegistrarContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearContrato();
                //return;
            }
        });

        RegistrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearJugador();
                //return;
            }
        });

        RegistrarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearEntrenador();
                //return;
            }
        });

        RegistrarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.CrearAsistente();
                //return;
            }
        });

        MenuSalConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.SalirMenu();
                //return;
            }
        });
    }



    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        PanelPrincipal = panelPrincipal;
    }

    public JMenuBar getMenuAdmin() {
        return MenuAdmin;
    }

    public void setMenuAdmin(JMenuBar menuAdmin) {
        MenuAdmin = menuAdmin;
    }

    public JMenu getMenuCalendario() {
        return MenuCalendario;
    }

    public void setMenuCalendario(JMenu menuCalendario) {
        MenuCalendario = menuCalendario;
    }

    public JMenu getMenuRegistrar() {
        return MenuRegistrar;
    }

    public void setMenuRegistrar(JMenu menuRegistrar) {
        MenuRegistrar = menuRegistrar;
    }

    public JMenu getMenuSalir() {
        return MenuSalir;
    }

    public void setMenuSalir(JMenu menuSalir) {
        MenuSalir = menuSalir;
    }

    public JMenuItem getMenuCalSeguro() {
        return MenuCalSeguro;
    }

    public void setMenuCalSeguro(JMenuItem menuCalSeguro) {
        MenuCalSeguro = menuCalSeguro;
    }

    public JMenuItem getRegistrarEquipo() {
        return RegistrarEquipo;
    }

    public void setRegistrarEquipo(JMenuItem registrarEquipo) {
        RegistrarEquipo = registrarEquipo;
    }

    public JMenuItem getRegistrarContrato() {
        return RegistrarContrato;
    }

    public void setRegistrarContrato(JMenuItem registrarContrato) {
        RegistrarContrato = registrarContrato;
    }

    public JMenu getRegistrarPersona() {
        return RegistrarPersona;
    }

    public void setRegistrarPersona(JMenu registrarPersona) {
        RegistrarPersona = registrarPersona;
    }

    public JMenuItem getRegistrarJugador() {
        return RegistrarJugador;
    }

    public void setRegistrarJugador(JMenuItem registrarJugador) {
        RegistrarJugador = registrarJugador;
    }

    public JMenuItem getRegistrarEntrenador() {
        return RegistrarEntrenador;
    }

    public void setRegistrarEntrenador(JMenuItem registrarEntrenador) {
        RegistrarEntrenador = registrarEntrenador;
    }

    public JMenuItem getRegistrarAsistente() {
        return RegistrarAsistente;
    }

    public void setRegistrarAsistente(JMenuItem registrarAsistente) {
        RegistrarAsistente = registrarAsistente;
    }

    public JMenuItem getMenuSalConfirmar() {
        return MenuSalConfirmar;
    }

    public void setMenuSalConfirmar(JMenuItem menuSalConfirmar) {
        MenuSalConfirmar = menuSalConfirmar;
    }

    public JPanel getPanelMenu() {
        return PanelMenu;
    }

    public void setPanelMenu(JPanel panelMenu) {
        PanelMenu = panelMenu;
    }

    public JPanel getPanelCuerpo() {
        return PanelCuerpo;
    }

    public void setPanelCuerpo(JPanel panelCuerpo) {
        PanelCuerpo = panelCuerpo;
    }

    public JLabel getTextoBienvenida() {
        return TextoBienvenida;
    }

    public void setTextoBienvenida(JLabel textoBienvenida) {
        TextoBienvenida = textoBienvenida;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


}
