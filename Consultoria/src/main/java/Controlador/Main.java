package Controlador;

import Vistas.VCarga;
import Vistas.VUsuario;

import javax.swing.*;

public class Main {
    private static JFrame carga;
    private static JDialog usuario;

    public static void main(String[] args) {
        try {
            //System.out.println(Main.class.getResource("Imagenes/juan-alberto.png"));
            //System.out.println("CONSULTORIA E-SPORTS ");
            VCarga();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }
    public static void VCarga() {
        carga = new JFrame("VCarga");
        carga.setContentPane(new VCarga().getPanel1());
        carga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carga.setLocationRelativeTo(null);
        carga.pack();
        carga.setVisible(true);
    }
    public static void VUsuario() {
        carga.dispose();
        usuario = new VUsuario();
        usuario.pack();
        usuario.setLocationRelativeTo(null);
        usuario.setVisible(true);
        System.exit(0);
    }
    public static void getDatosClasificacion(){
        //ClasificacionDAO ?:
    }
    public static void getDatosJornadaFinal(){
        //JornadaDAO where cod_jornada = max(cod_jornada):

    }
}
