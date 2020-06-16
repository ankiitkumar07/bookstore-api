package com.bookstore.webapp.api.bookstoreapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authors")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String title;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "book_path")
	private String bookPath;
	
	@Column(name = "cover_path")
	private String coverPath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	@JsonIgnore
	private Author author;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "user_book_shelf_id")
	private UserBookShelf userBookShelf;
}
