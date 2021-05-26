package com.example.edu.compraventa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.example.edu.compraventa.domain.enums.StateUser;

@Entity
@Table(name = "type_document", schema = "surrogate", uniqueConstraints = {@UniqueConstraint(name = "uk_type_document_name", columnNames = "document_name"),
        @UniqueConstraint(name = "uk_type_document_initial", columnNames = "initial")})
public class TypeDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "initial", length = 10)
    private String initial;

    @NotNull
    @Column(name = "document_name", length = 30)
    private String documentName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type_document_state")
    private StateUser typeDocumentState;

    @OneToMany(mappedBy = "typeDocument", fetch = FetchType.LAZY)
    private Set<Customer> customer = new HashSet();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public StateUser getTypeDocumentState() {
        return typeDocumentState;
    }

    public void setTypeDocumentState(StateUser typeDocumentState) {
        this.typeDocumentState = typeDocumentState;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDocument that = (TypeDocument) o;
        return id.equals(that.id) && initial.equals(that.initial) && documentName.equals(that.documentName) && typeDocumentState == that.typeDocumentState && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initial, documentName, typeDocumentState, customer);
    }

    @Override
    public String toString() {
        return "TypeDocument{" +
                "id=" + id +
                ", initial='" + initial + '\'' +
                ", documentName='" + documentName + '\'' +
                ", typeDocumentState=" + typeDocumentState +
                ", customer=" + customer +
                '}';
    }
}
