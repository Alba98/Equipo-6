package Modelo.BD;

import javax.persistence.*;

public class TemporadasDAO extends BaseDatos{

    public TemporadasDAO() {  }

    public void crearTemporada() throws Exception {
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
