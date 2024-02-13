package com.hospital.DAO;

import com.hospital.DTO.Encounter;
import com.hospital.DTO.Person;

public class PersonDAO {
	
	public static void addPerson() {
		Person person = new Person();
		System.out.println("Enter the person's aadhar number:");
		person.setAadhar(Access.sc.nextInt());
		System.out.println("Enter the name of the person:");
		person.setName(Access.sc.next());
		System.out.println("Enter the gender:(male/female)");
		person.setGender(Access.sc.next());
		System.out.println("Enter the person's age:");
		person.setAge(Access.sc.nextInt());
		System.out.println("Enter the encounter id:");
		Encounter encounter = Access.entityManager.find(Encounter.class, Access.sc.nextInt());
		person.setEncounter(encounter);
		
		Access.entityTransaction.begin();
		Access.entityManager.persist(person);
		Access.entityTransaction.commit();
	}
	
	public static void deletePerson() {
		Person person = null;
		System.out.println("Enter the person's aadhar:");
		person = Access.entityManager.find(Person.class, Access.sc.nextInt());
		
		if (person != null) {
			Access.entityTransaction.begin();
			Access.entityManager.remove(person);
			Access.entityTransaction.commit();
		}
		else {
			System.out.println("Person with the entered aadhar doesn't exists.");
		}
	}

}
