package Modelo.UML;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
    /**
     *
     * @author Equipo-6
     */

    /**
     * ENTIDAD PARTICIPA (CLAVE PRIMARIA)
     * SENTENCIA PARA OBTENER LOS CODIGOS DE LOS EQUIPOS Y PARTIDO QUE PARTICIPAN EN UN PARTIDO
     *
     **/

public class ParticipaEntityPK implements Serializable {
    @Column(name = "COD_EQUIPO1", nullable = false, precision = 0, insertable =false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codEquipo1;
    @Column(name = "COD_EQUIPO2", nullable = false, precision = 0, insertable =false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codEquipo2;
    @Column(name = "COD_PARTIDO", nullable = false, precision = 0, insertable =false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codPartido;

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
     * @return codEquipo2
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
     * GETTER COD PARTIDO EN EL QUE PARTICIPAN EQUIPO1 Y EQUIPO 2
     *
     * @return codPartido
     *
     **/

    public byte getCodPartido() {
        return codPartido;
    }

    /**
     *
     * SETTER COD PARTIDO EN EL QUE PARTICIPAN EQUIPO1 Y EQUIPO 2
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
        ParticipaEntityPK that = (ParticipaEntityPK) o;
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
}
