package Modelo.BD;

import oracle.sql.DATE;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;

public class JornadasDAO extends BaseDatos {

    public JornadasDAO() {    }

    public void crearJornadas(Byte codTemporada, Date fechaJornada) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_JORNADA");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_COD_TEMPORADA", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_JORNADA", DATE.class, ParameterMode.IN);
        //storedProcedure.setParameter("P_COD_TEMPORADA", codTemporada);
        //storedProcedure.setParameter("P_FECHA_JORNADA", fechaJornada);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }


}
