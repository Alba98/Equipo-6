package Modelo.UML.VISTAS;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VISTA_JORNADA", schema = "SYSTEM", catalog = "")
public class VistaJornadaEntity {
    @Basic
    @Column(name = "COD_JORNADA")
    private byte codJornada;
    @Basic
    @Column(name = "FECHA_JORNADA")
    private Date fechaJornada;
    @Basic
    @Column(name = "COD_PARTIDO")
    private byte codPartido;
    @Basic
    @Column(name = "RESULTADO")
    private String resultado;

    public byte getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(byte codJornada) {
        this.codJornada = codJornada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    public byte getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(byte codPartido) {
        this.codPartido = codPartido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VistaJornadaEntity that = (VistaJornadaEntity) o;
        return codJornada == that.codJornada && codPartido == that.codPartido && Objects.equals(fechaJornada, that.fechaJornada) && Objects.equals(resultado, that.resultado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codJornada, fechaJornada, codPartido, resultado);
    }
}
