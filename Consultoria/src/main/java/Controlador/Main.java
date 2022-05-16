package Controlador;

import Vista.*;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        try {

            JFrame frame = new JFrame("VentanaPrincipal");
            frame.setContentPane(new VentanaPrincipal().getPanelPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            System.out.println("CONSULTORIA E-SPORTS ");
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
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
}
