package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * SENTENCIA SQL OBTENCIÖN DE TODOS LOS EQUIPOS
 *
 */
/**
 * ENTIDAD TEMPORADAS
 * @author Equipo-6
 */
@Entity
@Table(name = "TEMPORADAS", schema = "EQDAW06", catalog = "")
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

    /**
     *
     * GETTER COD TEMPORADA
     *
     * @return codTemporada
     *
     **/
    public short getCodTemporada() {
        return codTemporada;
    }

    /**
     *
     * SETTER COD TEMPORADA
     *
     * @param codTemporada
     *
     **/
    public void setCodTemporada(byte codTemporada) {
        this.codTemporada = codTemporada;
    }

    /**
     *
     * SETTER COD TEMPORADA
     *
     * @param codTemporada
     *
     **/
    public void setCodTemporada(short codTemporada) {
        this.codTemporada = codTemporada;
    }

    /**
     *
     * GETTER VARIABLE ABIERTA
     *
     * @return abierta
     *
     **/
    public String getAbierta() {
        return abierta;
    }

    /**
     *
     * SETTER VARIABLE ABIERTA
     *
     * @return abierta
     *
     **/
    public void setAbierta(String abierta) {
        this.abierta = abierta;
    }

    /**
     *
     * COMPARA DOS OBJETOS DE TIPO
     *
     * @param o
     *
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemporadasEntity that = (TemporadasEntity) o;
        return codTemporada == that.codTemporada && Objects.equals(abierta, that.abierta);
    }

    /**
     *
     * DEVUELEVE EL HASCODE DEL OBJETO
     *
     * @return hashcode
     *
     **/
    @Override
    public int hashCode() {
        return Objects.hash(codTemporada, abierta);
    }

    /**
     *
     * GETTER JORNADAS POR COD TEMPROADA
     *
     * @return jornadasByCodTemporada
     *
     **/
    public Collection<JornadasEntity> getJornadasByCodTemporada() {
        return jornadasByCodTemporada;
    }

    /**
     *
     * SETTER JORNADAS POR COD TEMPROADA
     *
     * @param jornadasByCodTemporada
     *
     **/
    public void setJornadasByCodTemporada(Collection<JornadasEntity> jornadasByCodTemporada) {
        this.jornadasByCodTemporada = jornadasByCodTemporada;
    }
}
