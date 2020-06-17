package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;

public interface UserBookShelfRepository extends JpaRepository<UserBookShelf, User> {
	public List<UserBookShelf> findAllByUser(User user);
}
