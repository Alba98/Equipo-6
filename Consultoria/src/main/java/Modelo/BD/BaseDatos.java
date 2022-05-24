package Modelo.BD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;


    /**
     *
     * @author EQUIPO-6
     */
   public class BaseDatos {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction transaction;

    public BaseDatos() { openTransaction();  }

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

    public static java.sql.Date conversionDate(LocalDate fecha) {
        return java.sql.Date.valueOf(String.valueOf(fecha));
    }

    public static java.sql.Time conversionTime(LocalTime fecha) {
        return java.sql.Time.valueOf(fecha);
    }

}
