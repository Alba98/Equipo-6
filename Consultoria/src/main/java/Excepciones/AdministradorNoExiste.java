package Excepciones;




    public class AdministradorNoExiste extends Exception {
        private static String mensajeError;


    public AdministradorNoExiste(){
    }

    public AdministradorNoExiste(String mensajeError) {
        Error.mensajeError = mensajeError;

    }

    public String getMensajeError(){

        mensajeError="Creedenciales incorrectas";
        return mensajeError;


    }

    public void setMensajeError(String mensajeError){
        Error.mensajeError=mensajeError;
    }



}

