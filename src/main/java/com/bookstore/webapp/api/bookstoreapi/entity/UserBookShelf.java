package com.bookstore.webapp.api.bookstoreapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_book_shelf")
public class UserBookShelf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> books;
	
	public UserBookShelf() {
		super();
	}

	public UserBookShelf(User user, List<Book> books) {
		super();
		this.user = user;
		this.books = books;
	}

	public UserBookShelf(User user2) {
		// TODO Auto-generated constructor stub
		this.user = user2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return books;
	}

//	public void setBook(Book book) {
//		this.book = book;
//	}
	
	public void addBooks(Book book) {
		this.books.add(book);
	}

	@Override
	public String toString() {
		return "UserBookShelf [user=" + user + ", book=" + books + "]";
	}
	
	
	
}
