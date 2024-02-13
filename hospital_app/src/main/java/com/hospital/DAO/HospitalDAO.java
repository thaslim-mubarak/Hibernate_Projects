package com.hospital.DAO;

import com.hospital.DTO.Hospital;

public class HospitalDAO {
	
	public static void updateHospital() { 
		
		System.out.println("Enter the hospital Id:");
		int id = Access.sc.nextInt();
		
		Hospital hosp = Access.entityManager.find(Hospital.class, id);
		
		if(hosp != null) {
			
			System.out.println("Enter the new chairman's name:");
			Access.sc.nextLine();
			String name = Access.sc.nextLine();
			hosp.setchairman(name);
			
			Access.entityTransaction.begin();
			Access.entityManager.merge(hosp);
			Access.entityTransaction.commit();
			System.out.println("Updated!");
			
		}
		else {
			System.out.println("Hospital Id is not present.");
		}
	}

}
