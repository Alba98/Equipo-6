package Modelo.BD;

import javax.persistence.StoredProcedureQuery;

public class PartidosDAO extends BaseDatos {

    public PartidosDAO() {    }

    public void crearPartido(String horaPartido, Byte codJornada, String nombreEquipo1, String nombreEquipo2) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_PARTIDO");
        // set parameters
        storedProcedure.setParameter("P_HORA_PARTIDO", horaPartido);
        storedProcedure.setParameter("P_COD_JORNADA", codJornada);
        storedProcedure.setParameter("P_EQUIPO1", nombreEquipo1);
        storedProcedure.setParameter("P_EQUIPO2", nombreEquipo2);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void resultadosPartido(byte codPartido, String resultado) {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_RESULTADO");
        // set parameters
        storedProcedure.setParameter("P_COD_PARTIDO", codPartido);
        storedProcedure.setParameter("P_RESULTADO", resultado);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

}
