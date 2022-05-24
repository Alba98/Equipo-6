package Modelo.BD;
import Modelo.UML.EquiposEntity;
import Modelo.UML.TemporadasEntity;

import javax.persistence.*;

public class TemporadasDAO extends BaseDatos{

    /**
     *
     * @author EQUIPO-6
     */

    public TemporadasDAO() {  }

    /**
     * CREACION DE LA TEMPORADA
     *
     **/
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

    public TemporadasEntity getUltimaTemporada() {
        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        TypedQuery<TemporadasEntity> qEventos =
                em.createNamedQuery("TemporadasEntity.max", TemporadasEntity.class);
        TemporadasEntity consulta = qEventos.getSingleResult();


        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return consulta;
    }

    public void cerrarTemporada(int cod) throws Exception{
        //iniciar transaccion
        transaction.begin();

        TemporadasEntity temporada = new TemporadasEntity();
        temporada.setCodTemporada((byte) cod);
        temporada.setAbierta("N");

        em.persist(temporada);

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }
}
