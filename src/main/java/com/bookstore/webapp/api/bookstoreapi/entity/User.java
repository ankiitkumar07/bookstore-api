package com.bookstore.webapp.api.bookstoreapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private List<BookComment> bookComments;

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public String getUsername() {
		return username;
	}
	
	
	
}
