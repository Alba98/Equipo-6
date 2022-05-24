package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

/**
 * ENTIDAD JORNADAS
 * @author Equipo-6
 */
@Entity
@Table(name = "JORNADAS", schema = "EQDAW06", catalog = "")
/**
 * SENTENCIA SQL PARA OBTENER TODAS LAS JORNADAS
 *
 */
@NamedQuery(name = "JornadasEntity.toda", query = "SELECT j FROM JornadasEntity j")

public class JornadasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JORNADA", nullable = false, precision = 0)
    private byte codJornada;
    @Basic
    @Column(name = "COD_TEMPORADA", nullable = true, precision = 0,insertable =false, updatable = false)
    private Byte codTemporada;
    @Basic
    @Column(name = "FECHA_JORNADA", nullable = true)
    private Date fechaJornada;
    @ManyToOne
    @JoinColumn(name = "COD_TEMPORADA", referencedColumnName = "COD_TEMPORADA")
    private TemporadasEntity temporadasByCodTemporada;
    @OneToMany(mappedBy = "jornadasByCodJornada")
    private Collection<PartidosEntity> partidosByCodJornada;

    /**
     *
     * GETTER COD JORNADA
     *
     * @return codJornada
     *
     */
    public byte getCodJornada() {
        return codJornada;
    }

    /**
     *
     * SETTER COD JORNADA
     *
     * @param codJornada
     *
     */
    public void setCodJornada(byte codJornada) {
        this.codJornada = codJornada;
    }

    /**
     *
     * GETTER COD TEMPORADA
     *
     * @return codTemporad
     *
     */
    public Byte getCodTemporada() {
        return codTemporada;
    }

    /**
     *
     * SETTER COD TEMPORADA
     *
     * @param codTemporada
     *
     */
    public void setCodTemporada(Byte codTemporada) {
        this.codTemporada = codTemporada;
    }

    /**
     *
     * GETTER FECHA JORNADA
     *
     * @return fechaJornada
     *
     */
    public Date getFechaJornada() {
        return fechaJornada;
    }

    /**
     *
     * SETTER FECHA JORNADA
     *
     * @param fechaJornada
     *
     */
    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    /**
     *
     * COMPARA DOS OBJETOS DE TIPO
     *
     * @param o
     *
     * @return codJornada
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JornadasEntity that = (JornadasEntity) o;
        return codJornada == that.codJornada && Objects.equals(codTemporada, that.codTemporada) && Objects.equals(fechaJornada, that.fechaJornada);
    }

    /**
     *
     * DEVUELVE EL HASHCODE DEL OBJETO
     *
     * @return hashCode
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(codJornada, codTemporada, fechaJornada);
    }

    /**
     *
     * GETTER TEMPORADA POR COD TEMPORADA
     *
     * @return temporadasByCodTemporada
     */
    public TemporadasEntity getTemporadasByCodTemporada() {
        return temporadasByCodTemporada;
    }

    /**
     *
     * SETTER TEMPORADA POR COD TEMPORADA
     *
     * @param temporadasByCodTemporada
     */
    public void setTemporadasByCodTemporada(TemporadasEntity temporadasByCodTemporada) {
        this.temporadasByCodTemporada = temporadasByCodTemporada;
    }

    /**
     *
     * GETTER PARTIDO POR COD JORNADA
     *
     * @return partidosByCodJornada
     */
    public Collection<PartidosEntity> getPartidosByCodJornada() {
        return partidosByCodJornada;
    }

    /**
     *
     * SETTER PARTIDO POR COD JORNADA
     *
     * @param partidosByCodJornada
     */
    public void setPartidosByCodJornada(Collection<PartidosEntity> partidosByCodJornada) {
        this.partidosByCodJornada = partidosByCodJornada;
    }
}
