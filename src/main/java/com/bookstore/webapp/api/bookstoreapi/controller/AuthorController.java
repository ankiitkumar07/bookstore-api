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
import org.springframework.web.util.UriBuilder;

import com.bookstore.webapp.api.bookstoreapi.entity.Author;
import com.bookstore.webapp.api.bookstoreapi.exception.AuthorNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.AuthorRepository;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors(){
		return this.authorRepository.findAll();
	}
	
	@GetMapping("/author/{name}")
	public List<Author> getAuthorByName(@PathVariable String name){
		List<Author> author = this.authorRepository.findAllByName(name);
		if(author.isEmpty())
			throw new AuthorNotFoundException("Author " + name + " does not exist in our database. Do you want to create one?");
		return author;
	}
	
	@PostMapping("/authors")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author){
		String name = author.getName();
		List<Author> authorList = this.authorRepository.findAllByName(name);
		if(authorList.contains(name))
			throw new AuthorAlreadyExistsException("The Author name you are trying to create already exists!");
		
		Author savedAuthor = this.authorRepository.save(author);
			
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedAuthor.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
