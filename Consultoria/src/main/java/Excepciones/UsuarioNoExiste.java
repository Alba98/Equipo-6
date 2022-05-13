package Excepciones;

public class UsuarioNoExiste extends Exception {
    private  static String mensajeError;

    public UsuarioNoExiste() {
    }

    public UsuarioNoExiste(String mensajeError) {
        error.mensajeError=mensajeError;
    }

    public String getMensajeError(){
        mensajeError ="El usuario con el correo introducido no existe en la Base de Datos";
        return mensajeError;
    }

    public void setMensajeError(String mensajeError){
        error.mensajeError=mensajeError;
    }
}
