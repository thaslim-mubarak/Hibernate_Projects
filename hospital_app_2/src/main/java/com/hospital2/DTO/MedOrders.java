package com.hospital2.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MedOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "o_id")
	@SequenceGenerator(name = "o_id", sequenceName = "order_id", initialValue = 401, allocationSize = 1)
	int order_id;
	String billed_by;
	double order_total;
	@CreationTimestamp
	LocalDateTime billed_on;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "encounter_id")
	Encounter encounter;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	List<Item> items;

	public String getBilled_by() {
		return billed_by;
	}

	public void setBilled_by(String billed_by) {
		this.billed_by = billed_by;
	}

	public double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(double order_total) {
		this.order_total = order_total;
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

	public int getOrder_id() {
		return order_id;
	}

	@Override
	public String toString() {
		return "MedOrders [order_id=" + order_id + ", billed_by=" + billed_by + ", order_total=" + order_total
				+ ", encounter=" + encounter.getEncounter_id() + "]";
	}
}
