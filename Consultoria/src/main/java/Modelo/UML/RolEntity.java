package Modelo.UML;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROL", schema = "SYSTEM", catalog = "")
public class RolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ROL")
    private byte codRol;
    @Basic
    @Column(name = "NOM_ROL")
    private String nomRol;

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
}
