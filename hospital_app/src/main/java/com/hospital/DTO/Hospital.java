package com.hospital.DTO;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {

	@Id
	int hospital_id = 8657;
	String chairman = "Thaslim";
	String hospital_name = "AKM Multi-Speciality Hospitals";

	String founded_on = LocalDate.of(1991, Month.JULY, 27).toString();
	
	@OneToMany
	List<Branch> branches;

	public Hospital() {
		
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	

	public String getchairman() {
		return chairman;
	}

	public void setchairman(String chairman) {
		this.chairman = chairman;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", chairman=" + chairman + ", founded_on=" + founded_on + "]";
	}
	
}
