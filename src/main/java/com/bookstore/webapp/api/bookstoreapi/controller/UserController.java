package com.bookstore.webapp.api.bookstoreapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;
import com.bookstore.webapp.api.bookstoreapi.entity.UserProfile;
import com.bookstore.webapp.api.bookstoreapi.exception.UserNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.UserBookShelfRepository;
import com.bookstore.webapp.api.bookstoreapi.repository.UserProfileRepository;
import com.bookstore.webapp.api.bookstoreapi.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	UserBookShelfRepository userBookShelfRepo;
	
	@GetMapping("/users")
	public List<User> all(){
		return this.userRepository.findAll();
	}
	
	@GetMapping("/users/{username}")
	public User one(@PathVariable String username) {
		Optional<User> user = this.userRepository.findByUsername(username);
		if(!user.isPresent())
			throw new UserNotFoundException("Could not find " + username) ;
		return user.get();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		user.setRole("USER");
		User savedUser = this.userRepository.save(user);
		
		UserProfile userProfile = new UserProfile(savedUser);
		this.userProfileRepository.save(userProfile);
		UserBookShelf userBookShelf = new UserBookShelf(savedUser);
		this.userBookShelfRepo.save(userBookShelf);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{username}")
				.buildAndExpand(savedUser.getUsername()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/admin")
	public ResponseEntity<User> createAdmin(@RequestBody User admin){
		admin.setRole("ADMIN");
		User savedAdmin = this.userRepository.save(admin);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{username}")
				.buildAndExpand(savedAdmin.getUsername()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{username}")
	public void deleteUser(@PathVariable String username) {
		this.userRepository.delete(this.userRepository.findByUsername(username).get());
	}
	
	@DeleteMapping("/admin/{username}")
	public void deleteAdmin(@PathVariable String username) {
		this.userRepository.delete(this.userRepository.findByUsername(username).get());
	}

}
