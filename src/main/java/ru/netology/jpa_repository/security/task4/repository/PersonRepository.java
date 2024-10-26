package ru.netology.jpa_repository.security.task4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.netology.jpa_repository.security.task4.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select p from Person as p where lower(p.city) = lower(:city)")
	Optional<List<Person>> findByCity(String city);

	@Query("select p from Person as p where lower(p.name) = lower(:name) and lower(p.surname) = lower(:surname)")
	Optional<List<Person>> findByNameAndSurname(String name, String surname);

	@Query("select p from Person as p where p.age < :age order by p.age")
	Optional<List<Person>> findByAgeLessThan(int age);
}
