package com.hospital.DTO;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Encounter {
	
	@Id
	int encounter_id;
	String bp;
	double weight;
	
	@CreationTimestamp
	LocalDateTime date_time;
	
	@ManyToOne
	Branch branch;

	public int getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(int encounter_id) {
		this.encounter_id = encounter_id;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Encounter [encounter_id=" + encounter_id + ", bp=" + bp + ", weight=" + weight + ", date_time="
				+ date_time + ", branch=" + branch + "]";
	}
	

}
