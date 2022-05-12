package Modelo.BD;

import javax.persistence.StoredProcedureQuery;
import java.sql.Date;

public class AsistentesDAO extends DAO  {

    public AsistentesDAO() {    }

    public void crearAsistente(String nickname, String nombre, String apellido, Date fechaNacimiento,
                               String nacionalidad, Integer sueldo, String nicknameEntenador) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_ASISTENTE");
        // set parameters
        storedProcedure.setParameter("P_NICKNAME", nickname);
        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_APELLIDO", apellido);
        storedProcedure.setParameter("P_FECHA_NACIMIENTO", fechaNacimiento);
        storedProcedure.setParameter("P_NACIONALIDAD", nacionalidad);
        storedProcedure.setParameter("P_SUELDO", sueldo);
        storedProcedure.setParameter("P_NICKNAME_ENTRENADOR", nicknameEntenador);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }
}
