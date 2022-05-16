package Controlador;

public class Main {

    public static void main(String[] args) {
        try {
            bd=new BaseDatos();
            pDAO=new PersonasDAO(bd.getConnection());

            System.out.println("CONSULTORIA E-SPORTS ");
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }
}
