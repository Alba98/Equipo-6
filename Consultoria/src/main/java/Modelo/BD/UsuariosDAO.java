package Modelo.BD;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class UsuariosDAO extends BaseDatos {

    public UsuariosDAO() {    }

    public void crearUsuario(String nombre, LocalDate fechaNacimiento, String passwrd, String email) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_USUARIOS.INSERT_USUARIO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_NACIMIENTO", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_PASSWORD", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_EMAIL", String.class, ParameterMode.IN);

        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_FECHA_FUNDACION", conversionDate(fechaNacimiento));
        storedProcedure.setParameter("P_PASSWORD", passwrd);
        storedProcedure.setParameter("P_EMAIL", email);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public void crearAdministrador(String nombre, LocalDate fechaNacimiento, String passwrd, String email) throws Exception {

        //iniciar transaccion
        transaction.begin();

        // Ejecutar package
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GEST_USUARIOS.INSERT_ADMINISTRADOR");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_NACIMIENTO", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_PASSWORD", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_EMAIL", String.class, ParameterMode.IN);

        storedProcedure.setParameter("P_NOMBRE", nombre);
        storedProcedure.setParameter("P_FECHA_FUNDACION", conversionDate(fechaNacimiento));
        storedProcedure.setParameter("P_PASSWORD", passwrd);
        storedProcedure.setParameter("P_EMAIL", email);
        // execute SP
        storedProcedure.execute();

        // ejecutar las transaciones en la base de datos
        transaction.commit();
    }

    public int login(String email, char[] password) throws Exception {
        BigDecimal rol = (BigDecimal) em.createNativeQuery(
                        "SELECT log_in(:USERNAME, :PASSWD) FROM DUAL"
                )
                .setParameter("USERNAME", email)
                .setParameter("PASSWD", password)
                .getSingleResult();

        return rol.intValue();
    }
}
