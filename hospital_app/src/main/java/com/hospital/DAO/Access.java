package com.hospital.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Access {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hospital_app_hibernate");

	static EntityManager entityManager = entityManagerFactory.createEntityManager();

	static EntityTransaction entityTransaction = entityManager.getTransaction();

	static Scanner sc = new Scanner(System.in);

}
