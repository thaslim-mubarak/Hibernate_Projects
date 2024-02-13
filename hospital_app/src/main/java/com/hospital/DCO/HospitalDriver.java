package com.hospital.DCO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.DAO.BranchDAO;
import com.hospital.DAO.EncounterDAO;
import com.hospital.DAO.HospitalDAO;
import com.hospital.DAO.MedOrdersDAO;
import com.hospital.DAO.PersonDAO;
import com.hospital.DTO.Hospital;

public class HospitalDriver {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hospital_app_hibernate");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	static Scanner sc = new Scanner(System.in);

	static {
		Query q = entityManager.createQuery("select hosp from Hospital hosp");
		List<Hospital> hospitals = q.getResultList();
		if (hospitals.isEmpty()) {
			Hospital hosp = new Hospital();
			hosp.setBranches(null);

			entityTransaction.begin();
			entityManager.persist(hosp);
			entityTransaction.commit();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hospital management System!");
		while (true) {
			System.out.println("You're an ...\n1. Admin\n2. User\n3. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				boolean loop = true;
				while (loop) {
					System.out.println(
							"Hi Admin ...\n1. Update Hospital's founder\n2. Add Branch\n3. Update Branch\n4. Previous Menu");
					int choice_1 = sc.nextInt();
					switch (choice_1) {
					case 1: {
						HospitalDAO.updateHospital();
						break;
					}
					case 2: {
						BranchDAO.addBranch();
						break;
					}
					case 3: {
						BranchDAO.updateBranch();
						break;
					}
					case 4: {
						loop = false;
						break;
					}
					default:
						System.out.println("Enter the correct input:");
						break;
					}
				}
			}
				break;
			case 2: {
				boolean loop = true;
				while (loop) {
					System.out.println(
							"Hi User ...\n1. Create an encounter\n2. Update an existing encounter\n3. Order Medicines\n4. Cancel an order\n5. Add Person\n6. Delete a persons Record history\n7. Previous Menu");
					int choice_1 = sc.nextInt();
					switch (choice_1) {
					case 1: {
						EncounterDAO.addEncounter();
						break;
					}
					case 2: {
						EncounterDAO.updateEncounter();
						break;
					}
					case 3: {
						MedOrdersDAO.addOrder();
						break;
					}
					case 4: {
						MedOrdersDAO.cancelOrder();
						break;
					}
					case 5: {
						PersonDAO.addPerson();
						break;
					}
					case 6: {
						PersonDAO.deletePerson();
						break;
					}
					case 7: {
						loop = false;
						break;
					}
					default:
						System.out.println("Enter the correct input");
						break;
					}
				}
			}
				break;
			case 3: {
				return;
			}
			default:
				System.out.println("Invalid input.");
				break;
			}
		}
	}
}
