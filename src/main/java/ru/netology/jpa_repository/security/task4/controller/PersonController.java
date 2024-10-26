package ru.netology.jpa_repository.security.task4.controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.jpa_repository.security.task4.model.Person;
import ru.netology.jpa_repository.security.task4.service.PersonService;

@RequestMapping("/persons")
@RestController
public class PersonController {

	private final PersonService service;

	public PersonController(PersonService service) {
		this.service = service;
	}

	@GetMapping("/by-city")
	public List<Person> getPersonsByCity(@RequestParam("city") String city) {
		return service.getPersonsByCity(city).orElseGet(List::of);
	}

	@GetMapping("/by-name")
	public List<Person> getPersonByNameAndSurname(@RequestParam("name") String name,
			@RequestParam("surname") String surname) {
		return service.findByNameAndSurname(name, surname).orElseGet(List::of);
	}

	@GetMapping("/by-age")
	public List<Person> getPersonsByAge(@RequestParam("age") int age) {
		return service.findByAgeLessThan(age).orElseGet(List::of);
	}
	@GetMapping
	public List<Person> getAll() {
		return service.findAll();
	}
}
