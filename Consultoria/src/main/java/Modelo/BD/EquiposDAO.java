package Modelo.BD;

import Modelo.UML.AsistentesEntity;
import Modelo.UML.EquiposEntity;
import Modelo.UML.JugadoresEntity;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EquiposDAO extends BaseDatos {

    public EquiposDAO() {    }

    public void crearEquipos(String nombre, LocalDate fechaFundacion, String ciudad, String sponsor,
                              String nombeDuenio) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_EQUIPO.INSERT_EQUIPO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_FUNDACION", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_CIUDAD", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_ESPONSOR", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE_DUENIO", String.class, ParameterMode.IN);

        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_FECHA_FUNDACION", conversionDate(fechaFundacion));
        storedProcedure.setParameter("P_CIUDAD", ciudad);
        storedProcedure.setParameter("P_ESPONSOR", sponsor);
        storedProcedure.setParameter("P_NOMBRE_DUENIO", nombeDuenio);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void contratoJugador(int jugador, int equipo, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_EQUIPO.CONTRATO_JUGADOR");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_COD_JUGADOR", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_COD_EQUIPO", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_FIN", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_INICIO", Date.class, ParameterMode.IN);

        storedProcedure.setParameter("P_COD_JUGADOR", (byte) jugador);
        storedProcedure.setParameter("P_COD_EQUIPO", (byte) equipo);
        storedProcedure.setParameter("P_FECHA_FIN", conversionDate(fechaFin));
        storedProcedure.setParameter("P_FECHA_INICIO", conversionDate(fechaInicio));
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void contratoEntrenador(int entrenador, int equipo, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_EQUIPO.CONTRATO_ENTRENADOR");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_COD_ENTRENADOR", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_COD_EQUIPO", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_FIN", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_INICIO", Date.class, ParameterMode.IN);

        storedProcedure.setParameter("P_COD_ENTRENADOR", (byte) entrenador);
        storedProcedure.setParameter("P_COD_EQUIPO", (byte) equipo);
        storedProcedure.setParameter("P_FECHA_FIN", conversionDate(fechaFin));
        storedProcedure.setParameter("P_FECHA_INICIO", conversionDate(fechaInicio));
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void contratoAsistente(int asistente, int equipo, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_EQUIPO.CONTRATO_ASISTENTE");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_COD_ASISTENTE", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_COD_EQUIPO", Byte.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_FIN", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_INICIO", Date.class, ParameterMode.IN);

        storedProcedure.setParameter("P_COD_ASISTENTE", (byte) asistente);
        storedProcedure.setParameter("P_COD_EQUIPO", (byte) equipo);
        storedProcedure.setParameter("P_FECHA_FIN", conversionDate(fechaFin));
        storedProcedure.setParameter("P_FECHA_INICIO", conversionDate(fechaInicio));
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public List<EquiposEntity> consultarEquipos() throws Exception {
        //iniciar transaccion
        transaction.begin();
        List<EquiposEntity> listaEquipos;

        // 3. Construir comandos SQL
        TypedQuery<EquiposEntity > qEventos =
                em.createNamedQuery("EquiposEntity.toda", EquiposEntity.class);
        listaEquipos = qEventos.getResultList();

        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return listaEquipos;
    }

    public void borrarEquipo(String nomEqui) throws Exception{
        //iniciar transaccion
        transaction.begin();

        // 3. Construir comandos SQL
        TypedQuery<EquiposEntity> qEventos =
                em.createNamedQuery("EquiposEntity.borrar", EquiposEntity.class);
        qEventos.setParameter(1, nomEqui.toUpperCase());
        EquiposEntity consulta = qEventos.getSingleResult();
        if (consulta != null){
            em.remove(consulta);
        }

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

}
