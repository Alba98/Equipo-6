package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ALMACEN_XML", schema = "EQDAW06", catalog = "")
public class AlmacenXmlEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ALMACEN", nullable = false, precision = 0)
    private byte codAlmacen;
    @Basic
    @Column(name = "RESULT_XML", nullable = true)
    private String resultXml;

    public byte getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(byte codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public String getResultXml() {
        return resultXml;
    }

    public void setResultXml(String resultXml) {
        this.resultXml = resultXml;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlmacenXmlEntity that = (AlmacenXmlEntity) o;
        return codAlmacen == that.codAlmacen && Objects.equals(resultXml, that.resultXml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAlmacen, resultXml);
    }
}
