package com.hospital2.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hospital2.DTO.Encounter;
import com.hospital2.DTO.Item;
import com.hospital2.DTO.MedOrders;
import com.hospital2.DTO.Person;

public class MedOrdersDAO {
	
	public static MedOrders createOrder() {
		
		Fetch.orders();
		
		System.out.println("Enter the encounter Id:");
		Encounter encounter = Access.entityManager.find(Encounter.class, Access.scanner.nextInt());
		
		List<MedOrders> li_orders =  encounter.getOrders();
		
		MedOrders order = new MedOrders();
		System.out.println("Who billed this?");
		order.setBilled_by(Access.scanner.next());
		System.out.println("Total bill amount:");
		order.setOrder_total(Access.scanner.nextDouble());
		
		if(li_orders.isEmpty() || li_orders == null) {
			li_orders = new ArrayList<MedOrders>();
			li_orders.add(order);
		}
		else {
			li_orders.add(order);
		}
		order.setEncounter(encounter);
		encounter.setOrders(li_orders);
		
		Access.entityTransaction.begin();
		Access.entityManager.merge(encounter);
		Access.entityTransaction.commit();
		
		ItemDAO.addItems();
		
		return order;
		
	}
	
	public static void updateOrder() {
		
		Fetch.orders();
		
		System.out.println("Enter your aadhar:");
		Person p = Access.entityManager.find(Person.class, Access.scanner.nextInt());

		List<Encounter> encounters = p.getEncounter();

		System.out.println("Enter the encounter Id:");
		int e_id = Access.scanner.nextInt();

		Encounter encounter = null;

		for (Encounter e : encounters) {
			if (e.getEncounter_id() == e_id) {
				encounter = e;
				break;
			}
		}

		List<MedOrders> orders = encounter.getOrders();

		System.out.println("Enter the order id:");
		int o_id = Access.scanner.nextInt();

		MedOrders order = null;

		for (MedOrders mo : orders) {
			if (mo.getOrder_id() == o_id) {
				order = mo;
				break;
			}
		}

		List<Item> items = order.getItems();
		Item it = null;
		System.out.println("Enter the item id:");
		int i_id = Access.scanner.nextInt();

		for (Item i : items) {
			if (i.getItem_id() == i_id) {
				it = i;
			}
		}

		if (it != null) {
			System.out.println("Enter the item-1:");
			it.setItem_1(Access.scanner.next());
			System.out.println("Enter the item-2:");
			it.setItem_2(Access.scanner.next());
			System.out.println("Enter the item-3:");
			it.setItem_3(Access.scanner.next());
		}
		
		Access.entityTransaction.begin();
		Access.entityManager.merge(it);
		Access.entityTransaction.commit();

	}
	
	public static void cancelOrder() {
		
		Fetch.orders();
		
		System.out.println("Enter the order Id:");
		MedOrders order = Access.entityManager.find(MedOrders.class, Access.scanner.nextInt());
		
		order.setEncounter(null);
		
		List<Item> li = order.getItems();
		
		for (Item item : li) {
			Access.entityTransaction.begin();
			Access.entityManager.remove(item);
			Access.entityTransaction.commit();
		}
		
		Access.entityTransaction.begin();
		Access.entityManager.remove(order);
		Access.entityTransaction.commit();
		
		
	}

}
