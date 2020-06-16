package com.bookstore.webapp.api.bookstoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserProfile;

public interface UserRepository extends CrudRepository<UserProfile, String> {
	User fingByUsername(String username);
}
