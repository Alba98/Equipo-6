package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "EQUIPOS", schema = "SYSTEM", catalog = "")
public class EquiposEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO")
    private byte codEquipo;
    @Basic
    @Column(name = "COD_PARTIDO")
    private Short codPartido;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic
    @Column(name = "ESPONSOR")
    private String esponsor;
    @Basic
    @Column(name = "NOMBRE_DUENIO")
    private String nombreDuenio;

    public byte getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(byte codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Short getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(Short codPartido) {
        this.codPartido = codPartido;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEsponsor() {
        return esponsor;
    }

    public void setEsponsor(String esponsor) {
        this.esponsor = esponsor;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquiposEntity that = (EquiposEntity) o;
        return codEquipo == that.codEquipo && Objects.equals(codPartido, that.codPartido) && Objects.equals(nombre, that.nombre) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(ciudad, that.ciudad) && Objects.equals(esponsor, that.esponsor) && Objects.equals(nombreDuenio, that.nombreDuenio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEquipo, codPartido, nombre, fechaNacimiento, ciudad, esponsor, nombreDuenio);
    }
}
