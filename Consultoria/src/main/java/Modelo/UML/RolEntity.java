package Modelo.UML;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ROL", schema = "DAW26", catalog = "")
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

    public byte getCodRol() {
        return codRol;
    }

    public void setCodRol(byte codRol) {
        this.codRol = codRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolEntity rolEntity = (RolEntity) o;
        return codRol == rolEntity.codRol && Objects.equals(nomRol, rolEntity.nomRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codRol, nomRol);
    }

    public Collection<UsuariosEntity> getUsuariosByCodRol() {
        return usuariosByCodRol;
    }

    public void setUsuariosByCodRol(Collection<UsuariosEntity> usuariosByCodRol) {
        this.usuariosByCodRol = usuariosByCodRol;
    }
}
