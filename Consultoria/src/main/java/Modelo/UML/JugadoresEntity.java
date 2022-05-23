package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * ENTIDAD JUGADORES
 * @author Equipo-6
 */
@Entity
@Table(name = "JUGADORES", schema = "EQDAW06", catalog = "")
/**
 * SENTENCIA SQL PARA OBTENER TODOS LOS JUGADORES
 */
@NamedQuery(name = "JugadoresEntity.todas", query = "SELECT j FROM JugadoresEntity j")
/**
 * SENTENCIA SQL PARA OBTENER TODOS LOS JOGADORES EN EL ROL DE TOP, JGL, MID, ADC y SUPP RESPECTUVAMENTE
 */
@NamedQuery(name = "JugadoresEntity.TOP", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'TOP' ")
@NamedQuery(name = "JugadoresEntity.JGL", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'JGL' ")
@NamedQuery(name = "JugadoresEntity.MID", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'MID' ")
@NamedQuery(name = "JugadoresEntity.ADC", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'ADC' ")
@NamedQuery(name = "JugadoresEntity.SUPP", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'SUPP' ")
/**
 * SENTENCIA SQL PARA OBTENER UN JUGADOR POR SU NICKNAME
 * OBJETIVO FINAL--> ELIMINACION DEL JUGADOR OBTENIDO
 */
@NamedQuery(name = "JugadoresEntity.borrar", query = "SELECT j FROM JugadoresEntity j WHERE j.codJugador = " +
        "                          (SELECT e.codPersona FROM PersonasEntity e WHERE upper(e.nickname)=?1 ) ")

public class JugadoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JUGADOR", nullable = false, precision = 0)
    private byte codJugador;
    @Basic
    @Column(name = "ROL", nullable = true, length = 15)
    private String rol;
    @OneToOne
    @JoinColumn(name = "COD_JUGADOR", referencedColumnName = "COD_PERSONA", nullable = false)
    private PersonasEntity personasByCodJugador;
    @OneToMany(mappedBy = "jugadoresByCodJugador")
    private Collection<JugarParaEntity> jugarParasByCodJugador;

    /**
     * GETTER COD JUGADOR
     *
     * @return codJugador
     */
    public byte getCodJugador() {
        return codJugador;
    }

    /**
     *
     * SETTER COD JUGADOR
     *
     * @param codJugador
     */
    public void setCodJugador(byte codJugador) {
        this.codJugador = codJugador;
    }

    /**
     *
     * GETTER ROL
     *
     * @return rol
     */
    public String getRol() {
        return rol;
    }

    /**
     *
     * SETTER ROL
     *
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     *
     * COMPARA DOS OBJETOS TIPO
     *
     * @param o
     *
     * @return codJugador
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadoresEntity that = (JugadoresEntity) o;
        return codJugador == that.codJugador && Objects.equals(rol, that.rol);
    }

    /**
     *
     * DEVUELVE EL HASHCODE DEL OBJETO
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(codJugador, rol);
    }

    /**
     *
     * GETTER PERSONA POR COD JUGADOR
     *
     * @return personasByCodJugador
     */
    public PersonasEntity getPersonasByCodJugador() {
        return personasByCodJugador;
    }

    /**
     *
     * SETTER PERSONA POR COD JUGADOR
     *
     * @param personasByCodJugador
     */
    public void setPersonasByCodJugador(PersonasEntity personasByCodJugador) {
        this.personasByCodJugador = personasByCodJugador;
    }

    /**
     *
     * GETTER JUGAR PARA POR COD JUGADOR
     *
     * @return jugarParaByCodJugador
     */
    public Collection<JugarParaEntity> getJugarParasByCodJugador() {
        return jugarParasByCodJugador;
    }

    /**
     *
     * SETTER JUGAR PARA POR COD JUGADOR
     *
     * @param jugarParasByCodJugador
     */
    public void setJugarParasByCodJugador(Collection<JugarParaEntity> jugarParasByCodJugador) {
        this.jugarParasByCodJugador = jugarParasByCodJugador;
    }
}
