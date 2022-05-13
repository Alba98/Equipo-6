package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "JUGAR_PARA", schema = "SYSTEM", catalog = "")
public class JugarParaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_CONTRATO", nullable = false, precision = 0)
    private byte codContrato;
    @Basic
    @Column(name = "COD_JUGADOR", nullable = true, precision = 0, insertable =false, updatable = false)
    private Byte codJugador;
    @Basic
    @Column(name = "COD_EQUIPO", nullable = true, precision = 0, insertable =false, updatable = false)
    private Byte codEquipo;
    @Basic
    @Column(name = "FECHA_FIN", nullable = true)
    private Date fechaFin;
    @Basic
    @Column(name = "FECHA_INICIO", nullable = true)
    private Date fechaInicio;
    @ManyToOne
    @JoinColumn(name = "COD_JUGADOR", referencedColumnName = "COD_JUGADOR")
    private JugadoresEntity jugadoresByCodJugador;
    @ManyToOne
    @JoinColumn(name = "COD_EQUIPO", referencedColumnName = "COD_EQUIPO")
    private EquiposEntity equiposByCodEquipo;

    public byte getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(byte codContrato) {
        this.codContrato = codContrato;
    }

    public Byte getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Byte codJugador) {
        this.codJugador = codJugador;
    }

    public Byte getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Byte codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugarParaEntity that = (JugarParaEntity) o;
        return codContrato == that.codContrato && Objects.equals(codJugador, that.codJugador) && Objects.equals(codEquipo, that.codEquipo) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(fechaInicio, that.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codContrato, codJugador, codEquipo, fechaFin, fechaInicio);
    }

    public JugadoresEntity getJugadoresByCodJugador() {
        return jugadoresByCodJugador;
    }

    public void setJugadoresByCodJugador(JugadoresEntity jugadoresByCodJugador) {
        this.jugadoresByCodJugador = jugadoresByCodJugador;
    }

    public EquiposEntity getEquiposByCodEquipo() {
        return equiposByCodEquipo;
    }

    public void setEquiposByCodEquipo(EquiposEntity equiposByCodEquipo) {
        this.equiposByCodEquipo = equiposByCodEquipo;
    }
}
