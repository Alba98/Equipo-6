package Modelo.BD;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;
import java.time.LocalDate;

public class JornadasDAO extends BaseDatos {

    public JornadasDAO() {    }

    public void crearJornadas(int codTemporada, LocalDate fechaJornada) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_JORNADAS.INSERT_JORNADA");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_COD_TEMPORADA", Short.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_JORNADA", Date.class, ParameterMode.IN);
        storedProcedure.setParameter("P_COD_TEMPORADA", (short)codTemporada);
        storedProcedure.setParameter("P_FECHA_JORNADA", conversionDate(fechaJornada));
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

}
