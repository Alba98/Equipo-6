package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "JUGAR_PARA", schema = "SYSTEM", catalog = "")
public class JugarParaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_CONTRATO")
    private byte codContrato;
    @Basic
    @Column(name = "COD_JUGADOR")
    private Byte codJugador;
    @Basic
    @Column(name = "COD_EQUIPO")
    private Byte codEquipo;
    @Basic
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    @Basic
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    public byte getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(byte codContrato) {
        this.codContrato = codContrato;
    }

    public Byte getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Byte codJugador) {
        this.codJugador = codJugador;
    }

    public Byte getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Byte codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugarParaEntity that = (JugarParaEntity) o;
        return codContrato == that.codContrato && Objects.equals(codJugador, that.codJugador) && Objects.equals(codEquipo, that.codEquipo) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(fechaInicio, that.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codContrato, codJugador, codEquipo, fechaFin, fechaInicio);
    }
}
