package com.hospital2.DAO;

import com.hospital2.DTO.Address;
import com.hospital2.DTO.Branch;

public class AddressDAO {
	
	public static Address addAddress() {
		Address address = new Address();
		System.out.println("Enter the Branch Id:");
		Branch branch = Access.entityManager.find(Branch.class, Access.scanner.nextInt());
		System.out.println("Enter the city:");
		address.setCity(Access.scanner.next());
		System.out.println("Enter the District:");
		address.setDistrict(Access.scanner.next());
		System.out.println("Enter the Pincode:");
		address.setPincode(Access.scanner.nextLong());
		address.setBranch(branch);
		branch.setAddress(address);
		
		Access.entityTransaction.begin();
		Access.entityManager.persist(address);
		Access.entityManager.merge(branch);
		Access.entityTransaction.commit();
		
		return address;
	}
	
	public static Address fetch() {
		System.out.println("Enter the address Id:");
		return Access.entityManager.find(Address.class, Access.scanner.nextInt());
	}
	
	public static boolean removeAddress() {
		Address add = fetch();	
		Branch branch = add.getBranch();
		branch.setAddress(null);
		
		if (branch.getAddress() == null) {
			Access.entityTransaction.begin();
			Access.entityManager.merge(branch);
			Access.entityManager.remove(add);
			Access.entityTransaction.commit();
			return true;
		}
		else {
			System.out.println("Wrong Id entered");
			return false;
		}
	}
	
	public static boolean updateAddress() {
		Address add = fetch();
		if (add != null) {
			System.out.println("What do you want to update?\n1. City\n2. District\n3. Pincode");
			switch (Access.scanner.nextInt()) {
			case 1:{
				System.out.println("Enter new city:");
				add.setCity(Access.scanner.next());
				
				Access.entityTransaction.begin();
				Access.entityManager.merge(add);
				Access.entityTransaction.commit();
				
				return true;
			}
			case 2:{
				System.out.println("Enter new District:");
				add.setDistrict(Access.scanner.next());
				
				Access.entityTransaction.begin();
				Access.entityManager.merge(add);
				Access.entityTransaction.commit();
				
				return true;
			}
			case 3:{
				System.out.println("Enter new Pincode:");
				add.setPincode(Access.scanner.nextLong());
				
				Access.entityTransaction.begin();
				Access.entityManager.merge(add);
				Access.entityTransaction.commit();
				
				return true;
			}
			default:{
				System.out.println("Wrong input");
				return false;
			}
			}
		}
		else {
			return false;
		}
	}

}
