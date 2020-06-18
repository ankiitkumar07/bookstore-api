package com.bookstore.webapp.api.bookstoreapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserProfile;
import com.bookstore.webapp.api.bookstoreapi.exception.UserNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.UserProfileRepository;
import com.bookstore.webapp.api.bookstoreapi.repository.UserRepository;

@RestController
public class UserProfileController {

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{username}")
	public UserProfile getUserProfile(@PathVariable String username) {
		Optional<User> user = this.userRepository.findByUsername(username);
		if(!user.isPresent())
			throw new UserNotFoundException("Username does not exist");
		
		return this.userProfileRepository.findByUser(user.get());
	}
}
