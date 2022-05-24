package Modelo.UML;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

/**
 * ENTIDAD EQUIPOS
 * @author Equipo-6
 */
@Entity
@Table(name = "EQUIPOS", schema = "EQDAW06", catalog = "")
/**
 *
 * SENTENCIA SQL OBTENCIÖN DE TODOS LOS EQUIPOS
 *
 */
@NamedQuery(name = "EquiposEntity.toda", query = "SELECT e FROM EquiposEntity e")
/**
 * SENTENCIA SQL OBTENCION EQUIPO POR SU NOMBRE
 * OBJETIVO FINAL --> ELIMINAR EL EQUIPO ENCONTRADO
 */
@NamedQuery(name = "EquiposEntity.borrar", query = "SELECT j FROM EquiposEntity j WHERE j.nombre = ?1")

public class EquiposEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO", nullable = false, precision = 0)
    private byte codEquipo;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 30)
    private String nombre;
    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "CIUDAD", nullable = true, length = 30)
    private String ciudad;
    @Basic
    @Column(name = "ESPONSOR", nullable = false, length = 25)
    private String esponsor;
    @Basic
    @Column(name = "NOMBRE_DUENIO", nullable = true, length = 30)
    private String nombreDuenio;
    @OneToMany(mappedBy = "equiposByCodEquipo")
    private Collection<AsisteEntity> asistesByCodEquipo;
    @OneToMany(mappedBy = "equiposByCodEquipo")
    private Collection<EntrenaEntity> entrenasByCodEquipo;
    @OneToMany(mappedBy = "equiposByCodEquipo")
    private Collection<JugarParaEntity> jugarParasByCodEquipo;
    @OneToMany(mappedBy = "equiposByCodEquipo1")
    private Collection<ParticipaEntity> participasByCodEquipo;
    @OneToMany(mappedBy = "equiposByCodEquipo2")
    private Collection<ParticipaEntity> participasByCodEquipo_0;

    /**
     *
     * GETTER COD EQUIPO
     *
     * @return codEquipo
     *
     */
    public byte getCodEquipo() {
        return codEquipo;
    }

    /**
     *
     * SETTER COD EQUIPO
     *
     * @param codEquipo
     *
     */
    public void setCodEquipo(byte codEquipo) {
        this.codEquipo = codEquipo;
    }

    /**
     *
     * GETTER NOMBRE
     *
     * @return nombre
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * SETTER NOMBRE
     *
     * @param nombre
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * GETTER FECHA NACIMIENTO
     *
     * @return fechaNacimiento
     *
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * SETTER FECHA NACIMIENTO
     *
     * @param fechaNacimiento
     *
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * GETTER CIUDAD
     *
     * @return ciudad
     *
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *
     * SETTER CIUDAD
     *
     * @param ciudad
     *
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     *
     * GETTER ESPONSOR
     *
     * @return esponsor
     *
     */
    public String getEsponsor() {
        return esponsor;
    }

    /**
     *
     * SETTER ESPONSOR
     *
     * @param esponsor
     *
     */
    public void setEsponsor(String esponsor) {
        this.esponsor = esponsor;
    }

    /**
     *
     * GETTER NOMBRE DUENIO
     *
     * @return nombreDuenio
     */
    public String getNombreDuenio() {
        return nombreDuenio;
    }

    /**
     *
     * SETTER NOMBRE DUENIO
     *
     * @param nombreDuenio
     *
     */
    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    /**
     *
     * COMPRAR DOS OBJETOS TIPO
     *
     * @param o
     *
     * @return codEquipo
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquiposEntity that = (EquiposEntity) o;
        return codEquipo == that.codEquipo && Objects.equals(nombre, that.nombre) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(ciudad, that.ciudad) && Objects.equals(esponsor, that.esponsor) && Objects.equals(nombreDuenio, that.nombreDuenio);
    }

    /**
     *
     * DEVUELVE EL HASHCODE
     *
     * @return hashCode
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(codEquipo, nombre, fechaNacimiento, ciudad, esponsor, nombreDuenio);
    }

    /**
     *
     * GETTER ASISTES POR COD EQUIPO
     *
     * @return asistesByCodEquipo
     *
     */
    public Collection<AsisteEntity> getAsistesByCodEquipo() {
        return asistesByCodEquipo;
    }

    /**
     *
     * SETTER ASISTES POR COD EQUIPO
     *
     * @param asistesByCodEquipo
     *
     */
    public void setAsistesByCodEquipo(Collection<AsisteEntity> asistesByCodEquipo) {
        this.asistesByCodEquipo = asistesByCodEquipo;
    }

    /**
     *
     * GETTER ENTRENAS POR COD EQUIPO
     *
     * @return entrenasByCodEquipo
     *
     */
    public Collection<EntrenaEntity> getEntrenasByCodEquipo() {
        return entrenasByCodEquipo;
    }

    /**
     *
     * SETTER ENTRENAS POR COD EQUIPO
     *
     * @param entrenasByCodEquipo
     *
     */
    public void setEntrenasByCodEquipo(Collection<EntrenaEntity> entrenasByCodEquipo) {
        this.entrenasByCodEquipo = entrenasByCodEquipo;
    }

    /**
     *
     * GETTER JUGAR PARA POR COD EQUIPO
     *
     * @return jugarParasByCodEquipo
     *
     */
    public Collection<JugarParaEntity> getJugarParasByCodEquipo() {
        return jugarParasByCodEquipo;
    }

    /**
     *
     * SETTER JUGAR PARA POR COD EQUIPO
     *
     * @param jugarParasByCodEquipo
     *
     */
    public void setJugarParasByCodEquipo(Collection<JugarParaEntity> jugarParasByCodEquipo) {
        this.jugarParasByCodEquipo = jugarParasByCodEquipo;
    }

    /**
     *
     * GETTER PARTICIPA POR COD EQUIPO
     *
     * @return participasByCodEquipo
     *
     */
    public Collection<ParticipaEntity> getParticipasByCodEquipo() {
        return participasByCodEquipo;
    }

    /**
     *
     * SETTER PARTICIPA POR COD EQUIPO
     *
     * @param participasByCodEquipo
     *
     */
    public void setParticipasByCodEquipo(Collection<ParticipaEntity> participasByCodEquipo) {
        this.participasByCodEquipo = participasByCodEquipo;
    }

    /**
     *
     * GETTER PARTICIPA POR COD EQUIPO_0
     *
     * @return participasByCodEquipo_0
     */
    public Collection<ParticipaEntity> getParticipasByCodEquipo_0() {
        return participasByCodEquipo_0;
    }

    /**
     *
     * SETTER PARTICIPA POR COD EQUIPO_0
     *
     * @param participasByCodEquipo_0
     *
     */
    public void setParticipasByCodEquipo_0(Collection<ParticipaEntity> participasByCodEquipo_0) {
        this.participasByCodEquipo_0 = participasByCodEquipo_0;
    }
}
