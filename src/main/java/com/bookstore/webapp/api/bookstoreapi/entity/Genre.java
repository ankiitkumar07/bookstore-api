package com.bookstore.webapp.api.bookstoreapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "genre_name", nullable = false, unique = true)
	private String genreName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
	@JsonIgnore
	private List<Book> books;
	
	protected Genre() {
		super();
	}
	
	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}

	
	public Long getId() {
		return id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	
}
