package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@NamedQuery(name = "JugadoresEntity.todas", query = "SELECT j FROM JugadoresEntity j")
@NamedQuery(name = "JugadoresEntity.TOP", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'TOP' ")
@NamedQuery(name = "JugadoresEntity.JGL", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'JGL' ")
@NamedQuery(name = "JugadoresEntity.MID", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'MID' ")
@NamedQuery(name = "JugadoresEntity.ADC", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'ADC' ")
@NamedQuery(name = "JugadoresEntity.SUPP", query = "SELECT j FROM JugadoresEntity j WHERE upper(j.rol)= 'SUPP' ")

@Entity
@Table(name = "JUGADORES", schema = "EQDAW06", catalog = "")
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

    public byte getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(byte codJugador) {
        this.codJugador = codJugador;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadoresEntity that = (JugadoresEntity) o;
        return codJugador == that.codJugador && Objects.equals(rol, that.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codJugador, rol);
    }

    public PersonasEntity getPersonasByCodJugador() {
        return personasByCodJugador;
    }

    public void setPersonasByCodJugador(PersonasEntity personasByCodJugador) {
        this.personasByCodJugador = personasByCodJugador;
    }

    public Collection<JugarParaEntity> getJugarParasByCodJugador() {
        return jugarParasByCodJugador;
    }

    public void setJugarParasByCodJugador(Collection<JugarParaEntity> jugarParasByCodJugador) {
        this.jugarParasByCodJugador = jugarParasByCodJugador;
    }
}
