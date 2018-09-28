package com.eaa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EaaTestServerKgreenApplication {

	public static void main(String[] args) {
		PersonStore ps = PersonStore.PersonStore();
		Person p1 = new Person("Charlie", "Brown", "charlie.brown@peanuts.org");
		ps.createPerson(p1);
		Person p2 = new Person("Lucy", "VanPelt", "lucy.vanpelt@peanuts.org");
		ps.createPerson(p2);
		SpringApplication.run(EaaTestServerKgreenApplication.class, args);
	}
}
