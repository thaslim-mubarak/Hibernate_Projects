package com.hospital2.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b_id")
	@SequenceGenerator(name = "b_id", sequenceName = "branch_id", initialValue = 101, allocationSize = 1)
	int branch_id;
	String branch_head;
	long branch_phone;
	
	@ManyToOne
	@JoinColumn
	Hospital hospital;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	Address address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
	List<Encounter> encounters;

	public String getBranch_head() {
		return branch_head;
	}

	public void setBranch_head(String branch_head) {
		this.branch_head = branch_head;
	}

	public long getBranch_phone() {
		return branch_phone;
	}

	public void setBranch_phone(long branch_phone) {
		this.branch_phone = branch_phone;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", branch_head=" + branch_head + ", branch_phone=" + branch_phone
				+ ", address=" + address + "]";
	}

}
