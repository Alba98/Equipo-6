package Controlador;

import Vistas.VUsuario;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");
            VUsuario();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }
    public static void VUsuario() {
        VUsuario V1 = new VUsuario();
        V1.pack();
        V1.setLocationRelativeTo(null);
        V1.setVisible(true);
        System.exit(0);
    }
    public static void getDatosClasificacion(){
        //ClasificacionDAO ?:
    }
    public static void getDatosJornadaFinal(){
        //JornadaDAO where cod_jornada = max(cod_jornada):

    }
}
