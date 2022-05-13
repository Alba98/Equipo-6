package Controlador;
import Vista.*;

import javax.swing.*;

public class Main {
    static JFrame frame;

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");
                VLogin();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }

        public static void VLogin(){
            frame=new JFrame("Inicio de sesion");
            frame.setContentPane(new VLogin().pPrincipal);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        }

    }
}
