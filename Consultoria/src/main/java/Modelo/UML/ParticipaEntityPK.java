package Modelo.UML;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ParticipaEntityPK implements Serializable {
    @Column(name = "COD_EQUIPO1", nullable = false, precision = 0, insertable =false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codEquipo1;
    @Column(name = "COD_EQUIPO2", nullable = false, precision = 0, insertable =false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codEquipo2;
    @Column(name = "COD_PARTIDO", nullable = false, precision = 0, insertable =false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codPartido;

    public byte getCodEquipo1() {
        return codEquipo1;
    }

    public void setCodEquipo1(byte codEquipo1) {
        this.codEquipo1 = codEquipo1;
    }

    public byte getCodEquipo2() {
        return codEquipo2;
    }

    public void setCodEquipo2(byte codEquipo2) {
        this.codEquipo2 = codEquipo2;
    }

    public byte getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(byte codPartido) {
        this.codPartido = codPartido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipaEntityPK that = (ParticipaEntityPK) o;
        return codEquipo1 == that.codEquipo1 && codEquipo2 == that.codEquipo2 && codPartido == that.codPartido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEquipo1, codEquipo2, codPartido);
    }
}
