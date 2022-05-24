package Modelo.BD;
import Modelo.UML.EntrenadoresEntity;
import Modelo.UML.JugadoresEntity;
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

public class EntrenadoresDAO extends BaseDatos {

    public EntrenadoresDAO() {    }
    /**
     * CREACION DEL ENTRENADOR
     * @param nickname  parámetro de registro.
     * @param nombre    parámetro de registro.
     * @param apellido   parámetro de registro.
     * @param fechaNacimiento parámetro de registro.
     * @param nacionalidad parámetro de registro.
     * @param sueldo parámetro de registro.
     */

    public void crearEntrenador(String nickname, String nombre, String apellido, LocalDate fechaNacimiento,
                               String nacionalidad, Double sueldo) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_ENTRENADORES.INSERT_PERSONA");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_NICKNAME", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_APELLIDO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_NACIMIENTO", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NACIONALIDAD", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_SUELDO", Double.class, ParameterMode.IN);

        storedProcedure.setParameter("P_NICKNAME", nickname);
        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_APELLIDO", apellido);
        storedProcedure.setParameter("P_FECHA_NACIMIENTO", conversionDate(fechaNacimiento));
        storedProcedure.setParameter("P_NACIONALIDAD", nacionalidad);
        storedProcedure.setParameter("P_SUELDO", sueldo);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

        /**
         *
         *CONSULTA DE ENTRENADOR
         * @return listaEntrenadores
         *
         */


    public List<EntrenadoresEntity> consultarEntrenadores() throws Exception {
        //iniciar transaccion
        transaction.begin();
        List<EntrenadoresEntity> listaEntrenadores;

        // 3. Construir comandos SQL
        TypedQuery <EntrenadoresEntity > qEventos =
                em.createNamedQuery("EntrenadoresEntity.todas", EntrenadoresEntity.class);
        listaEntrenadores = qEventos.getResultList();

        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return listaEntrenadores;
    }
        /**
         *
         *BORRAR ENTRENADOR
         * @param nomEntre
         *
         */

    public void borrarEntrenador(String nomEntre) throws Exception{
        //iniciar transaccion
        transaction.begin();

        // 3. Construir comandos SQL
        TypedQuery<EntrenadoresEntity> qEventos =
                em.createNamedQuery("EntrenadoresEntity.borrar", EntrenadoresEntity.class);
        qEventos.setParameter(1, nomEntre.toUpperCase());
        EntrenadoresEntity consulta = qEventos.getSingleResult();
        if (consulta != null){
            em.remove(consulta);
        }

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }
}
