package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	public List<Book> findAllByAuthorName(String name);
}
