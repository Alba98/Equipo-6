package Excepciones;

public class PassAdministradorError extends Exception {

    private static String mensajeError;

    public PassAdministradorError(){
    }
    public PassAdministradorError(String mensaje) {
        Error.mensajeError = mensaje;
    }


    public static String getMensajeError() {
        mensajeError="La contraseña es un campo obligatorio";
        return mensajeError;
    }

    public static void setMensajeError(String mensajeError) {
        PassAdministradorError.mensajeError = mensajeError;
    }
}
