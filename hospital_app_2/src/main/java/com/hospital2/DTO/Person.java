package com.hospital2.DTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	int aadhar;
	String name;
	double height;
	
	@OneToMany(mappedBy = "person")
	List<Encounter> encounter;

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public List<Encounter> getEncounter() {
		return encounter;
	}

	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}

	@Override
	public String toString() {
		
		ArrayList<Integer> encs = new ArrayList<Integer>();
		
		for(Encounter e : encounter) {
			encs.add(e.getEncounter_id());
		}
		
		return "Person [aadhar=" + aadhar + ", name=" + name + ", height=" + height + ", encounter_id=" + encs + "]";
	}
	
	

}
