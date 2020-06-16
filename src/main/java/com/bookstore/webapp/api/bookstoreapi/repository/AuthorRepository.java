package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	public List<Author> findAllByName(String name);
}
