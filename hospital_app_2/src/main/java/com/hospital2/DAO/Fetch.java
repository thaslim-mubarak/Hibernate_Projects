package com.hospital2.DAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import com.hospital2.DTO.Branch;
import com.hospital2.DTO.Encounter;
import com.hospital2.DTO.Hospital;
import com.hospital2.DTO.MedOrders;
import com.hospital2.DTO.Person;

public class Fetch {

	public static void hospitals() {

		Query q = Access.entityManager.createQuery("select hosp from Hospital hosp");

		List<Hospital> hospitals = q.getResultList();

		for (Hospital h : hospitals) {
			System.out.println(h);
		}

	}

	public static void branches() {
		Query q = Access.entityManager.createQuery("select bran from Branch bran");

		Iterator<Branch> branches = q.getResultList().iterator();
		
		while (branches.hasNext()) {
			System.out.println(branches.next());
		}

//		for (Branch b : branches) {
//			System.out.println(b);
//		}
	}

	public static void encounters() {
		Query q = Access.entityManager.createQuery("select enc from Encounter enc");

		List<Encounter> encounter = q.getResultList();

		for (Encounter e : encounter) {
			System.out.println(e);
		}
	}

	public static void persons() {
		Query q = Access.entityManager.createQuery("select p from Person p");

		List<Person> p = q.getResultList();

		for (Person pn : p) {
			System.out.println(pn);
		}
	}

	public static void orders() {
		Query q = Access.entityManager.createQuery("select o from MedOrders o");

		List<MedOrders> o = q.getResultList();

		for (MedOrders or : o) {
			System.out.println(or);
		}
	}
}
