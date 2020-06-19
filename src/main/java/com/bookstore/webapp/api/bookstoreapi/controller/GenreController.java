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

import com.bookstore.webapp.api.bookstoreapi.entity.Genre;
import com.bookstore.webapp.api.bookstoreapi.exception.GenreNotFoundException;
import com.bookstore.webapp.api.bookstoreapi.repository.GenreRepository;

@RestController
public class GenreController {

	@Autowired
	GenreRepository genreRepository;
	
	@GetMapping("/genre")
	public List<Genre> getGenre(){
		return this.genreRepository.findAll();
	}
	
	@GetMapping("/genre/{name}")
	public Genre getGenre(@PathVariable String name){
		Optional<Genre> genre = this.genreRepository.findByGenreName(name);
		
		if(!genre.isPresent())
			throw new GenreNotFoundException("This Genre is not present in our database. Do you want to create one?");
		
		return genre.get();
	}
	
	@PostMapping("/genre")
	public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){
		Genre savedGenre = this.genreRepository.save(genre);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(savedGenre.getGenreName())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
