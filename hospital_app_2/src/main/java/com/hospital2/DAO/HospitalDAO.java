package com.hospital2.DAO;

import com.hospital2.DTO.Hospital;

public class HospitalDAO {
	
	public static Hospital createHospital() {
		
		System.out.println("Already existing hospitals:");
		Fetch.hospitals();
		
		Hospital hospital = new Hospital();

		System.out.println("Enter the Chairman's name:");
		hospital.setChairman(Access.scanner.nextLine());
		System.out.println("Enter the Hospital name:");
		hospital.setHospital_name(Access.scanner.nextLine());

		hospital.setBranches(null);

		Access.entityTransaction.begin();
		Access.entityManager.persist(hospital);
		Access.entityTransaction.commit();
		
		return hospital;
	}
	
	public static Hospital fetch() {
		
		System.out.println("Enter the Hospital Id:");
		Hospital hospital = Access.entityManager.find(Hospital.class, Access.scanner.nextInt());
		
		return hospital;
	}

	public static boolean updateHospital() {
		
		System.out.println("Already existing hospitals:");
		Fetch.hospitals();
		
		Hospital hosp = fetch();
		
		System.out.println("Enter the new hospital name:");
		Access.scanner.nextLine();
		hosp.setHospital_name(Access.scanner.nextLine());
		
		if(hosp != null) {
			Access.entityTransaction.begin();
			Access.entityManager.merge(hosp);
			Access.entityTransaction.commit();
			return true;
		}
		return false;
	}
}
