package com.hospital.DAO;

import java.util.List;

import com.hospital.DTO.Encounter;
import com.hospital.DTO.Item;
import com.hospital.DTO.MedOrders;

public class MedOrdersDAO {
	
	public static void addOrder() {
		MedOrders order = new MedOrders();
		System.out.println("Enter the Order Id:");
		order.setId(Access.sc.nextInt());
		System.out.println("Enter the bill amount:");
		order.setBill_amount(Access.sc.nextDouble());
		
		System.out.println("Enter the medicines:");
		
		List<Item> items = ItemDAO.addItems();
		
		order.setItems(items);
		
		System.out.println("Enter the Encounter ID:");
		Encounter encounter = Access.entityManager.find(Encounter.class, Access.sc.nextInt());
		order.setEncounter(encounter);
		
		Access.entityTransaction.begin();
		Access.entityManager.persist(order);
		for (Item item : items) {
			Access.entityManager.persist(item);
		}
		Access.entityTransaction.commit();
	}
	
	public static void cancelOrder() {
		MedOrders order = null;
		System.out.println("Enter the Order Id:");
		order = Access.entityManager.find(MedOrders.class, Access.sc.nextInt());
		
		if (order != null) {
			
			List<Item > items = order.getItems();
			
			Access.entityTransaction.begin();
			Access.entityManager.remove(order);
			for (Item item : items) {
				Access.entityManager.remove(item);
			}
			Access.entityTransaction.commit();
		}
		else {
			System.out.println("Order ID doesn't exists.");
		}
	}

}
