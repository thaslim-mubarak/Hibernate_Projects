package com.hospital2.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hospital2.DTO.Encounter;
import com.hospital2.DTO.Person;

public class PersonDAO {

	public static void addPerson() {
		
		Fetch.persons();

		System.out.println("Enter the encounter Id:");
		Encounter encounter = Access.entityManager.find(Encounter.class, Access.scanner.nextInt());

		Person person = new Person();

		System.out.println("Enter the aadhar no:");
		person.setAadhar(Access.scanner.nextInt());
		System.out.println("Enter the person name:");
		person.setName(Access.scanner.next());
		System.out.println("Enter the height:");
		person.setHeight(Access.scanner.nextDouble());

		encounter.setPerson(person);

		List<Encounter> encounters = person.getEncounter();

		if (encounters == null) {
			encounters = new ArrayList<Encounter>();
			encounters.add(encounter);
		} else if (encounters.isEmpty()) {
			encounters = new ArrayList<Encounter>();
			encounters.add(encounter);
		} else {
			encounters.add(encounter);
		}

		person.setEncounter(encounters);

		Access.entityTransaction.begin();
		Access.entityManager.merge(encounter);
		Access.entityTransaction.commit();

	}

	public static void updatePerson() {
		
		Fetch.persons();
		
		System.out.println("Enter your aadhar:");
		Person p = Access.entityManager.find(Person.class, Access.scanner.nextInt());

		if (p != null) {
			System.out.println("What do you want to update?\n1. Name\n2. Height\n3. Add an encounter");

			switch (Access.scanner.nextInt()) {
			case 1: {
				System.out.println("Enter the name to be updated:");
				p.setName(Access.scanner.next());
				break;
			}
			case 2: {
				System.out.println("Enter the height to be updated:");
				p.setHeight(Access.scanner.nextDouble());
				break;
			}
			case 3: {

				List<Encounter> encounters = p.getEncounter();
				System.out.println("Enter the encounter id to be added:");
				Encounter e = Access.entityManager.find(Encounter.class, Access.scanner.nextInt());

				if (encounters.size() > 0 && encounters != null) {

					if (e != null) {
						encounters.add(e);
					} else {
						System.out.println("Encounter is not present.");
					}
				} else {
					encounters = new ArrayList<Encounter>();
					encounters.add(e);
				}

				p.setEncounter(encounters);

			}
			default:
				break;
			}

			Access.entityTransaction.begin();

			Access.entityManager.merge(p);

			Access.entityTransaction.commit();
		}

	}

	public static void removePerson() {
		
		Fetch.persons();

		System.out.println("Enter the the person's Aadhar");
		Person person = Access.entityManager.find(Person.class, Access.scanner.nextInt());

		List<Encounter> encounters = person.getEncounter();

		for (Encounter e : encounters) {
			e.setPerson(null);
		}

		Access.entityTransaction.begin();
		Access.entityManager.remove(person);
		Access.entityTransaction.commit();

	}

}
