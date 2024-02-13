package com.hospital2.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int item_id;
	String item_1;
	String item_2;
	String item_3;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "items")
	List<MedOrders> orders;

	public String getItem_1() {
		return item_1;
	}

	public void setItem_1(String item_1) {
		this.item_1 = item_1;
	}

	public String getItem_2() {
		return item_2;
	}

	public void setItem_2(String item_2) {
		this.item_2 = item_2;
	}

	public String getItem_3() {
		return item_3;
	}

	public void setItem_3(String item_3) {
		this.item_3 = item_3;
	}

	public List<MedOrders> getOrders() {
		return orders;
	}

	public void setOrders(List<MedOrders> orders) {
		this.orders = orders;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_1=" + item_1 + ", item_2=" + item_2 + ", item_3=" + item_3 + "]";
	}

}
