package Modelo.UML.VISTAS;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "VISTA_PARTIDO", schema = "SYSTEM", catalog = "")
public class VistaPartidoEntity {
    @Basic
    @Column(name = "COD_PARTIDO")
    private byte codPartido;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "HORA_PARTIDO")
    private String horaPartido;
    @Basic
    @Column(name = "COD_JORNADA")
    private Byte codJornada;
    @Basic
    @Column(name = "RESULTADO")
    private String resultado;

    public byte getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(byte codPartido) {
        this.codPartido = codPartido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraPartido() {
        return horaPartido;
    }

    public void setHoraPartido(String horaPartido) {
        this.horaPartido = horaPartido;
    }

    public Byte getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(Byte codJornada) {
        this.codJornada = codJornada;
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
        VistaPartidoEntity that = (VistaPartidoEntity) o;
        return codPartido == that.codPartido && Objects.equals(nombre, that.nombre) && Objects.equals(horaPartido, that.horaPartido) && Objects.equals(codJornada, that.codJornada) && Objects.equals(resultado, that.resultado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPartido, nombre, horaPartido, codJornada, resultado);
    }
}
