package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;

public interface UserBookShelfRepository extends CrudRepository<UserBookShelf, User> {
	public List<UserBookShelf> findAllByUsername(String username);
}
