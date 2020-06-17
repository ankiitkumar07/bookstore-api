package com.bookstore.webapp.api.bookstoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserProfile;

public interface UserRepository extends CrudRepository<User, String> {
	User findByUsername(String username);
}
