package com.example.edu.compraventa.domain;

import com.example.edu.compraventa.domain.enums.StateUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "type_machine", schema = "surrogate", uniqueConstraints = {
        @UniqueConstraint(name = "uk_typname_reference_machine", columnNames = {"machine_type_reference", "name_machine"})},
        indexes = {@Index(name = "idx_machine_type_refernce", columnList = "machine_type_reference", unique = true)})
public class TypeMachine implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "name_machine", length = 60)
    private String nameMachine;

    @NotNull
    @Column(name = "machine_type_reference")
    private String machineTypeReference;

    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "machine_state")
    @Enumerated(EnumType.STRING)
    private StateUser machineState;

    @OneToOne(mappedBy = "typeMachine", optional = false, cascade = CascadeType.ALL)
    private Machine machine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMachine() {
        return nameMachine;
    }

    public void setNameMachine(String nameMachine) {
        this.nameMachine = nameMachine;
    }

    public String getMachineTypeReference() {
        return machineTypeReference;
    }

    public void setMachineTypeReference(String machineTypeReference) {
        this.machineTypeReference = machineTypeReference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateUser getMachineState() {
        return machineState;
    }

    public void setMachineState(StateUser machineState) {
        this.machineState = machineState;
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
        TypeMachine that = (TypeMachine) o;
        return id.equals(that.id) && nameMachine.equals(that.nameMachine) && machineTypeReference.equals(that.machineTypeReference) && Objects.equals(description, that.description) && machineState == that.machineState && machine.equals(that.machine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameMachine, machineTypeReference, description, machineState, machine);
    }
}
