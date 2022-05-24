package Modelo.UML;
import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * ENTIDAD USUARIOS
 * @author Equipo-6
 */

@Entity
@Table(name = "PERSONAS", schema = "EQDAW06", catalog = "")
public class PersonasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PERSONA", nullable = false, precision = 0)
    private byte codPersona;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 15)
    private String nombre;
    @Basic
    @Column(name = "APELLIDO", nullable = true, length = 15)
    private String apellido;
    @Basic
    @Column(name = "SUELDO", nullable = true, precision = 2)
    private Integer sueldo;
    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "NACIONALIDAD", nullable = true, length = 20)
    private String nacionalidad;
    @Basic
    @Column(name = "NICKNAME", nullable = true, length = 15)
    private String nickname;
    @OneToOne(mappedBy = "personasByCodAsistente")
    private AsistentesEntity asistentesByCodPersona;
    @OneToOne(mappedBy = "personasByCodEntrenador")
    private EntrenadoresEntity entrenadoresByCodPersona;
    @OneToOne(mappedBy = "personasByCodJugador")
    private JugadoresEntity jugadoresByCodPersona;


    /**
     *
     * GETTER  COD PERSONA
     *
     * @return codPersona
     *
     **/


    public byte getCodPersona() {
        return codPersona;
    }
    /**
     *
     * SETTER COD PERSONA
     *
     * @param codPersona
     *
     **/
    public void setCodPersona(byte codPersona) {
        this.codPersona = codPersona;
    }
    /**
     *
     * GETTER NOMBRE
     *
     * @return nombre
     *
     **/

    public String getNombre() {
        return nombre;
    }

    /**
     *
     * SETTER NOMBRE
     *
     * @param nombre
     *
     **/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * GETTER APELLIDO
     *
     * @return apellido
     *
     **/

    public String getApellido() {
        return apellido;
    }

    /**
     *
     * SETTER APELLIDO
     *
     * @return apellido
     *
     **/

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    /**
     *
     * GETTER SUELDO
     *
     * @return sueldo
     *
     **/

    public Integer getSueldo() {
        return sueldo;
    }

    /**
     *
     * SETTER SUELDO
     *
     * @param sueldo
     *
     **/

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    /**
     *
     * GETTER FECHA DE NACIMIENTO
     *
     * @return fechaNacimiento
     *
     **/

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * SETTER FECHA DE NACIMIENTO
     *
     * @param fechaNacimiento
     *
     **/


    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * GETTER NACIONALIDAD
     *
     * @return  nacionalidad
     *
     **/

    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     *
     * SETTER NACIONALIDAD
     *
     * @param nacionalidad
     *
     **/


    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     *
     * GETTER NICKNAME
     *
     * @return  nickname
     *
     **/



    public String getNickname() {
        return nickname;
    }

    /**
     *
     * SETTER NICKNAME
     *
     * @param  nickname
     *
     **/


    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        PersonasEntity that = (PersonasEntity) o;
        return codPersona == that.codPersona && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(sueldo, that.sueldo) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nacionalidad, that.nacionalidad) && Objects.equals(nickname, that.nickname);
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
        return Objects.hash(codPersona, nombre, apellido, sueldo, fechaNacimiento, nacionalidad, nickname);
    }

    /**
     *
     * GETTER ASISTENTE POR EL CODIGO DE LA PERSONA
     *
     * @return  asistentesByCodPersona
     *
     **/

    public AsistentesEntity getAsistentesByCodPersona() {
        return asistentesByCodPersona;
    }

    /**
     *
     * SETTER ASISTENTE POR EL CODIGO DE LA PERSONA
     *
     * @param  asistentesByCodPersona
     *
     **/

    public void setAsistentesByCodPersona(AsistentesEntity asistentesByCodPersona) {
        this.asistentesByCodPersona = asistentesByCodPersona;
    }

    /**
     *
     * GETTER ENTRENADOR POR EL CODIGO DE LA PERSONA
     *
     * @return  entrenadoresByCodPersona
     *
     **/


    public EntrenadoresEntity getEntrenadoresByCodPersona() {
        return entrenadoresByCodPersona;
    }


    /**
     *
     * SETTER  ENTRENADOR POR EL CODIGO DE LA PERSONA
     *
     * @param  entrenadoresByCodPersona
     *
     **/


    public void setEntrenadoresByCodPersona(EntrenadoresEntity entrenadoresByCodPersona) {
        this.entrenadoresByCodPersona = entrenadoresByCodPersona;
    }

    /**
     *
     * GETTER  JUGADOR POR EL CODIGO DE LA PERSONA
     *
     * @return   jugadoresByCodPersona
     *
     **/

    public JugadoresEntity getJugadoresByCodPersona() {
        return jugadoresByCodPersona;
    }


    /**
     *
     * SETTER  JUGADOR POR EL CODIGO DE LA PERSONA
     *
     * @param   jugadoresByCodPersona
     *
     **/

    public void setJugadoresByCodPersona(JugadoresEntity jugadoresByCodPersona) {
        this.jugadoresByCodPersona = jugadoresByCodPersona;
    }
}
