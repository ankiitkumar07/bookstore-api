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

import com.bookstore.webapp.api.bookstoreapi.entity.Book;
import com.bookstore.webapp.api.bookstoreapi.entity.BookComment;
import com.bookstore.webapp.api.bookstoreapi.exception.BookNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.BookCommentRepository;
import com.bookstore.webapp.api.bookstoreapi.repository.BookRepository;
import com.bookstore.webapp.api.bookstoreapi.repository.UserRepository;

@RestController
public class BookCommentController {

	@Autowired
	BookCommentRepository bookCommentRepository;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/book/{name}/comments")
	public List<BookComment> getCoomentsOnBook(@PathVariable String name){
		
		Optional<Book> book = this.bookRepo.findByTitle(name);
		if(!book.isPresent())
			throw new BookNotFoundException("Book not found");
		return this.bookCommentRepository.findAllByBook(book.get());
	}
	
	@PostMapping("/book/comment")
	public ResponseEntity<BookComment> createComment(@RequestBody BookComment comment){
		BookComment newComment = this.bookCommentRepository.save(comment);
		
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(newComment.getId()).toUri();
		
		URI location = URI.create("/book/" + newComment.getBook().getTitle() + "/comments");
		return ResponseEntity.created(location).build();
	}
}
