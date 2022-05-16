package Modelo.BD;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;
import java.time.LocalTime;

public class PartidosDAO extends BaseDatos {

    public PartidosDAO() {    }

    public void crearPartido(LocalTime horaPartido, int codJornada, String nombreEquipo1, String nombreEquipo2) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_PARTIDOS.INSERT_PARTIDO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_HORA_PARTIDO", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_COD_JORNADA", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_EQUIPO1", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_EQUIPO2", String.class, ParameterMode.IN);

        storedProcedure.setParameter("P_HORA_PARTIDO", conversionTime(horaPartido));
        storedProcedure.setParameter("P_COD_JORNADA", (byte) codJornada);
        storedProcedure.setParameter("P_EQUIPO1", nombreEquipo1);
        storedProcedure.setParameter("P_EQUIPO2", nombreEquipo2);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void resultadosPartido(int codPartido, String resultado) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_PARTIDOS.INSERT_RESULTADO");

        storedProcedure.registerStoredProcedureParameter("P_COD_PARTIDO", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_RESULTADO", String.class, ParameterMode.IN);

        // set parameters
        storedProcedure.setParameter("P_COD_PARTIDO", (byte) codPartido);
        storedProcedure.setParameter("P_RESULTADO", resultado);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

}
