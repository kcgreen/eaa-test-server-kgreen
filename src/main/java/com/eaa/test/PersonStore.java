package com.eaa.test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

public class PersonStore {
	private static PersonStore ps = null;
	
	// UUID -> Email
	protected HashMap<UUID,String> hashmapEmail = null;
	// Email -> Person
	protected HashMap<String,Person> hashmapPerson = null;
	
	private PersonStore() {
		hashmapEmail = new HashMap<UUID,String>();
		hashmapPerson = new HashMap<String,Person>();
	}
	
	public static PersonStore PersonStore() {
		if (ps == null) {
			ps = new PersonStore();
		}
		return ps;
	}
	
	public List<Person> getAll() {
		return hashmapPerson.values().stream().sorted((e1,e2)->
        	(e1.getSurname()+e1.getGivenname()).compareTo(e2.getSurname()+e2.getGivenname()))
			.collect(Collectors.toList()); 
	}
	
	public boolean UUIDExists(UUID id) {
		return hashmapEmail.containsKey(id);
	}
	
	public boolean EmailExists(String email) {
		return hashmapPerson.containsKey(email);
	}
	
	public Person getPerson(UUID id) {
		return (hashmapPerson.get(hashmapEmail.get(id)));
	}
	
	public Person getPerson(String email) {
		return (hashmapPerson.get(email));
	}
	
	public void createPerson(Person person) {
		String email = new String(person.getEmail());
		hashmapEmail.put(person.getId(), email);
		hashmapPerson.put(email, person);
	}
	
	public void updatePerson(Person person) {
		String email = new String(person.getEmail());
		String emailOld = new String(hashmapEmail.get(person.getId()));
		if (email != emailOld) {
			hashmapEmail.replace(person.getId(), email);
			hashmapPerson.remove(emailOld);
			hashmapPerson.put(email, person);
		} else {
			hashmapPerson.replace(email, person);
		}
	}
	
	public void deletePerson(UUID id) {
		String email = new String(hashmapEmail.get(id));
		hashmapEmail.remove(id);
		hashmapPerson.remove(email);
	}
}
