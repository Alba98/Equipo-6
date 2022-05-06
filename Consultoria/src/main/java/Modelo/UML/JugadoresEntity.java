package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "JUGADORES", schema = "SYSTEM", catalog = "")
public class JugadoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JUGADOR")
    private byte codJugador;
    @Basic
    @Column(name = "ROL")
    private String rol;

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
}
