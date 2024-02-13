package com.hospital.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hospital.DTO.Address;
import com.hospital.DTO.Branch;
import com.hospital.DTO.Hospital;

public class BranchDAO {

	public static void addBranch() {

		Branch branch = new Branch();

		System.out.println("Enter the Branch Id:");
		branch.setBranch_id(Access.sc.nextInt());
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
		
		System.out.println("Enter the hospital Id:");
		Hospital hosp = Access.entityManager.find(Hospital.class, Access.sc.nextInt());
		List<Branch> branches = hosp.getBranches();

		if (!branches.isEmpty()) {
			branches.add(branch);
		} else {
			List<Branch> branches1 = new ArrayList<Branch>();
			branches1.add(branch);
			hosp.setBranches(branches1);
		}

		Access.entityTransaction.begin();
		Access.entityManager.persist(branch);
		Access.entityManager.persist(add);
		Access.entityManager.merge(hosp);
		Access.entityTransaction.commit();

	}

	public static void updateBranch() {
		
		System.out.println("Enter the branch Id:");
		Branch branch = Access.entityManager.find(Branch.class, Access.sc.nextInt());
				
		System.out.println("Enter the Branch Head's name:");
		Access.sc.nextLine();
		branch.setBranch_head(Access.sc.nextLine());
		System.out.println("Does the branch supports emergency care?\nEnter true if YES else false");
		branch.setEmergency_care(Access.sc.nextBoolean());
		System.out.println("Enter the Branch Phone:");
		branch.setPhone(Access.sc.nextLong());
		
		Address add = branch.getAddress();
		System.out.println("Enter the City:");
		add.setCity(Access.sc.next());
		System.out.println("Enter the District:");
		add.setDistrict(Access.sc.next());
		System.out.println("Enter the Pincode:");
		add.setPincode(Access.sc.nextLong());
		
		branch.setAddress(add);
		
		Access.entityTransaction.begin();
		Access.entityManager.merge(branch);
		Access.entityManager.merge(add);
		Access.entityTransaction.commit();

	}

}
