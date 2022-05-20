package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ASISTENTES", schema = "EQDAW06", catalog = "")

@NamedQuery(name = "AsistentesEntity.todas", query = "SELECT a FROM AsistentesEntity a")
@NamedQuery(name = "AsistentesEntity.borrar", query = "SELECT a FROM AsistentesEntity a WHERE a.codAsistente = " +
        "                          (SELECT e.codPersona FROM PersonasEntity e WHERE upper(e.nickname)=?1 ) ")

public class AsistentesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ASISTENTE", nullable = false, precision = 0, insertable =false, updatable = false)
    private byte codAsistente;
    @Basic
    @Column(name = "COD_ENTRE_ASOCIADO", nullable = true, precision = 0, insertable =false, updatable = false)
    private Byte codEntreAsociado;
    @OneToMany(mappedBy = "asistentesByCodAsistente")
    private Collection<AsisteEntity> asistesByCodAsistente;
    @OneToOne
    @JoinColumn(name = "COD_ASISTENTE", referencedColumnName = "COD_PERSONA", nullable = false)
    private PersonasEntity personasByCodAsistente;
    @ManyToOne
    @JoinColumn(name = "COD_ENTRE_ASOCIADO", referencedColumnName = "COD_ENTRENADOR")
    private EntrenadoresEntity entrenadoresByCodEntreAsociado;

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

    public Collection<AsisteEntity> getAsistesByCodAsistente() {
        return asistesByCodAsistente;
    }

    public void setAsistesByCodAsistente(Collection<AsisteEntity> asistesByCodAsistente) {
        this.asistesByCodAsistente = asistesByCodAsistente;
    }

    public PersonasEntity getPersonasByCodAsistente() {
        return personasByCodAsistente;
    }

    public void setPersonasByCodAsistente(PersonasEntity personasByCodAsistente) {
        this.personasByCodAsistente = personasByCodAsistente;
    }

    public EntrenadoresEntity getEntrenadoresByCodEntreAsociado() {
        return entrenadoresByCodEntreAsociado;
    }

    public void setEntrenadoresByCodEntreAsociado(EntrenadoresEntity entrenadoresByCodEntreAsociado) {
        this.entrenadoresByCodEntreAsociado = entrenadoresByCodEntreAsociado;
    }
}
