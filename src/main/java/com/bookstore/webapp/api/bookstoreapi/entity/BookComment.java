package com.bookstore.webapp.api.bookstoreapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_comments")
public class BookComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "comment_title")
	private String commentTitle;
	
	@Column(name = "comment_body")
	private String commentBody;
	
	@Column(name = "rating")
	private String rating;
	
	public BookComment() {
		super();
	}

	public BookComment(User user, Book book, String commentTitle, String commentBody, String rating) {
		super();
		this.user = user;
		this.book = book;
		this.commentTitle = commentTitle;
		this.commentBody = commentBody;
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getCommentTitle() {
		return commentTitle;
	}

	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "BookComment [id=" + id + ", user=" + user + ", book=" + book + ", commentTitle=" + commentTitle
				+ ", commentBody=" + commentBody + ", rating=" + rating + "]";
	}
	
	
}
