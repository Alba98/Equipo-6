package Excepciones;

public class credencialesIncorrectas extends Exception {

    private int tipo;

    public credencialesIncorrectas(int tipo){this.tipo=tipo;}

    public String getMessage(){

        switch (tipo) {
            case 1:
                return "El usuario no existe";
                //break;
            case 2:
                return "El adminsitrador no existe";
                //break;
            case 3:
                return "La contraseña debe tener como mínimo 8 caracteres.";
                 //break;
            case 4:
                return "La contraseña debe incluir como mínimo 2 números";
                //break;
            case 5:
                return "La contraseña debe incluir como mínimo 1 carácter especial";
                //break;
            case 6:
                return "El campo no puede estar vacío";
               //break;
            default:
                return "Error desconocido";
        }


    }
}












