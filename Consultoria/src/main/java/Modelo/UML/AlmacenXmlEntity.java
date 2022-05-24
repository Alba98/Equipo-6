package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

/**
 * ENTIDAD ALMACEN XML
 *  EQUIPO-6
 */
@Entity
@Table(name = "ALMACEN_XML", schema = "EQDAW06", catalog = "")
/**
 * SENTENCIA SQL PARA OBTENER LOS ALMACENES
 */
@NamedQuery(name = "AlmacenXmlEntity.todas", query = "SELECT e FROM AlmacenXmlEntity e")

public class AlmacenXmlEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ALMACEN", nullable = false, precision = 0)
    private byte codAlmacen;
    @Basic
    @Column(name = "RESULT_XML", nullable = true)
    private String resultXml;

    /**
     *
     * GETTER COD ALMACEN
     *
     * @return codAlmacen
     *
     */
    public byte getCodAlmacen() {
        return codAlmacen;
    }

    /**
     *
     * SETTER COD ALMACEN
     *
     * @param codAlmacen
     *
     */
    public void setCodAlmacen(byte codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    /**
     *
     * GETTER RESULT XML
     *
     * @return resultXml
     *
     */
    public String getResultXml() {
        return resultXml;
    }

    /**
     *
     * SETTER RESULT XML
     *
     * @param resultXml
     *
     */
    public void setResultXml(String resultXml) {
        this.resultXml = resultXml;
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
        AlmacenXmlEntity that = (AlmacenXmlEntity) o;
        return codAlmacen == that.codAlmacen && Objects.equals(resultXml, that.resultXml);
    }

    /**
     *
     * DEVUELVE LE HASHCODE DEL OBJETO
     *
     * @return hashCode
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(codAlmacen, resultXml);
    }
}
