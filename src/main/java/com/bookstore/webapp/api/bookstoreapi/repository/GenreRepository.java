package com.bookstore.webapp.api.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.bookstore.webapp.api.bookstoreapi.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	Optional<Genre> findByGenreName(String name);

}
