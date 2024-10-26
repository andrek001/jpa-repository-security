package ru.netology.jpa_repository.security.task4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ru.netology.jpa_repository.security.task4.model.Person;
import ru.netology.jpa_repository.security.task4.repository.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository repository;

	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public Optional<List<Person>> getPersonsByCity(String city) {
		return repository.findByCity(city);
	}

	public Optional<List<Person>> findByNameAndSurname(final String name, final String surname) {
		return repository.findByNameAndSurname(name, surname);
	}

	public Optional<List<Person>> findByAgeLessThan(final int age) {
		return repository.findByAgeLessThan(age);
	}

	public List<Person> findAll() {
		return repository.findAll();
	}
}
