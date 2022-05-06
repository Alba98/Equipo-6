package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PARTICIPA", schema = "SYSTEM", catalog = "")
@IdClass(ParticipaEntityPK.class)
public class ParticipaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO1")
    private byte codEquipo1;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO2")
    private byte codEquipo2;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PARTIDO")
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
        ParticipaEntity that = (ParticipaEntity) o;
        return codEquipo1 == that.codEquipo1 && codEquipo2 == that.codEquipo2 && codPartido == that.codPartido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEquipo1, codEquipo2, codPartido);
    }
}
