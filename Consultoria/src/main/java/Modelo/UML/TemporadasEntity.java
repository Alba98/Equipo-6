package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TEMPORADAS", schema = "DAW26", catalog = "")
public class TemporadasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_TEMPORADA", nullable = false, precision = 0)
    private short codTemporada;
    @Basic
    @Column(name = "ABIERTA", nullable = true, length = 1)
    private String abierta;
    @OneToMany(mappedBy = "temporadasByCodTemporada")
    private Collection<JornadasEntity> jornadasByCodTemporada;

    public short getCodTemporada() {
        return codTemporada;
    }

    public void setCodTemporada(short codTemporada) {
        this.codTemporada = codTemporada;
    }

    public String getAbierta() {
        return abierta;
    }

    public void setAbierta(String abierta) {
        this.abierta = abierta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemporadasEntity that = (TemporadasEntity) o;
        return codTemporada == that.codTemporada && Objects.equals(abierta, that.abierta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codTemporada, abierta);
    }

    public Collection<JornadasEntity> getJornadasByCodTemporada() {
        return jornadasByCodTemporada;
    }

    public void setJornadasByCodTemporada(Collection<JornadasEntity> jornadasByCodTemporada) {
        this.jornadasByCodTemporada = jornadasByCodTemporada;
    }
}
