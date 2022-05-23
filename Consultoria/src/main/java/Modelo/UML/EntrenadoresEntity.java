package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * ENTIDAD ENTRENADORES
 * @author Equipo-6
 */
@Entity
@Table(name = "ENTRENADORES", schema = "EQDAW06", catalog = "")
/**
 * SENTENCIA SQL PARA OBTENER TODOS LOS ENTRENADORES
 */
@NamedQuery(name = "EntrenadoresEntity.todas", query = "SELECT e FROM EntrenadoresEntity e")
/**
 * SENTENCIA SQL PARA OBTENER UN ENTRENADOR POR NICKNAME:
 * OBJETIVO FINAL --> BORRADO DEL ENTRENADOR SELECCIONADO
 */
@NamedQuery(name = "EntrenadoresEntity.borrar", query = "SELECT e.codEntrenador FROM EntrenadoresEntity e WHERE e.codEntrenador=" +
        "(SELECT e.codPersona FROM PersonasEntity e WHERE upper(e.nickname)=?1 )")

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

    /**
     *
     * GETTER COD ENTRENADOR
     *
     * @return codEntrenador
     *
     */
    public byte getCodEntrenador() {
        return codEntrenador;
    }

    /**
     *
     * SETTER COD ENTRENADOR
     *
     * @param codEntrenador
     *
     */
    public void setCodEntrenador(byte codEntrenador) {
        this.codEntrenador = codEntrenador;
    }

    /**
     *
     * COMPARA DOS OBJETOS TIPO
     *
     * @param o
     *
     * @return codEntrenador
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadoresEntity that = (EntrenadoresEntity) o;
        return codEntrenador == that.codEntrenador;
    }

    /**
     *
     * DEVUELVE EL HASHCODE DEL OBJETO
     *
     * @return hashCode
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(codEntrenador);
    }

    /**
     *
     * GETTER ASISTENTES POR COD ENTRENADOR
     *
     * @return asistentesByCosEntrenador
     *
     */
    public Collection<AsistentesEntity> getAsistentesByCodEntrenador() {
        return asistentesByCodEntrenador;
    }

    /**
     *
     * SETTER ASISTENTES POR COD ENTRENADOR
     *
     * @param asistentesByCodEntrenador
     *
     */
    public void setAsistentesByCodEntrenador(Collection<AsistentesEntity> asistentesByCodEntrenador) {
        this.asistentesByCodEntrenador = asistentesByCodEntrenador;
    }

    /**
     *
     * GETTER ENTRENAS POR ENTRENADOR
     *
     * @return entrenasByCodEntrenador
     *
     */
    public Collection<EntrenaEntity> getEntrenasByCodEntrenador() {
        return entrenasByCodEntrenador;
    }

    /**
     *
     * SETTER ENTRENAS POR COD ENTRENADOR
     *
     * @param entrenasByCodEntrenador
     *
     */
    public void setEntrenasByCodEntrenador(Collection<EntrenaEntity> entrenasByCodEntrenador) {
        this.entrenasByCodEntrenador = entrenasByCodEntrenador;
    }

    /**
     *
     * GETTER PERSONAS BY COD ENTRENADOR
     *
     * @return personasByCodEntrenador
     *
     */
    public PersonasEntity getPersonasByCodEntrenador() {
        return personasByCodEntrenador;
    }

    /**
     *
     * SETTER PERSONAS BY COD ENTRENADOR
     *
     * @param personasByCodEntrenador
     */
    public void setPersonasByCodEntrenador(PersonasEntity personasByCodEntrenador) {
        this.personasByCodEntrenador = personasByCodEntrenador;
    }
}
