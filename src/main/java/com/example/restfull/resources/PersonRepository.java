package com.example.restfull.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restfull.model.Person;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long>{

}
