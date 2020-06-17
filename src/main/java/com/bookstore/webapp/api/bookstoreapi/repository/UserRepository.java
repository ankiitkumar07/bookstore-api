package com.bookstore.webapp.api.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
