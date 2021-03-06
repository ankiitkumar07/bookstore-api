package com.bookstore.webapp.api.bookstoreapi.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title", unique = true)
	@NotNull
	private String title;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "book_path")
	private String bookPath;
	
	@Column(name = "cover_path")
	private String coverPath;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
	@JsonIgnore
	private List<UserBookShelf> userBookShelf;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	@JsonIgnore
	private List<BookComment> bookComments;

	public Book() {
		super();
	}

	public Book(String title, String summary, double price, String bookPath, String coverPath, Author author) {
		super();
		this.title = title;
		this.summary = summary;
		this.price = price;
		this.bookPath = bookPath;
		this.coverPath = coverPath;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookPath() {
		return bookPath;
	}

	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public List<UserBookShelf> getUserBookShelf() {
		return userBookShelf;
	}

//	public void setUserBookShelf(UserBookShelf userBookShelf) {
//		this.userBookShelf = userBookShelf;
//	}
	
	public List<BookComment> getBookComments() {
		return bookComments;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", summary=" + summary + ", price=" + price + ", bookPath="
				+ bookPath + ", coverPath=" + coverPath + ", author=" + author + ", userBookShelf=" + userBookShelf
				+ "]";
	}
	
}
