package com.example.edu.compraventa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_user", schema = "surrogate")
public class TypeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name_rol")
    private String nameRol;

    @ManyToMany(mappedBy = "typeUsers", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<User>();

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeUser typeUser = (TypeUser) o;
        return Objects.equals(nameRol, typeUser.nameRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRol);
    }

    @Override
    public String toString() {
        return "TypeUser{" +
                "nameRol='" + nameRol;
    }
}
