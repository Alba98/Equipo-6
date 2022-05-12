package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "USUARIOS", schema = "DAW26", catalog = "")
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
    @Column(name = "COD_ROL", nullable = true, precision = 0)
    private Byte codRol;
    @ManyToOne
    @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL")
    private RolEntity rolByCodRol;

    public byte getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(byte codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getCodRol() {
        return codRol;
    }

    public void setCodRol(Byte codRol) {
        this.codRol = codRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return codUsuario == that.codUsuario && Objects.equals(nombre, that.nombre) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(codRol, that.codRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, nombre, fechaNacimiento, password, email, codRol);
    }

    public RolEntity getRolByCodRol() {
        return rolByCodRol;
    }

    public void setRolByCodRol(RolEntity rolByCodRol) {
        this.rolByCodRol = rolByCodRol;
    }
}
