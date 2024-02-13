package com.hospital2.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hospital2.DTO.Branch;
import com.hospital2.DTO.Encounter;

public class EncounterDAO {
	
	public static Encounter addEncounter() {
		
		Fetch.encounters();
		
		System.out.println("Enter the branch Id:");
		Branch branch = Access.entityManager.find(Branch.class, Access.scanner.nextInt());
		List<Encounter> encounters = branch.getEncounters();
		Encounter encounter = null;
		
		if(encounters.isEmpty() || encounters == null) {
			encounter = new Encounter();
			System.out.println("Enter the patient's age:");
			encounter.setAge(Access.scanner.nextInt());
			System.out.println("Enter the patient's Blood pressure:");
			encounter.setBlood_pressure(Access.scanner.next());
			System.out.println("Enter the patient's Blood sugar:");
			encounter.setBlood_sugar(Access.scanner.next());
			
			encounter.setBranch(branch);
			encounters = new ArrayList<Encounter>();
			encounters.add(encounter);
			branch.setEncounters(encounters);
			Access.entityTransaction.begin();
			Access.entityManager.persist(encounter);
			Access.entityTransaction.commit();
			return encounter;
			
		}else {
			encounter = new Encounter();
			System.out.println("Enter the patient's age:");
			encounter.setAge(Access.scanner.nextInt());
			System.out.println("Enter the patient's Blood pressure:");
			encounter.setBlood_pressure(Access.scanner.next());
			System.out.println("Enter the patient's Blood sugar:");
			encounter.setBlood_sugar(Access.scanner.next());
			encounter.setBranch(branch);
			encounters.add(encounter);
			branch.setEncounters(encounters);
			Access.entityTransaction.begin();
			Access.entityManager.persist(encounter);
			Access.entityTransaction.commit();
			return encounter;
		}
	}
	
	public static boolean removeEncounter() {
		
		Fetch.encounters();
		
		System.out.println("Enter the encounter Id:");
		Encounter encounter = Access.entityManager.find(Encounter.class, Access.scanner.nextInt());
		
		if (encounter != null) {
			Branch branch = encounter.getBranch();
			branch.setEncounters(null);
			Access.entityTransaction.begin();
			Access.entityManager.merge(branch);
			Access.entityManager.remove(encounter);
			Access.entityTransaction.commit();
			return true;
		}
		else {
			System.out.println("Wrong encounter Id.");
			return false;
		}
	}

}
