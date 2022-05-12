package Modelo.BD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction transaction;

    public DAO() {
        openTransaction();
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
