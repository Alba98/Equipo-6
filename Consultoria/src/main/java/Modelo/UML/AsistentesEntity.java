package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ASISTENTES", schema = "SYSTEM", catalog = "")
public class AsistentesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ASISTENTE")
    private byte codAsistente;
    @Basic
    @Column(name = "COD_ENTRE_ASOCIADO")
    private Byte codEntreAsociado;

    public byte getCodAsistente() {
        return codAsistente;
    }

    public void setCodAsistente(byte codAsistente) {
        this.codAsistente = codAsistente;
    }

    public Byte getCodEntreAsociado() {
        return codEntreAsociado;
    }

    public void setCodEntreAsociado(Byte codEntreAsociado) {
        this.codEntreAsociado = codEntreAsociado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistentesEntity that = (AsistentesEntity) o;
        return codAsistente == that.codAsistente && Objects.equals(codEntreAsociado, that.codEntreAsociado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAsistente, codEntreAsociado);
    }
}
