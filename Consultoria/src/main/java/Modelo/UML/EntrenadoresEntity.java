package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ENTRENADORES", schema = "EQDAW06", catalog = "")
public class EntrenadoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ENTRENADOR", nullable = false, precision = 0)
    private byte codEntrenador;
    @OneToMany(mappedBy = "entrenadoresByCodEntreAsociado")
    private Collection<AsistentesEntity> asistentesByCodEntrenador;
    @OneToMany(mappedBy = "entrenadoresByCodEntrenador")
    private Collection<EntrenaEntity> entrenasByCodEntrenador;
    @OneToOne
    @JoinColumn(name = "COD_ENTRENADOR", referencedColumnName = "COD_PERSONA", nullable = false)
    private PersonasEntity personasByCodEntrenador;

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

    public Collection<AsistentesEntity> getAsistentesByCodEntrenador() {
        return asistentesByCodEntrenador;
    }

    public void setAsistentesByCodEntrenador(Collection<AsistentesEntity> asistentesByCodEntrenador) {
        this.asistentesByCodEntrenador = asistentesByCodEntrenador;
    }

    public Collection<EntrenaEntity> getEntrenasByCodEntrenador() {
        return entrenasByCodEntrenador;
    }

    public void setEntrenasByCodEntrenador(Collection<EntrenaEntity> entrenasByCodEntrenador) {
        this.entrenasByCodEntrenador = entrenasByCodEntrenador;
    }

    public PersonasEntity getPersonasByCodEntrenador() {
        return personasByCodEntrenador;
    }

    public void setPersonasByCodEntrenador(PersonasEntity personasByCodEntrenador) {
        this.personasByCodEntrenador = personasByCodEntrenador;
    }
}
