package Modelo.UML.VISTAS;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VISTA_EQUIPO", schema = "SYSTEM", catalog = "")
public class VistaEquipoEntity {
    @Basic
    @Column(name = "COD_EQUIPO", nullable = false, precision = 0)
    private byte codEquipo;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 30)
    private String nombre;
    @Basic
    @Column(name = "COD_ENTRENADOR", nullable = true, precision = 0)
    private Byte codEntrenador;
    @Basic
    @Column(name = "COD_ASISTENTE", nullable = true, precision = 0)
    private Byte codAsistente;
    @Basic
    @Column(name = "COD_JUGADOR", nullable = true, precision = 0)
    private Byte codJugador;
    @Basic
    @Column(name = "FECHA_FUNDACION")
    private Date fechaFundacion;
    @Basic
    @Column(name = "CIUDAD", nullable = true, length = 30)
    private String ciudad;
    @Basic
    @Column(name = "ESPONSOR", nullable = false, length = 25)
    private String esponsor;
    @Basic
    @Column(name = "NOMBRE_DUENIO", nullable = true, length = 30)
    private String nombreDuenio;
    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;

    public byte getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(byte codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getCodEntrenador() {
        return codEntrenador;
    }

    public void setCodEntrenador(Byte codEntrenador) {
        this.codEntrenador = codEntrenador;
    }

    public Byte getCodAsistente() {
        return codAsistente;
    }

    public void setCodAsistente(Byte codAsistente) {
        this.codAsistente = codAsistente;
    }

    public Byte getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Byte codJugador) {
        this.codJugador = codJugador;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
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
        VistaEquipoEntity that = (VistaEquipoEntity) o;
        return codEquipo == that.codEquipo && Objects.equals(nombre, that.nombre) && Objects.equals(codEntrenador, that.codEntrenador) && Objects.equals(codAsistente, that.codAsistente) && Objects.equals(codJugador, that.codJugador) && Objects.equals(fechaFundacion, that.fechaFundacion) && Objects.equals(ciudad, that.ciudad) && Objects.equals(esponsor, that.esponsor) && Objects.equals(nombreDuenio, that.nombreDuenio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEquipo, nombre, codEntrenador, codAsistente, codJugador, fechaFundacion, ciudad, esponsor, nombreDuenio);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
