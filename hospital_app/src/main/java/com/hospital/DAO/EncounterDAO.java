package com.hospital.DAO;

import com.hospital.DTO.Branch;
import com.hospital.DTO.Encounter;

public class EncounterDAO {
	
	public static void addEncounter() {
		
		Encounter encounter = new Encounter();
		
		System.out.println("Enter the encounter Id:");
		encounter.setEncounter_id(Access.sc.nextInt());
		System.out.println("Enter the Patient's weight:");
		encounter.setWeight(Access.sc.nextDouble());
		System.out.println("Enter the Patient's Blood Pressure:");
		encounter.setBp(Access.sc.next());
		System.out.println("Enter the Branch Id:");
		Branch branch = Access.entityManager.find(Branch.class, Access.sc.nextInt());
		encounter.setBranch(branch);
		
		Access.entityTransaction.begin();
		Access.entityManager.persist(encounter);
		Access.entityTransaction.commit();
		
	}
	
	public static void updateEncounter() {
		System.out.println("Enter the encounter Id:");
		Encounter encounter = Access.entityManager.find(Encounter.class, Access.sc.nextInt());
		
		System.out.println("What you want to change?\n1. BP\n2. Weight");
		int ch = Access.sc.nextInt();
		switch(ch) {
		case 1: {
			System.out.println("Enter the updated Blood Pressure:");
			encounter.setBp(Access.sc.next());
			break;
		}
		case 2: {
			System.out.println("Enter the updated Weight:");
			encounter.setWeight(Access.sc.nextDouble());
			break;
		}
		default: {
			System.out.println("Wrong input ...");
		}
		}
		
		Access.entityTransaction.begin();
		Access.entityManager.merge(encounter);
		Access.entityTransaction.commit();
		
	}

}
