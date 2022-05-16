package Modelo.BD;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;
import java.time.LocalDate;

public class AsistentesDAO extends BaseDatos {

    public AsistentesDAO() {    }

    public void crearAsistente(String nickname, String nombre, String apellido, LocalDate fechaNacimiento,
                               String nacionalidad, Double sueldo, String nicknameEntenador) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_ASISTENTES.INSERT_PERSONA");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_NICKNAME", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_APELLIDO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_NACIMIENTO", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NACIONALIDAD", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_SUELDO", Double.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NICKNAME_ENTRENADOR", String.class, ParameterMode.IN);

        storedProcedure.setParameter("P_NICKNAME", nickname);
        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_APELLIDO", apellido);
        storedProcedure.setParameter("P_FECHA_NACIMIENTO", conversionDate(fechaNacimiento));
        storedProcedure.setParameter("P_NACIONALIDAD", nacionalidad);
        storedProcedure.setParameter("P_SUELDO", sueldo);
        storedProcedure.setParameter("P_NICKNAME_ENTRENADOR", nicknameEntenador);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }
}
