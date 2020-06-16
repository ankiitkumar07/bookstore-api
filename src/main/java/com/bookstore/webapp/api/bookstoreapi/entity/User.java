package com.bookstore.webapp.api.bookstoreapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "encryptedPassword", nullable = false)
	private String encryptedPassword;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private UserProfile userProfile;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private UserBookShelf userBookShelf;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnore
	private List<BookComment> bookComments;

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public UserBookShelf getUserBookShelf() {
		return userBookShelf;
	}

	public void setUserBookShelf(UserBookShelf userBookShelf) {
		this.userBookShelf = userBookShelf;
	}

	public List<BookComment> getBookComments() {
		return bookComments;
	}

	public void setBookComments(List<BookComment> bookComments) {
		this.bookComments = bookComments;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", encryptedPassword=" + encryptedPassword + ", username=" + username
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", userProfile=" + userProfile
				+ ", userBookShelf=" + userBookShelf + ", bookComments=" + bookComments + "]";
	}
	
	
	
}
