package com.bookstore.webapp.api.bookstoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;
import com.bookstore.webapp.api.bookstoreapi.entity.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserBookShelf, User> {

	public UserProfile findByUser(User user);
}
