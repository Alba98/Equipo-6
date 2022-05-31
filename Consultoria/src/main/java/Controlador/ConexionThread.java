package Controlador;

public class ConexionThread implements Runnable{
    @Override
    public void run() {
        System.out.println("on thread");
        Main.cargarDatos();
    }
}
