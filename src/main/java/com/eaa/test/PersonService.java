package com.eaa.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/person")
public class PersonService {
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Person> getAll() {
		PersonStore ps = PersonStore.PersonStore();
		return ps.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Person createPerson(@RequestBody Person personBody) throws Exception {
		Person person = new Person(personBody);
		PersonStore ps = PersonStore.PersonStore();
		if (!ps.EmailExists(person.getEmail())) {
			ps.createPerson(person);
		} else {
			throw new Exception("Person \"" + person.getEmail() + "\" already exists");
		}
		return person;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Person updatePerson(@PathVariable UUID id,
							   @RequestBody Person personBody) throws Exception {
		Person person = new Person(personBody);
		PersonStore ps = PersonStore.PersonStore();
		if (ps.UUIDExists(person.getId())) {
			ps.updatePerson(person);
		} else {
			throw new Exception("Person \"" + person.getId().toString() + "\" does not exist");
		}
		return person;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Person deletePerson(@PathVariable UUID id) throws Exception {
		Person person = new Person();
		PersonStore ps = PersonStore.PersonStore();
		if (ps.UUIDExists(id)) {
			person = ps.getPerson(id);
			ps.deletePerson(id);
		} else {
			throw new Exception("Person \"" + id.toString() + "\" does not exist");			
		}
		return person;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable UUID id) {
		PersonStore ps = PersonStore.PersonStore();
		return ps.getPerson(id);
	}
}
