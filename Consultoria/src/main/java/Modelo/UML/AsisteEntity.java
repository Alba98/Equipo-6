package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ASISTE", schema = "EQDAW06", catalog = "")
public class AsisteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_CONTRATO", nullable = false, precision = 0)
    private byte codContrato;
    @Basic
    @Column(name = "COD_ASISTENTE", nullable = true, precision = 0,insertable =false, updatable = false)
    private Byte codAsistente;
    @Basic
    @Column(name = "COD_EQUIPO", nullable = true, precision = 0,insertable =false, updatable = false)
    private Byte codEquipo;
    @Basic
    @Column(name = "FECHA_FIN", nullable = true)
    private Date fechaFin;
    @Basic
    @Column(name = "FECHA_INICIO", nullable = true)
    private Date fechaInicio;
    @ManyToOne
    @JoinColumn(name = "COD_ASISTENTE", referencedColumnName = "COD_ASISTENTE")
    private AsistentesEntity asistentesByCodAsistente;
    @ManyToOne
    @JoinColumn(name = "COD_EQUIPO", referencedColumnName = "COD_EQUIPO")
    private EquiposEntity equiposByCodEquipo;

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

    public AsistentesEntity getAsistentesByCodAsistente() {
        return asistentesByCodAsistente;
    }

    public void setAsistentesByCodAsistente(AsistentesEntity asistentesByCodAsistente) {
        this.asistentesByCodAsistente = asistentesByCodAsistente;
    }

    public EquiposEntity getEquiposByCodEquipo() {
        return equiposByCodEquipo;
    }

    public void setEquiposByCodEquipo(EquiposEntity equiposByCodEquipo) {
        this.equiposByCodEquipo = equiposByCodEquipo;
    }
}
