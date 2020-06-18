package com.bookstore.webapp.api.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;
import com.bookstore.webapp.api.bookstoreapi.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	public UserProfile findByUser(User user);
}
