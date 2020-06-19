package com.bookstore.webapp.api.bookstoreapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;
import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;
import com.bookstore.webapp.api.bookstoreapi.exception.UserNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.UserBookShelfRepository;
import com.bookstore.webapp.api.bookstoreapi.repository.UserRepository;

@RestController
public class UserBookShelfController {

	@Autowired
	UserBookShelfRepository userBookShelfRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{username}/book-shelf")
	public List<Book> getUserBookShelf(@PathVariable String username) {
		Optional<User> user = this.userRepository.findByUsername(username);
		if(!user.isPresent())
			throw new UserNotFoundException("Sorry! We cannot find " + username);
		
		return this.userBookShelfRepository.findByUser(user.get()).getBooks();
	}
	
	@PostMapping("/user/{username}/book-shelf")
	public void addBook(@PathVariable String username, @RequestBody Book book) {
		Optional<User> user = this.userRepository.findByUsername(username);
		UserBookShelf bookShelf = this.userBookShelfRepository.findByUser(user.get());
//		List<Book> bookListForBookShelf = new ArrayList<Book>();
//		bookListForBookShelf.add(book);
//		bookShelf.setBook(bookListForBookShelf);
		this.userBookShelfRepository.createUserBookShelfBooks(bookShelf.getId(), book.getId());
	}
	
	
}
