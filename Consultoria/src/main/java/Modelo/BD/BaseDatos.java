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

        /**
         *CONSTRUCIÓN Y APERTURA DE LA PERSISTENCIA
         *
         */


    public void openTransaction() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

        /**
         *CLOSE LA PERSISTENCIA
         *
         */

    public void closeTransaction() {
        if (transaction.isActive ()) {
            transaction.rollback ();
        }
        em.close ();
        emf.close ();
    }


        /**
         *CONVERSION  DE JAVA.SQL DATE (ELEMENTOS DE TIEMPO DE LA BBDD QUE SE LEEN EN JAVA)
         * @return fecha
         */


    public static java.sql.Date conversionDate(LocalDate fecha) {
        return java.sql.Date.valueOf(String.valueOf(fecha));
    }

        /**
         *CONVERSION  DE JAVA.SQL TIME (ELEMENTOS DE TIEMPO DE LA BBDD QUE SE LEEN EN JAVA)
         * @return fecha
         */

    public static java.sql.Time conversionTime(LocalTime fecha) {
        return java.sql.Time.valueOf(fecha);
    }

}
