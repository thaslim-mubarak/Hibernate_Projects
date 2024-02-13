package com.hospital.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hospital.DTO.Address;
import com.hospital.DTO.Branch;
import com.hospital.DTO.Hospital;

public class Demo {

	
	public static void main(String[] args) {
		
		Branch branch = new Branch();

		System.out.println("Enter the Branch Id:");
		int id = Access.sc.nextInt();
		branch.setBranch_id(id);
		System.out.println("Enter the Branch Head's name:");
		Access.sc.nextLine();
		branch.setBranch_head(Access.sc.nextLine());
		System.out.println("Does the branch supports emergency care?\nEnter true if YES else false");
		branch.setEmergency_care(Access.sc.nextBoolean());
		System.out.println("Enter the Branch Phone:");
		branch.setPhone(Access.sc.nextLong());

		Address add = new Address();
		System.out.println("Enter the Address Id:");
		add.setAddress_id(Access.sc.nextInt());
		System.out.println("Enter the City:");
		add.setCity(Access.sc.next());
		System.out.println("Enter the District:");
		add.setDistrict(Access.sc.next());
		System.out.println("Enter the Pincode:");
		add.setPincode(Access.sc.nextLong());

		branch.setAddress(add);

		Hospital hosp = Access.entityManager.find(Hospital.class, id);
		List<Branch> branches = hosp.getBranches();

//		if (branches == null) {
//			branches = new ArrayList<Branch>();
//			branches.add(branch);
//		}
//		else {
//			branches.add(branch);
//		}
//
//		Access.entityTransaction.begin();
//		Access.entityManager.persist(branch);
//		Access.entityManager.persist(add);
//		Access.entityManager.merge(hosp);
//		Access.entityTransaction.commit();
		
	}
	
}
