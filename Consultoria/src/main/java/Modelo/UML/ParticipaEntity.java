package Modelo.UML;
import javax.persistence.*;
import java.util.Objects;

    /**
     *
     * @author Equipo-6
     */

    /**
     * ENTIDAD PARTICIPA
     * SENTENCIA PARA OBTENER LOS CODIGOS DE LOS EQUIPOS Y DEL PARTIDO QUE PARTICIPAN.
     *
     **/


@Entity
@Table(name = "PARTICIPA", schema = "EQDAW06", catalog = "")
@IdClass(ParticipaEntityPK.class)
public class ParticipaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO1", nullable = false, precision = 0, insertable =false, updatable = false)
    private byte codEquipo1;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO2", nullable = false, precision = 0, insertable =false, updatable = false)
    private byte codEquipo2;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PARTIDO", nullable = false, precision = 0, insertable =false, updatable = false)
    private byte codPartido;
    @ManyToOne
    @JoinColumn(name = "COD_EQUIPO1", referencedColumnName = "COD_EQUIPO", nullable = false)
    private EquiposEntity equiposByCodEquipo1;
    @ManyToOne
    @JoinColumn(name = "COD_EQUIPO2", referencedColumnName = "COD_EQUIPO", nullable = false)
    private EquiposEntity equiposByCodEquipo2;
    @ManyToOne
    @JoinColumn(name = "COD_PARTIDO", referencedColumnName = "COD_PARTIDO", nullable = false)
    private PartidosEntity partidosByCodPartido;

        /**
         *
         * GETTER COD EQUIPO 1
         *
         * @return codEquipo1
         *
         **/

    public byte getCodEquipo1() {
        return codEquipo1;
    }

        /**
         *
         * SETTER COD EQUIPO 1
         *
         * @param  codEquipo1
         *
         **/


    public void setCodEquipo1(byte codEquipo1) {
        this.codEquipo1 = codEquipo1;
    }

        /**
         *
         * GETTER COD EQUIPO 2
         *
         * @return codEquipo1
         *
         **/


    public byte getCodEquipo2() {
        return codEquipo2;
    }

        /**
         *
         * SETTER COD EQUIPO 2
         *
         * @param  codEquipo2
         *
         **/


        public void setCodEquipo2(byte codEquipo2) {
        this.codEquipo2 = codEquipo2;
    }

        /**
         *
         * GETTER COD PARTIDO
         *
         * @return codPartido
         *
         **/

        public byte getCodPartido() {
        return codPartido;
        }


        /**
         *
         * SETTER COD PARTIDO
         *
         * @param  codPartido
         *
         **/

        public void setCodPartido(byte codPartido) {
        this.codPartido = codPartido;
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
            ParticipaEntity that = (ParticipaEntity) o;
            return codEquipo1 == that.codEquipo1 && codEquipo2 == that.codEquipo2 && codPartido == that.codPartido;
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
            return Objects.hash(codEquipo1, codEquipo2, codPartido);
        }

        /**
         *
         * GETTER COD EQUIPO1
         *
         * @return  equiposByCodEquipo1
         *
         **/

        public EquiposEntity getEquiposByCodEquipo1() {
          return equiposByCodEquipo1;
         }


        /**
         *
         * SETTER COD EQUIPO1
         *
         * @param  equiposByCodEquipo1
         *
         **/


        public void setEquiposByCodEquipo1(EquiposEntity equiposByCodEquipo1) {
            this.equiposByCodEquipo1 = equiposByCodEquipo1;
        }

        /**
         *
         * GETTER COD EQUIPO2
         *
         * @return  equiposByCodEquipo2
         *
         **/

        public EquiposEntity getEquiposByCodEquipo2() {
        return equiposByCodEquipo2;
        }


        /**
         *
         * SETTER COD EQUIPO2
         *
         * @param  equiposByCodEquipo2
         *
         **/

        public void setEquiposByCodEquipo2(EquiposEntity equiposByCodEquipo2) {
            this.equiposByCodEquipo2 = equiposByCodEquipo2;
        }

        /**
         *
         * GETTER COD EQUIPO2
         *
         * @return partidosByCodPartido
         *
         **/


        public PartidosEntity getPartidosByCodPartido() {
            return partidosByCodPartido;
        }

        /**
         *
         * SETTER COD EQUIPO2
         *
         * @param  partidosByCodPartido
         *
         **/


        public void setPartidosByCodPartido(PartidosEntity partidosByCodPartido) {
            this.partidosByCodPartido = partidosByCodPartido;
        }
    }
