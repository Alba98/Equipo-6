package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ASISTE", schema = "SYSTEM", catalog = "")
public class AsisteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_CONTRATO")
    private byte codContrato;
    @Basic
    @Column(name = "COD_ASISTENTE")
    private Byte codAsistente;
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

    public Byte getCodAsistente() {
        return codAsistente;
    }

    public void setCodAsistente(Byte codAsistente) {
        this.codAsistente = codAsistente;
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
        AsisteEntity that = (AsisteEntity) o;
        return codContrato == that.codContrato && Objects.equals(codAsistente, that.codAsistente) && Objects.equals(codEquipo, that.codEquipo) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(fechaInicio, that.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codContrato, codAsistente, codEquipo, fechaFin, fechaInicio);
    }
}
