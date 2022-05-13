package com.company;

import Vista.*;

import javax.swing.*;

public class Main {
    private static JFrame ceq, ce, cc, cj, ca;

    public static void main(String[] args) {
	// write your code here

        JFrame frame = new JFrame("VentanaAdmin");
        frame.setContentPane(new VentanaAdmin().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void CrearCalendario() {
        String[] botones = {"Si", "No"};
            int ventana = JOptionPane.showOptionDialog(null,
                    "¿Estás seguro de crear el calendario? No se podrá modificar ni personas ni equipos",
                    "Se va a crear el calendario de esta temporada",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
            if (ventana == 0){
                System.out.println("Si");}
            else
                if (ventana == 1){
                    System.out.println("No");}
    }

    public static void CrearEquipo(){
        ceq = new JFrame("CreacionEquipo");
        ceq.setContentPane(new CreacionEquipo().getCEQPrincipal());
        ceq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ceq.setLocationRelativeTo(null);
        ceq.pack();
        ceq.setVisible(true);

    }

    public static void CrearContrato(){
        cc = new JFrame("CreacionContrato");
        cc.setContentPane(new CreacionContrato().getCCPrincipal());
        cc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc.setLocationRelativeTo(null);
        cc.pack();
        cc.setVisible(true);

    }

    public static void CrearJugador(){
        cj = new JFrame("CreacionJugador");
        cj.setContentPane(new CreacionJugador().getCJPrincipal());
        cj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cj.setLocationRelativeTo(null);
        cj.pack();
        cj.setVisible(true);

    }

    public static void CrearEntrenador(){
        ce = new JFrame("CreacionEntrenador");
        ce.setContentPane(new CrearEntrenador().getCEPrincipal());
        ce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ce.setLocationRelativeTo(null);
        ce.pack();
        ce.setVisible(true);

    }

    public static void CrearAsistente(){
        ca = new JFrame("CreacionAsistente");
        ca.setContentPane(new CreacionAsistente().getCAPrincipal());
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setLocationRelativeTo(null);
        ca.pack();
        ca.setVisible(true);

    }

    public static void SalirMenu(){

    }


}
