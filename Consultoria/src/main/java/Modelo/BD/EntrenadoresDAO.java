package Modelo.BD;

import javax.persistence.StoredProcedureQuery;
import java.sql.Date;

public class EntrenadoresDAO extends DAO  {

    public EntrenadoresDAO() {    }

    public void crearEntrenador(String nickname, String nombre, String apellido, Date fechaNacimiento,
                               String nacionalidad, Integer sueldo) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_ENTRENADOR");
        // set parameters
        storedProcedure.setParameter("P_NICKNAME", nickname);
        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_APELLIDO", apellido);
        storedProcedure.setParameter("P_FECHA_NACIMIENTO", fechaNacimiento);
        storedProcedure.setParameter("P_NACIONALIDAD", nacionalidad);
        storedProcedure.setParameter("P_SUELDO", sueldo);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }
}
