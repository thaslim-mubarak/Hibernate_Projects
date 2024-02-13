package com.hospital2.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.hospital2.DTO.Branch;
import com.hospital2.DTO.Encounter;
import com.hospital2.DTO.Hospital;

public class BranchDAO {

	public static Branch addBranch() {
		
		Fetch.branches();

		Hospital hospital = HospitalDAO.fetch();
		List<Branch> branches = hospital.getBranches();

		Branch branch = null;

		if (branches.isEmpty() || branches == null) {
			branch = new Branch();
			System.out.println("Enter the name of branch head:");
			Access.scanner.nextLine();
			branch.setBranch_head(Access.scanner.nextLine());
			System.out.println("Enter the phone number of the branch:");
			branch.setBranch_phone(Access.scanner.nextLong());
			branches = new ArrayList<Branch>();
			branches.add(branch);
			hospital.setBranches(branches);
			branch.setHospital(hospital);
			Access.entityTransaction.begin();
			Access.entityManager.persist(branch);
			Access.entityManager.merge(hospital);
			Access.entityTransaction.commit();
		} else {
			branch = new Branch();
			System.out.println("Enter the name of branch head:");
			Access.scanner.nextLine();
			branch.setBranch_head(Access.scanner.nextLine());
			System.out.println("Enter the phone number of the branch:");
			branch.setBranch_phone(Access.scanner.nextLong());

			branches.add(branch);
			hospital.setBranches(branches);
			branch.setHospital(hospital);
			Access.entityTransaction.begin();
			Access.entityManager.persist(branch);
			Access.entityManager.merge(hospital);
			Access.entityTransaction.commit();
		}

		return branch;

	}

	public static Branch fetch() {
		
		Fetch.branches();

		System.out.println("Enter the Branch Id:");
		Query q = Access.entityManager.createQuery("select b from Branch b where b.branch_id = " + Access.scanner.nextInt());
		Branch branch = (Branch) q.getResultList().get(0);

		return branch;
	}

	public static boolean updateBranch() {

		Branch branch = fetch();
		System.out.println("What do you want to update?\n1. Branch head name\n2. Branch phone number");
		switch (Access.scanner.nextInt()) {
		case 1: {
			System.out.println("Enter the new name:");
			Access.scanner.nextLine();
			branch.setBranch_head(Access.scanner.nextLine());

			Access.entityTransaction.begin();
			Access.entityManager.merge(branch);
			Access.entityTransaction.commit();

			return true;
		}

		case 2: {
			System.out.println("Enter the new phone number:");
			branch.setBranch_phone(Access.scanner.nextLong());

			Access.entityTransaction.begin();
			Access.entityManager.merge(branch);
			Access.entityTransaction.commit();

			return true;
		}

		default: {
			return false;
		}
		}

	}
	
	public static boolean removeBranch() {
		
		Fetch.branches();
		
		Branch branch = fetch();
		
		Access.entityTransaction.begin();
		Access.entityManager.remove(branch);
		Access.entityTransaction.commit();
		
		return true;
		
	}
}
