package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * ENTIDAD ASISTE
 * @author Equipo-6
 */
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

    /**
     *
     * GETTER COD CONTRATO
     *
     * @return codContrato
     *
     */
    public byte getCodContrato() {
        return codContrato;
    }

    /**
     *
     * SETTER COD CONTRATO
     *
     * @param codContrato
     *
     */
    public void setCodContrato(byte codContrato) {
        this.codContrato = codContrato;
    }

    /**
     *
     * GETTER COD ASISTENTE
     *
     * @return codAsitente
     *
     */
    public Byte getCodAsistente() {
        return codAsistente;
    }

    /**
     *
     * SETTER COD ASISTENTE
     *
     * @param codAsistente
     *
     */
    public void setCodAsistente(Byte codAsistente) {
        this.codAsistente = codAsistente;
    }

    /**
     *
     * GETTER COD EQUIPO
     *
     * @return codEquipo
     *
     */
    public Byte getCodEquipo() {
        return codEquipo;
    }

    /**
     *
     * SETTER COD EQUIPO
     *
     * @param codEquipo
     *
     */
    public void setCodEquipo(Byte codEquipo) {
        this.codEquipo = codEquipo;
    }

    /**
     *
     * GETTER FECHA FIN
     *
     * @return fechaFin
     *
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     *
     * SETTER FECHA FIN
     *
     * @param fechaFin
     *
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     *
     * GETTER FECHA INICION
     *
     * @return fechaInicio
     *
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * SETTER FECHA INICIO
     *
     * @param fechaInicio
     *
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * COMPARA DOS OBJETO DE TIPO
     *
     * @param o
     *
     * @return codContrato
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsisteEntity that = (AsisteEntity) o;
        return codContrato == that.codContrato && Objects.equals(codAsistente, that.codAsistente) && Objects.equals(codEquipo, that.codEquipo) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(fechaInicio, that.fechaInicio);
    }

    /**
     *
     * DEVUELVE EL HASHCODE DEL OBJETO
     *
     * @return hashcode
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(codContrato, codAsistente, codEquipo, fechaFin, fechaInicio);
    }

    /**
     *
     * GETTER ASISTENTES POR COD ASISTENTE
     *
     * @return asistentesByCodAsistente
     *
     */
    public AsistentesEntity getAsistentesByCodAsistente() {
        return asistentesByCodAsistente;
    }

    /**
     *
     * SETTER ASISTENTES POR COD ASISTENTE
     *
     * @param asistentesByCodAsistente
     *
     */
    public void setAsistentesByCodAsistente(AsistentesEntity asistentesByCodAsistente) {
        this.asistentesByCodAsistente = asistentesByCodAsistente;
    }

    /**
     *
     * GETTER EQUIPOS POR COD EQUIPO
     *
     * @return equiposByCodEquipo
     *
     */
    public EquiposEntity getEquiposByCodEquipo() {
        return equiposByCodEquipo;
    }

    /**
     *
     * SETTER EQUIPOS POR COD EQUIPO
     *
     * @param equiposByCodEquipo
     *
     */
    public void setEquiposByCodEquipo(EquiposEntity equiposByCodEquipo) {
        this.equiposByCodEquipo = equiposByCodEquipo;
    }
}
