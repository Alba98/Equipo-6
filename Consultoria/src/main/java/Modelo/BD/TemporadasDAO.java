package Modelo.BD;

import javax.persistence.*;

public class TemporadasDAO {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction transaction;

    public TemporadasDAO() { openTransaction();  }

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

    public void openTransaction() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    public void closeTransaction() {
        if (transaction.isActive ()) {
            transaction.rollback ();
        }
        em.close ();
        emf.close ();
    }


}
