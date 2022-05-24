package Modelo.UML;
import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

    /**
     *
     * @author Equipo-6
     */

    /**
     * ENTIDAD JUGAR PARA
     * SENTENCIA PARA OBTENER LOS DATOS DE TODOS LO ELEMENTOS QUE PARTICIPAN EN UN PARTIDO
     *
     **/

@Entity
@Table(name = "JUGAR_PARA", schema = "EQDAW06", catalog = "")
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

        /**
         *
         * GETTER COD CODIGO CONTRATO
         *
         * @return codContrato
         *
         **/

        public byte getCodContrato() {
        return codContrato;
    }

        /**
         *
         * SETTER COD CODIGO CONTRATO
         *
         * @param  codContrato
         *
         **/

        public void setCodContrato(byte codContrato) {
        this.codContrato = codContrato;
    }

        /**
         *
         * GETTER COD JUGADOR
         *
         * @return codJugador
         *
         **/


        public Byte getCodJugador() {
            return codJugador;
        }

        /**
         *
         * SETTER COD JUGADOR
         *
         * @param  codJugador
         *
         **/

        public void setCodJugador(Byte codJugador) {
            this.codJugador = codJugador;
        }

        /**
         *
         * GETTER COD EQUIPO
         *
         * @return codEquipo
         *
         **/

        public Byte getCodEquipo() {
            return codEquipo;
        }

        /**
         *
         * SETTER COD EQUIPO
         *
         * @param  codEquipo
         *
         **/

        public void setCodEquipo(Byte codEquipo) {
            this.codEquipo = codEquipo;
        }

        /**
         *
         * GETTER DE LA FECHA FINAL
         *
         * @return fechaFin
         *
         **/


        public Date getFechaFin() {
            return fechaFin;
        }


        /**
         *
         * SETTER DE LA FECHA FINAL
         *
         * @param  fechaFin
         *
         **/

        public void setFechaFin(Date fechaFin) {
            this.fechaFin = fechaFin;
        }

        /**
         *
         * GETTER DE LA FECHA DE INICIO
         *
         * @return fechaInicio
         *
         **/

        public Date getFechaInicio() {
            return fechaInicio;
        }

        /**
         *
         * SETTER DE LA FECHA DE INICIO
         *
         * @param fechaInicio
         *
         **/

        public void setFechaInicio(Date fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        /**
         *
         *COMPARA QUE SEAN OBJETOS DEL MISMO TIPO
         *
         * @param o
         *
         **/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JugarParaEntity that = (JugarParaEntity) o;
            return codContrato == that.codContrato && Objects.equals(codJugador, that.codJugador) && Objects.equals(codEquipo, that.codEquipo) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(fechaInicio, that.fechaInicio);
        }


        /**
         *
         * DEVUElVE EL HASCODE DEL OBJETO
         *
         * @return hashcode
         *
         **/
        @Override
        public int hashCode() {
            return Objects.hash(codContrato, codJugador, codEquipo, fechaFin, fechaInicio);
        }

        /**
         *
         * GETTER JUGADORES POR CODIGO DE JUGADOR
         *
         * @return jugadoresByCodJugador
         *
         **/

        public JugadoresEntity getJugadoresByCodJugador() {
        return jugadoresByCodJugador;
        }

        /**
         *
         * SETTER JUGADORES POR CODIGO DE JUGADOR
         *
         * @param  jugadoresByCodJugador
         *
         **/


        public void setJugadoresByCodJugador(JugadoresEntity jugadoresByCodJugador) {
            this.jugadoresByCodJugador = jugadoresByCodJugador;
        }

        /**
         *
         * GETTER EQUIPO POR CODIGO DEL EQUIPO
         *
         * @return equiposByCodEquipo
         *
         **/


        public EquiposEntity getEquiposByCodEquipo() {
            return equiposByCodEquipo;
        }

        /**
         *
         * SETTER EQUIPO POR CODIGO DEL EQUIPO
         *
         * @param equiposByCodEquipo
         *
         **/


        public void setEquiposByCodEquipo(EquiposEntity equiposByCodEquipo) {
            this.equiposByCodEquipo = equiposByCodEquipo;
        }
    }
