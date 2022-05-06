package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "JORNADAS", schema = "SYSTEM", catalog = "")
public class JornadasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JORNADA")
    private byte codJornada;
    @Basic
    @Column(name = "COD_TEMPORADA")
    private Byte codTemporada;
    @Basic
    @Column(name = "FECHA_JORNADA")
    private Date fechaJornada;

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
}
