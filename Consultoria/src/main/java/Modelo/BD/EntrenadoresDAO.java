package Modelo.BD;

import Modelo.UML.EntrenadoresEntity;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EntrenadoresDAO extends BaseDatos {

    public EntrenadoresDAO() {    }

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
}
