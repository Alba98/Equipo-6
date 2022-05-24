package Modelo.UML;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Equipo-6
 */

/**
 * ENTIDAD ROL
 * SENTENCIA PARA OBTENER EL CODIGO Y EL NOMBRE DEL ROL DE LOS USUARIOS
 *
 **/

@Entity
@Table(name = "ROL", schema = "EQDAW06", catalog = "")
public class RolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ROL", nullable = false, precision = 0)
    private byte codRol;
    @Basic
    @Column(name = "NOM_ROL", nullable = true, length = 15)
    private String nomRol;
    @OneToMany(mappedBy = "rolByCodRol")
    private Collection<UsuariosEntity> usuariosByCodRol;

    /**
     *
     * GETTER COD ROL
     *
     * @return codRol
     *
     **/


    public byte getCodRol() {
        return codRol;
    }

    /**
     *
     * SETTER COD ROL
     *
     * @param codRol
     *
     **/


    public void setCodRol(byte codRol) {
        this.codRol = codRol;
    }

    /**
     *
     * GETTER NOMBRE ROL
     *
     * @return nomRol
     *
     **/


    public String getNomRol() {
        return nomRol;
    }

    /**
     *
     * SETTER NOMBRE ROL
     *
     * @param  nomRol
     *
     **/

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
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
            RolEntity rolEntity = (RolEntity) o;
            return codRol == rolEntity.codRol && Objects.equals(nomRol, rolEntity.nomRol);
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
            return Objects.hash(codRol, nomRol);
        }


        /**
         *
         * GETTER USUARIOS POR COD DE ROL
         *
         * @return usuariosByCodRol
         *
         **/
        public Collection<UsuariosEntity> getUsuariosByCodRol() {
            return usuariosByCodRol;
        }

        /**
         *
         * SETTER USUARIOS POR COD DE ROL
         *
         * @param  usuariosByCodRol
         *
         **/


            public void setUsuariosByCodRol(Collection<UsuariosEntity> usuariosByCodRol) {
                this.usuariosByCodRol = usuariosByCodRol;
            }
        }
