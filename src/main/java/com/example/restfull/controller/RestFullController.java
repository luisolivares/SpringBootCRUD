package com.example.restfull.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfull.exception.PersonNotFoundException;
import com.example.restfull.exception.ResourceNotFoundException;
import com.example.restfull.model.Person;
import com.example.restfull.resources.PersonRepository;

@RestController("restfull")
public class RestFullController {
	
	@Autowired
	@Qualifier("personRepository")
	private PersonRepository personRepository;

	@GetMapping("/listPersons")
	public Page<Person> getAllPersons(Pageable pageable) throws PersonNotFoundException{
		
		try {
			return personRepository.findAll(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			throw new PersonNotFoundException("Not found persons");
		}
	    
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPerson(@RequestBody Person person) {
		Person savedStudent = personRepository.save(person);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/search/{id}")
	public Person retrievePerson(@PathVariable long id) {
		java.util.Optional<Person> person = personRepository.findById(id);

		if (!person.isPresent())
			throw new ResourceNotFoundException("Person", "id", id);

		return person.get();
	}
	
	
	/**
	 * Delete a person.
	 * @param id Primary key
	 * **/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
		Person note = personRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));

		personRepository.delete(note);

	    return ResponseEntity.ok().build();
	}
	
	
	/**
	 * Update a person
	 * @param id Primary key
	 * @param person Object Person
	 * **/
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable(value = "id") long id) {

		java.util.Optional<Person> personOptional = personRepository.findById(id);

		if (!personOptional.isPresent())
			return ResponseEntity.notFound().build();

		person.setId(id);
		
		personRepository.save(person);

		return ResponseEntity.noContent().build();
	}
	
	
	
}
