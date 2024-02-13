package com.hospital2.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_id")
	@SequenceGenerator(name = "add_id", sequenceName = "address_id", initialValue = 201, allocationSize = 1)
	int id;
	String city;
	String district;
	long pincode;
	
	@OneToOne(mappedBy = "address")
	Branch branch;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", district=" + district + ", pincode=" + pincode + "]";
	}
	
}
