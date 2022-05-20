package Excepciones;

public class errorTemporada {

    private String mensaje;

    public errorTemporada() {
    }

    public errorTemporada(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje="La temporada introducida no se encuentra en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
