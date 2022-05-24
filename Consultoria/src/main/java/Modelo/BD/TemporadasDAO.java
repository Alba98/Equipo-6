package Modelo.BD;
import Modelo.UML.EquiposEntity;
import Modelo.UML.JornadasEntity;
import Modelo.UML.TemporadasEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    public int getUltimaTemporada() {
        BigDecimal codTemporada = (BigDecimal) em.createNativeQuery(
                        "SELECT max_temporada() FROM DUAL"
                )
                .getSingleResult();

        return codTemporada.intValue();
    }

    public void cerrarTemporada(int cod) throws Exception{

        TemporadasEntity temporada = getTemporada(cod);

        //iniciar transaccion
        transaction.begin();

        temporada.setAbierta("N");

        em.persist(temporada);

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public TemporadasEntity getTemporada(int cod) {
        //iniciar transaccion
        transaction.begin();

        // 3. Construir comandos SQL
        TypedQuery<TemporadasEntity > query =
                em.createNamedQuery("TemporadasEntity.porCod", TemporadasEntity.class);
        query.setParameter(1, (short)cod);

        TemporadasEntity temp = query.getSingleResult();

        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return  temp;
    }
}
