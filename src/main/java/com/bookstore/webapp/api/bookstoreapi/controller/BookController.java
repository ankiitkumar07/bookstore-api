package com.bookstore.webapp.api.bookstoreapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;
import com.bookstore.webapp.api.bookstoreapi.exception.BookNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookRepository.findAll();
	}
	
	@GetMapping("/books/{title}")
	public Book getBookByTitle(@PathVariable String title) {
		Optional<Book> optionalBook = this.bookRepository.findByTitle(title);
		if(!optionalBook.isPresent())
			throw new BookNotFoundException("Title does not exist");
		
		return optionalBook.get();
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book savedBook = this.bookRepository.save(book);
		
		System.out.println(savedBook.getAuthor().getName());
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{title}")
				.buildAndExpand(savedBook.getTitle()).toUri();
		return ResponseEntity.created(location).build();
	}
}
