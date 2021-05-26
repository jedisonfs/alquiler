
package com.example.edu.compraventa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.edu.compraventa.domain.enums.StateUser;

/**
 * @author Edison
 */
@Entity
@Table(name = "user", schema = "surrogate", uniqueConstraints = @UniqueConstraint(name = "uk_username_email", columnNames = {
        "login", "email"}), indexes = {
        @Index(name = "idx_login", columnList = "login", unique = true),
        @Index(name = "idx_email", columnList = "email")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(name = "login", length = 60, nullable = false)
    private String login;

    @NotNull
    @Column(name = "password", length = 50)
    private String password;

    @NotNull
    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "profile_picture")
    private String profilePicture;

    @NotNull
    @Column(name = "state_user")
    @Enumerated(EnumType.STRING)
    private StateUser stateUser;

    @NotNull
    @Column(name = "create_date")
    private Date createDate;

    @ManyToMany
    @JoinTable(name = "type_user_system_user", schema = "surrogate", joinColumns = {
            @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id"), referencedColumnName = "id", nullable = false, unique = true)}, inverseJoinColumns = @JoinColumn(name = "type_username_rol", foreignKey = @ForeignKey(name = "fk_name_rol"), referencedColumnName = "name_rol", nullable = false, unique = true))
    private Set<TypeUser> typeUsers = new HashSet<TypeUser>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return login;
    }

    public void setUserName(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public StateUser getStateUser() {
        return stateUser;
    }

    public void setStateUser(StateUser stateUser) {
        this.stateUser = stateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && login.equals(user.login) && password.equals(user.password) && email.equals(user.email) && profilePicture.equals(user.profilePicture) && stateUser == user.stateUser && createDate.equals(user.createDate) && typeUsers.equals(user.typeUsers) && customer.equals(user.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, profilePicture, stateUser, createDate, typeUsers, customer);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", stateUser=" + stateUser +
                ", createDate=" + createDate +
                ", typeUsers=" + typeUsers +
                ", customer=" + customer +
                '}';
    }
}
