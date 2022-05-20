package Modelo.BD;

import Modelo.UML.AlmacenXmlEntity;
import Modelo.UML.JugadoresEntity;

import javax.persistence.*;
import java.util.List;

public class AlmacenXML_DAO extends BaseDatos{

    public AlmacenXML_DAO() {  }

    public void generarClasificion() throws Exception {
        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("clasificacion");
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void generarJornadas() {
        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("resultados_jornadas");
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }



    public void borrarDatos() throws Exception {
        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        Query delete = em.createQuery("DELETE FROM ALMACEN_XML");

        delete.executeUpdate();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }


    public AlmacenXmlEntity getDatos() throws Exception {
        //iniciar transaccion
        transaction.begin();

        // 3. Construir comandos SQL
        TypedQuery<AlmacenXmlEntity> qAlmacen =
                em.createNamedQuery("AlmacenXmlEntity.todos", AlmacenXmlEntity.class);

        // ejecutar las transaciones en la base de datos
        transaction.commit();

        return qAlmacen.getResultList().get(0);
    }


}
