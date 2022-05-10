package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ENTRENADORES", schema = "SYSTEM", catalog = "")
public class EntrenadoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ENTRENADOR")
    private byte codEntrenador;

    public byte getCodEntrenador() {
        return codEntrenador;
    }

    public void setCodEntrenador(byte codEntrenador) {
        this.codEntrenador = codEntrenador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadoresEntity that = (EntrenadoresEntity) o;
        return codEntrenador == that.codEntrenador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codEntrenador);
    }
}
