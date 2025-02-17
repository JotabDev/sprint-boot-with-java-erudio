package com.br.jotab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.jotab.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
