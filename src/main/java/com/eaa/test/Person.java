package com.eaa.test;

import java.util.UUID;

public class Person {
	private UUID id = null;
	private String givenname = "";
	private String surname = "";
	private String email = "";
	
	public Person() {	
	}
	
	public Person(Person person) {
		this.givenname = person.getGivenname();
		this.surname = person.getSurname();
		this.email = person.getEmail();
		if (person.id == null) {
			// create
			this.id = UUID.randomUUID();
		} else {
			// update
			this.id = person.getId();
		}
	}
	
	public Person(String givenname,
				  String surname,
				  String email) {
		this.givenname = givenname;
		this.surname = surname;
		this.email = email;
		this.id = UUID.randomUUID();
	}
	
	// Getters
	public UUID getId() {
		return this.id;
	}
	
	public String getGivenname() {
		return this.givenname;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	// Setters
	public void setId() {
		// Cannot change id
	}
	
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + this.id.toString() + "\"," +
				"\"givenname\":\"" + this.givenname + "\"," +
				"\"surname\":\"" + this.surname + "\"," +
				"\"email\":\"" + this.email + "\"}";
	}
}
