package Modelo.BD;
import Modelo.UML.JornadasEntity;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

    /**
     *
     * @author EQUIPO-6
     */


public class JornadasDAO extends BaseDatos {

    public JornadasDAO() {    }

        /**
         * CREACION DE LA JORNADA
         * @param  codTemporada parámetro de registro.
         * @param fechaJornada    parámetro de registro.
         *
         **/

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
        /**
         * CONSULTA DE LA JORNADA
         * @return listaJornadas
         *
         **/
    public List<JornadasEntity> consultarJornadas() throws Exception {
        //iniciar transaccion
        transaction.begin();
        List<JornadasEntity> listaJornadas;

        // 3. Construir comandos SQL
        TypedQuery<JornadasEntity > qEventos =
                em.createNamedQuery("JornadasEntity.toda", JornadasEntity.class);
        listaJornadas = qEventos.getResultList();

        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return listaJornadas;
    }

}
