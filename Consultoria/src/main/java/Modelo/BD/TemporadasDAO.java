package Modelo.BD;

import javax.persistence.StoredProcedureQuery;

public class TemporadasDAO extends DAO  {

    public TemporadasDAO() {    }

    public void crearTemporada() {
        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_TEMPORADA");
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }


}
