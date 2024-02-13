package com.hospital2.DTO;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.hospital2.DTO.Branch;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "h_id")
	@SequenceGenerator(name = "h_id", sequenceName = "hospital_id", initialValue = 1001, allocationSize = 1)
	int hospital_id;
	String chairman;
	String hospital_name;

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	String founded_on = LocalDate.of(1991, Month.JULY, 27).toString();
	
	@OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
	List<Branch> branches;

	public Hospital() {
		
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", chairman=" + chairman + ", hospital_name=" + hospital_name
				+ ", founded_on=" + founded_on + "]";
	}
}
