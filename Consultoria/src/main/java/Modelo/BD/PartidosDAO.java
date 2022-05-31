package Modelo.BD;
import Modelo.UML.EquiposEntity;
import Modelo.UML.PartidosEntity;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;


    /**
     *
     * @author EQUIPO-6
     */


public class PartidosDAO extends BaseDatos {

    public PartidosDAO() {    }

        /**
         * CREACION DEL PARTIDO
         * @param horaPartido  parámetro de registro.
         * @param codJornada    parámetro de registro.
         * @param nombreEquipo1   parámetro de registro.
         * @param nombreEquipo2 parámetro de registro.
         *
         **/

    public void crearPartido(String horaPartido, int codJornada, String nombreEquipo1, String nombreEquipo2) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_PARTIDOS.INSERT_PARTIDO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_HORA_PARTIDO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_COD_JORNADA", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_EQUIPO1", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_EQUIPO2", String.class, ParameterMode.IN);

        storedProcedure.setParameter("P_HORA_PARTIDO", horaPartido);
        storedProcedure.setParameter("P_COD_JORNADA", (byte) codJornada);
        storedProcedure.setParameter("P_EQUIPO1", nombreEquipo1);
        storedProcedure.setParameter("P_EQUIPO2", nombreEquipo2);

        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }
        /**
         * INSERTAR RESULTADOS DEL PARTIDO
         * @param codPartido  parámetro de registro.
         * @param resultado    parámetro de registro.
         *
         **/

    public void resultadosPartido(int codPartido, String resultado) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_PARTIDOS.INSERT_RESULTADO");

        storedProcedure.registerStoredProcedureParameter("P_COD_PARTIDO", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_RESULTADO", String.class, ParameterMode.IN);

        // set parameters
        storedProcedure.setParameter("P_COD_PARTIDO", (byte) codPartido);
        storedProcedure.setParameter("P_RESULTADO", resultado);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

        /**
         * CONSULTAR INRFORMACION DEL PARTIDO
         * @return listaPartidos;
         *
         **/
    public List<PartidosEntity> consultarPartidos() throws Exception {
        //iniciar transaccion
        transaction.begin();
        List<PartidosEntity> listaPartidos;

        // 3. Construir comandos SQL
        TypedQuery<PartidosEntity > qEventos =
                em.createNamedQuery("PartidosEntity.todos", PartidosEntity.class);
        listaPartidos = qEventos.getResultList();

        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return listaPartidos;
    }

}
