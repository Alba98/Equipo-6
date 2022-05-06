package Modelo.UML.VISTAS;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VISTA_ASISTENTE", schema = "SYSTEM", catalog = "")
public class VistaAsistenteEntity {
    @Basic
    @Column(name = "COD_ASISTENTE")
    private byte codAsistente;
    @Basic
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic
    @Column(name = "COD_EQUIPO")
    private Byte codEquipo;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic
    @Column(name = "SUELDO")
    private Integer sueldo;

    public byte getCodAsistente() {
        return codAsistente;
    }

    public void setCodAsistente(byte codAsistente) {
        this.codAsistente = codAsistente;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Byte getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Byte codEquipo) {
        this.codEquipo = codEquipo;
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

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VistaAsistenteEntity that = (VistaAsistenteEntity) o;
        return codAsistente == that.codAsistente && Objects.equals(nickname, that.nickname) && Objects.equals(codEquipo, that.codEquipo) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nacionalidad, that.nacionalidad) && Objects.equals(sueldo, that.sueldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAsistente, nickname, codEquipo, nombre, apellido, fechaNacimiento, nacionalidad, sueldo);
    }
}
