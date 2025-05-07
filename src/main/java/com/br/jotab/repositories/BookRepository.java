package com.br.jotab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.jotab.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
