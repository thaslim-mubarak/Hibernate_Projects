package com.hospital2.DTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Encounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "e_id")
	@SequenceGenerator(name = "e_id", sequenceName = "encounter_id", initialValue = 301, allocationSize = 1)
	int encounter_id;
	int age;
	String blood_pressure;
	String blood_sugar;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	Branch branch;
	
	@OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
	List<MedOrders> orders;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	Person person;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBlood_pressure() {
		return blood_pressure;
	}

	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}

	public String getBlood_sugar() {
		return blood_sugar;
	}

	public void setBlood_sugar(String blood_sugar) {
		this.blood_sugar = blood_sugar;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<MedOrders> getOrders() {
		return orders;
	}

	public void setOrders(List<MedOrders> orders) {
		this.orders = orders;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(int encounter_id) {
		this.encounter_id = encounter_id;
	}
	
	@Override
	public String toString() {
		
		ArrayList<Integer> al_orders = new ArrayList<Integer>();
		for(MedOrders o : this.orders) {
			al_orders.add(o.getOrder_id());
		}
		
		return "Encounter [encounter_id=" + encounter_id + ", age=" + age + ", blood_pressure=" + blood_pressure
				+ ", blood_sugar=" + blood_sugar + ", branch=" + branch.branch_id + ", orders=" + al_orders + ", person_aadhar=" + person.getAadhar()
				+ "]";
	}
	
	
}
