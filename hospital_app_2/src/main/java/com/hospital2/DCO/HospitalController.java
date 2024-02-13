package com.hospital2.DCO;

import com.hospital2.DAO.Access;
import com.hospital2.DAO.AddressDAO;
import com.hospital2.DAO.BranchDAO;
import com.hospital2.DAO.EncounterDAO;
import com.hospital2.DAO.HospitalDAO;
import com.hospital2.DAO.MedOrdersDAO;
import com.hospital2.DAO.PersonDAO;

public class HospitalController {

	public static void main(String[] args) {
		
		System.out.println("Welcome!");
		while (true) {
			System.out.println("You're an\n1. Admin\n2. User\n3. Exit");
			int choice = Access.scanner.nextInt();
			switch (choice) {
			case 1: {
				boolean loop = true;
				while (loop) {
					System.out.println("Hi Admin! How can I help you?\n1. Create hospital\n2. Update Hospital\n3. Add branch\n4. Update Branch\n5. Delete branch\n6. Map address with branch\n7. Edit address\n8. Remove address\n9. Previous Menu");
					switch (Access.scanner.nextInt()) {
					case 1: {
						HospitalDAO.createHospital();
						break;
					}
					case 2: {
						HospitalDAO.updateHospital();
						break;
					}
					case 3:{
						BranchDAO.addBranch();
						break;
					}
					case 4:{
						BranchDAO.updateBranch();
						break;
					}
					case 5:{
						BranchDAO.removeBranch();
						break;
					}
					case 6:{
						AddressDAO.addAddress();
						break;
					}
					case 7:{
						AddressDAO.updateAddress();
						break;
					}
					case 8:{
						AddressDAO.removeAddress();
						break;
					}
					case 9:{
						loop = false;
						break;
					}
					default: {
						System.out.println("Enter the correct choice.");
						break;
					}
					}
				}
				break;
			}
			case 2: {
				boolean loop = true;
				
				while (loop) {
					System.out.println("Hi User! How can I help you?\n1. Add an encounter\n2. Remove an encounter\n3. Order items\n4. Update an Order\n5. Cancel order\n6. Add a person\n7. Update person details\n8. Remove a person's record\n9. Previous menu");
					
					switch (Access.scanner.nextInt()) {
					case 1:{
						EncounterDAO.addEncounter();
						break;
					}
					case 2:{
						EncounterDAO.removeEncounter();
						break;
					}
					case 3:{
						MedOrdersDAO.createOrder();
						break;
					}
					case 4:{
						MedOrdersDAO.updateOrder();
						break;
					}
					case 5:{
						MedOrdersDAO.cancelOrder();
						break;
					}
					case 6:{
						PersonDAO.addPerson();
						break;
					}
					case 7:{
						PersonDAO.updatePerson();
						break;
					}
					case 8:{
						PersonDAO.removePerson();
						break;
					}
					case 9:{
						loop = false;
						break;
					}
					default:
						System.out.println("Wrong input");
						break;
					}
				}
				break;
			}
			case 3: {
				return;
			}
			default:{
				System.out.println("Enter the correct input.");
				break;
			}
			}
		}
	}
}
