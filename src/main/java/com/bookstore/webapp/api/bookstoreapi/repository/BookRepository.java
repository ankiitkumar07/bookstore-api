package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findAllByAuthorName(String name);

	public Optional<Book> findByTitle(String title);
}
