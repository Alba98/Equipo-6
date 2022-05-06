package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "PERSONAS", schema = "SYSTEM", catalog = "")
public class PersonasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PERSONA")
    private byte codPersona;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic
    @Column(name = "SUELDO")
    private Integer sueldo;
    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic
    @Column(name = "NICKNAME")
    private String nickname;

    public byte getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(byte codPersona) {
        this.codPersona = codPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonasEntity that = (PersonasEntity) o;
        return codPersona == that.codPersona && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(sueldo, that.sueldo) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nacionalidad, that.nacionalidad) && Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPersona, nombre, apellido, sueldo, fechaNacimiento, nacionalidad, nickname);
    }
}
