package com.hospital.DAO;

import java.util.Arrays;
import java.util.List;

import com.hospital.DTO.Item;

public class ItemDAO {

	public static List<Item> addItems() {
		
		Item item = new Item();
		System.out.println("Medicine-1");
		item.setItem1(Access.sc.next());
		System.out.println("Medicine-2");
		item.setItem2(Access.sc.next());
		System.out.println("Medicine-3");
		item.setItem3(Access.sc.next());
		
		List<Item> items = Arrays.asList(item);
		
		return items;
		
	}
	
}
