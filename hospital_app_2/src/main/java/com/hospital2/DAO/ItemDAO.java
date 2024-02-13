package com.hospital2.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hospital2.DTO.Item;
import com.hospital2.DTO.MedOrders;

public class ItemDAO {
	
	public static void addItems() {
		
		System.out.println("Enter the order Id:");
		MedOrders order = Access.entityManager.find(MedOrders.class, Access.scanner.nextInt());
		Item item = new Item();
		List<MedOrders> orders = item.getOrders();
		System.out.println("Add Item-1:");
		item.setItem_1(Access.scanner.next());
		System.out.println("Add Item-2:");
		item.setItem_2(Access.scanner.next());
		System.out.println("Add Item-3:");
		item.setItem_3(Access.scanner.next());
		List<Item> items = order.getItems();
		if(items != null) {
			items.add(item);
		}
		else {
			items = new ArrayList<Item>();
			items.add(item);
		}
		order.setItems(items);
		if(orders != null) {
			item.setOrders(orders);
		}
		else {
			orders = new ArrayList<MedOrders>();
			orders.add(order);
			item.setOrders(orders);
		}
		
		Access.entityTransaction.begin();
		Access.entityManager.persist(item);
		Access.entityTransaction.commit();
	}

}
