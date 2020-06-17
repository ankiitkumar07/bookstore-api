package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.webapp.api.bookstoreapi.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	public List<Author> findAllByName(String name);
}
