package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * ENTIDAD ASISTENTES
 * @author Equipo-6
 */
@Entity
@Table(name = "ASISTENTES", schema = "EQDAW06", catalog = "")
/**
 * SENTENCIA SQL PARA OBTENER TODOS LOS ASISTENTES
 */
@NamedQuery(name = "AsistentesEntity.todas", query = "SELECT a FROM AsistentesEntity a")
/**
 * SENTENCIA SQL PARA OBTENER UN ASITENTE TENIENDO SU NICKNAME:
 * OBJETIVO FINAL --> BORRADO DEL ASISTENTE OBTENIDO
 */
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

    /**
     *
     * GETTER COD ASISTENTE
     *
     * @return codAsistente
     */
    public byte getCodAsistente() {
        return codAsistente;
    }

    /**
     *
     * SETTER COD ASISTENTE
     *
     * @param codAsistente
     *
     */
    public void setCodAsistente(byte codAsistente) {
        this.codAsistente = codAsistente;
    }

    /**
     *
     * GETTER COD ENTRE ASOCIADO
     *
     * @return codEntreAsociado
     *
     */
    public Byte getCodEntreAsociado() {
        return codEntreAsociado;
    }

    /**
     *
     * SETTER COD ENTRE ASOCIADO
     *
     * @param codEntreAsociado
     *
     */
    public void setCodEntreAsociado(Byte codEntreAsociado) {
        this.codEntreAsociado = codEntreAsociado;
    }

    /**
     *
     * COMPARA DOS OBJETOS DE TIPO
     *
     * @param o
     *
     * @return codAsistente
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistentesEntity that = (AsistentesEntity) o;
        return codAsistente == that.codAsistente && Objects.equals(codEntreAsociado, that.codEntreAsociado);
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
        return Objects.hash(codAsistente, codEntreAsociado);
    }

    /**
     *
     * GETTER ASISTES POR COD ASISTENTE
     *
     * @return asistentes
     *
     */
    public Collection<AsisteEntity> getAsistesByCodAsistente() {
        return asistesByCodAsistente;
    }

    /**
     *
     * ASISTES POR COD ASISTENTE
     *
     * @param asistesByCodAsistente
     */
    public void setAsistesByCodAsistente(Collection<AsisteEntity> asistesByCodAsistente) {
        this.asistesByCodAsistente = asistesByCodAsistente;
    }

    /**
     *
     * GETTER PERSONAS POR COD ASISTENTE
     *
     * @return personasByCodAsistente
     *
     */
    public PersonasEntity getPersonasByCodAsistente() {
        return personasByCodAsistente;
    }

    /**
     *
     * SETTER PERSONAS POR COD ASISTENTE
     *
     * @param personasByCodAsistente
     */
    public void setPersonasByCodAsistente(PersonasEntity personasByCodAsistente) {
        this.personasByCodAsistente = personasByCodAsistente;
    }

    /**
     *
     * GETTER ENTRENADORES POR COD ENTRE ASOCIADO
     *
     * @return entrenadoresByCodEntreAsociado
     *
     */
    public EntrenadoresEntity getEntrenadoresByCodEntreAsociado() {
        return entrenadoresByCodEntreAsociado;
    }

    /**
     *
     * SETTER ENTRENADORES POR COD ENTRE ASOCIADO
     *
     * @param entrenadoresByCodEntreAsociado
     */
    public void setEntrenadoresByCodEntreAsociado(EntrenadoresEntity entrenadoresByCodEntreAsociado) {
        this.entrenadoresByCodEntreAsociado = entrenadoresByCodEntreAsociado;
    }
}
