package Modelo.UML;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

    /**
     *
     * @author Equipo-6
     */

    /**
     * ENTIDAD PARTIDOS
     * SENTENCIA SQL PARA OBTENER LA CANTIDAD DE PARTIDOS
     *
    **/

@NamedQuery(name = "PartidosEntity.todos", query = "SELECT p FROM PartidosEntity p")
@Entity
@Table(name = "PARTIDOS", schema = "EQDAW06", catalog = "")
public class PartidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PARTIDO", nullable = false, precision = 0)
    private byte codPartido;
    @Basic
    @Column(name = "HORA_PARTIDO", nullable = true, length = 30)
    private String horaPartido;
    @Basic
    @Column(name = "RESULTADO", nullable = true, length = 3)
    private String resultado;
    @Basic
    @Column(name = "COD_JORNADA", nullable = true, precision = 0, insertable =false, updatable = false)
    private Byte codJornada;
    @OneToMany(mappedBy = "partidosByCodPartido")
    private Collection<ParticipaEntity> participasByCodPartido;
    @ManyToOne
    @JoinColumn(name = "COD_JORNADA", referencedColumnName = "COD_JORNADA")
    private JornadasEntity jornadasByCodJornada;

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
         * @param codPartido
         *
         **/

        public void setCodPartido(byte codPartido) {
        this.codPartido = codPartido;
        }

        /**
         *
         * GETTER HORA PARTIDO
         *
         * @return  horaPartido
         *
         **/

        public String getHoraPartido() {
            return horaPartido;
        }

        /**
         *
         * SETTER HORA PARTIDO
         *
         * @param  horaPartido
         *
         **/

        public void setHoraPartido(String horaPartido) {
            this.horaPartido = horaPartido;
        }

        /**
         *
         * GETTER RESULTADO DEL PARTIDO
         *
         * @return  resultado
         *
         **/


        public String getResultado() {
            return resultado;
        }


        /**
         *
         * SETTER RESULTADO DEL PARTIDO
         *
         * @param  resultado
         *
         **/

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        /**
         *
         * GETTER COD DE LA JORNADA
         *
         * @return  codJornada
         *
         **/


        public Byte getCodJornada() {
            return codJornada;
        }

        /**
         *
         * SETTER  COD DE LA JORNADA
         *
         * @param  codJornada
         *
         **/

        public void setCodJornada(Byte codJornada) {
            this.codJornada = codJornada;
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
            PartidosEntity that = (PartidosEntity) o;
            return codPartido == that.codPartido && Objects.equals(horaPartido, that.horaPartido) && Objects.equals(resultado, that.resultado) && Objects.equals(codJornada, that.codJornada);
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
            return Objects.hash(codPartido, horaPartido, resultado, codJornada);
        }

        /**
         *
         * GETTER PARTICIPA POR EL CODIGO DEl PARTIDO
         *
         * @return  participasByCodPartido
         *
         **/

        public Collection<ParticipaEntity> getParticipasByCodPartido() {
            return participasByCodPartido;
        }

        /**
         *
         * SETTER PARTICIPA POR EL CODIGO DEl PARTIDO
         *
         * @param  participasByCodPartido
         *
         **/

        public void setParticipasByCodPartido(Collection<ParticipaEntity> participasByCodPartido) {
            this.participasByCodPartido = participasByCodPartido;
        }


        /**
         *
         * GETTER JORNADAS POR EL CODIGO DE LA JORNADA
         *
         * @return   jornadasByCodJornada
         *
         **/



        public JornadasEntity getJornadasByCodJornada() {
            return jornadasByCodJornada;
        }

        /**
         *
         * SETTER JORNADAS POR EL CODIGO DE LA JORNADA
         *
         * @param    jornadasByCodJornada
         *
         **/

            public void setJornadasByCodJornada(JornadasEntity jornadasByCodJornada) {
                this.jornadasByCodJornada = jornadasByCodJornada;
            }
        }
