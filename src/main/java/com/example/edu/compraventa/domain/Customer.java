package com.example.edu.compraventa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer", schema = "surrogate", uniqueConstraints = {
        @UniqueConstraint(name = "uk_docnum_typedocu", columnNames = {"fk_type_document_id", "number_document"}),
        @UniqueConstraint(name = "uk_customer_user_id", columnNames = {"fk_user_id"})},
        indexes = {
                @Index(name = "idx_number_document", columnList = "number_document"),
                @Index(name = "idx_number_phone", columnList = "number_phone")})
public class Customer implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "first_name", length = 60)
    private String firstName;

    @Column(name = "second_name", length = 60)
    private String secondName;

    @NotNull
    @Column(name = "first_surname", length = 60)
    private String firstSurname;

    @Column(name = "second_surname", length = 60)
    private String secondSurname;

    @NotNull
    @Column(name = "number_document", length = 20)
    private String numberDocument;

    @NotNull
    @Column(name = "number_phone", length = 20)
    private String numberPhone;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fk_user_id", foreignKey = @ForeignKey(name = "fk_customer_user_id"), referencedColumnName = "id", unique = true)
    private User user;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fk_type_document_id", foreignKey = @ForeignKey(name = "fk_type_document_id"), referencedColumnName = "id", unique = true)
    private TypeDocument typeDocument;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }
}
