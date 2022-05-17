package Excepciones;

public class errorJornada {

    private  String mensaje;

    public errorJornada() {
    }

    public errorJornada(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje="La jornada introducida no existe en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
