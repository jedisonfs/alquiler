package com.example.edu.compraventa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "machine", schema = "sugorrate", uniqueConstraints = {
		@UniqueConstraint(name = "uk_type_machi_name_machine", columnNames = { "fk_type_machine_id","name_machine" }) }, indexes = { 
						@Index(name = "idx_name_machine", columnList = "name_machine"),
						@Index(name = "idx_reference_machine", columnList = "reference_machine") })
public class Machine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "name_machine", length = 60)
	private String nameMachine;

	@NotNull
	@Column(name = "reference_machine", length = 30)
	private String referenceMachine;

	@NotNull
	@Column(name = "machine_price")
	private Double machinePrice;

	@Column(name = "description", length = 255)
	private String description;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_type_machine_id", foreignKey = @ForeignKey(name = "fk_type_machine_id"), referencedColumnName = "id", unique = true)
	private TypeMachine typeMachine;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fk_rental_time_id", foreignKey = @ForeignKey(name = "fk_rental_time_id"), referencedColumnName = "id", unique = true)
	private RentalTime rentalTime;

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

	public String getReferenceMachine() {
		return referenceMachine;
	}

	public void setReferenceMachine(String referenceMachine) {
		this.referenceMachine = referenceMachine;
	}

	public Double getMachinePrice() {
		return machinePrice;
	}

	public void setMachinePrice(Double machinePrice) {
		this.machinePrice = machinePrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeMachine getTypeMachine() {
		return typeMachine;
	}

	public void setTypeMachine(TypeMachine typeMachine) {
		this.typeMachine = typeMachine;
	}

	public RentalTime getRentalTime() {
		return rentalTime;
	}

	public void setRentalTime(RentalTime rentalTime) {
		this.rentalTime = rentalTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Machine machine = (Machine) o;
		return id.equals(machine.id) && nameMachine.equals(machine.nameMachine) && referenceMachine.equals(machine.referenceMachine) && machinePrice.equals(machine.machinePrice) && Objects.equals(description, machine.description) && typeMachine.equals(machine.typeMachine) && rentalTime.equals(machine.rentalTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameMachine, referenceMachine, machinePrice, description, typeMachine, rentalTime);
	}
}
