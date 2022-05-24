package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Equipo-6
 */

/**
 * ENTIDAD USUARIOS
 * SENTENCIA SQL PARA OBTENER LOS DATOS DE LOS USUARIOS
 *
 **/
@Entity
@Table(name = "USUARIOS", schema = "EQDAW06", catalog = "")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_USUARIO", nullable = false, precision = 0)
    private byte codUsuario;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 15)
    private String nombre;
    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "PASSWORD_", nullable = true, length = 20)
    private String password;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;
    @Basic
    @Column(name = "COD_ROL", nullable = true, precision = 0, insertable =false, updatable = false)
    private Byte codRol;
    @ManyToOne
    @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL")
    private RolEntity rolByCodRol;

    /**
     *
     * GETTER COD USUARIO
     *
     * @return codUsuario
     *
     **/
    public byte getCodUsuario() {
        return codUsuario;
    }

    /**
     *
     * SETTER COD USUARIO
     *
     * @param codUsuario
     *
     **/
    public void setCodUsuario(byte codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     *
     * GETTER NOMBRE
     *
     * @return nombre
     *
     **/
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * SETTER NOMBRE
     *
     * @param nombre
     *
     **/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * GETTER FECHA NACIMIENTO
     *
     * @return fechaNacimiento
     *
     **/
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * SETTER FECHA NACIMIENTO
     *
     * @param fechaNacimiento
     *
     **/
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * GETTER CONTRASENIA
     *
     * @return password
     *
     **/
    public String getPassword() {
        return password;
    }

    /**
     *
     * SETTER CONTRASENIA
     *
     * @param password
     *
     **/
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * GETTER EMAIL
     *
     * @return email
     *
     **/
    public String getEmail() {
        return email;
    }

    /**
     *
     * SETTER EMAIL
     *
     * @param email
     *
     **/
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * GETTER COD ROL
     *
     * @return codRol
     *
     **/
    public Byte getCodRol() {
        return codRol;
    }

    /**
     *
     * SETTER COD ROL
     *
     * @param codRol
     *
     **/
    public void setCodRol(Byte codRol) {
        this.codRol = codRol;
    }

    /**
     *
     *COMPARA QUE SEAN OBJETOS DEL MISMO TIPO
     *
     * @param o
     *
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return codUsuario == that.codUsuario && Objects.equals(nombre, that.nombre) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(codRol, that.codRol);
    }

    /**
     *
     * DEVUElVE EL HASCODE DEL OBJETO
     *
     * @return hashcode
     *
     **/
    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, nombre, fechaNacimiento, password, email, codRol);
    }

    /**
     *
     * GETTER ROL POR EL CODIGO DEL ROL
     *
     * @return rolByCodRol
     *
     **/
    public RolEntity getRolByCodRol() {
        return rolByCodRol;
    }

    /**
     *
     * SETTER ROL POR EL CODIGO DEL ROL
     *
     * @param rolByCodRol
     *
     **/
    public void setRolByCodRol(RolEntity rolByCodRol) {
        this.rolByCodRol = rolByCodRol;
    }
}
