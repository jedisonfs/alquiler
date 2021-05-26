package com.example.edu.compraventa.domain;

import com.example.edu.compraventa.domain.enums.StateUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rental_time", schema = "surrogate")
public class RentalTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date stratDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")
    private Date deliveryDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rental_state")
    private StateUser rentalState;

    @NotNull
    @OneToOne(mappedBy = "rentalTime", optional = false, fetch = FetchType.EAGER)
    private Machine machine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStratDate() {
        return stratDate;
    }

    public void setStratDate(Date stratDate) {
        this.stratDate = stratDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public StateUser getRentalState() {
        return rentalState;
    }

    public void setRentalState(StateUser rentalState) {
        this.rentalState = rentalState;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalTime that = (RentalTime) o;
        return id.equals(that.id) && stratDate.equals(that.stratDate) && deliveryDate.equals(that.deliveryDate) && rentalState == that.rentalState && machine.equals(that.machine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stratDate, deliveryDate, rentalState, machine);
    }
}
