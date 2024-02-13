package com.hospital.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	
	@Id
	int branch_id;
	String branch_head;
	boolean emergency_care;
	long phone;
	
	@OneToOne
	Address address;

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_head() {
		return branch_head;
	}

	public void setBranch_head(String branch_head) {
		this.branch_head = branch_head;
	}

	public boolean isEmergency_care() {
		return emergency_care;
	}

	public void setEmergency_care(boolean emergency_care) {
		this.emergency_care = emergency_care;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", branch_head=" + branch_head + ", emergency_care=" + emergency_care
				+ ", phone=" + phone + ", address=" + address + "]";
	}

}
