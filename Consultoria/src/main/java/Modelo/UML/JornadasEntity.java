package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "JORNADAS", schema = "DAW26", catalog = "")
public class JornadasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JORNADA", nullable = false, precision = 0)
    private byte codJornada;
    @Basic
    @Column(name = "COD_TEMPORADA", nullable = true, precision = 0)
    private Byte codTemporada;
    @Basic
    @Column(name = "FECHA_JORNADA", nullable = true)
    private Date fechaJornada;
    @ManyToOne
    @JoinColumn(name = "COD_TEMPORADA", referencedColumnName = "COD_TEMPORADA")
    private TemporadasEntity temporadasByCodTemporada;
    @OneToMany(mappedBy = "jornadasByCodJornada")
    private Collection<PartidosEntity> partidosByCodJornada;

    public byte getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(byte codJornada) {
        this.codJornada = codJornada;
    }

    public Byte getCodTemporada() {
        return codTemporada;
    }

    public void setCodTemporada(Byte codTemporada) {
        this.codTemporada = codTemporada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JornadasEntity that = (JornadasEntity) o;
        return codJornada == that.codJornada && Objects.equals(codTemporada, that.codTemporada) && Objects.equals(fechaJornada, that.fechaJornada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codJornada, codTemporada, fechaJornada);
    }

    public TemporadasEntity getTemporadasByCodTemporada() {
        return temporadasByCodTemporada;
    }

    public void setTemporadasByCodTemporada(TemporadasEntity temporadasByCodTemporada) {
        this.temporadasByCodTemporada = temporadasByCodTemporada;
    }

    public Collection<PartidosEntity> getPartidosByCodJornada() {
        return partidosByCodJornada;
    }

    public void setPartidosByCodJornada(Collection<PartidosEntity> partidosByCodJornada) {
        this.partidosByCodJornada = partidosByCodJornada;
    }
}
