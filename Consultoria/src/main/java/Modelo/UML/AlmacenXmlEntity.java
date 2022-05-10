package Modelo.UML;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ALMACEN_XML", schema = "SYSTEM", catalog = "")
public class AlmacenXmlEntity {
    @Basic
    @Column(name = "RESULT_XML")
    private String resultXml;

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
        return Objects.equals(resultXml, that.resultXml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultXml);
    }
}
