package com.hospital.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MedOrders {
	
	@Id
	int id;
	double bill_amount;
	
	@CreationTimestamp
	LocalDateTime billed_on;
	
	@ManyToOne
	Encounter encounter;
	
	@ManyToMany
	List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(double bill_amount) {
		this.bill_amount = bill_amount;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}
