package Excepciones;

public class PassUsuarioError extends Exception{
    private static String mensajeError;

    public PassUsuarioError(){
    }


    public PassUsuarioError(String mensajeError){
        error.mensajeError=mensajeError;
    }

    public static String getMensajeError() {
        mensajeError="La contraseña es un campo obligatorio";
        return mensajeError;
    }

    public static void setMensajeError(String mensajeError) {
        PassUsuarioError.mensajeError = mensajeError;
    }
}
