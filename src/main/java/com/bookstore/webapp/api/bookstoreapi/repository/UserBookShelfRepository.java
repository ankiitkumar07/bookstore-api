package com.bookstore.webapp.api.bookstoreapi.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.bookstore.webapp.api.bookstoreapi.entity.User;
import com.bookstore.webapp.api.bookstoreapi.entity.UserBookShelf;

public interface UserBookShelfRepository extends JpaRepository<UserBookShelf, User> {
	public UserBookShelf findByUser(User user);
	
	@Transactional
	@Modifying
	@Query(
			value = "insert into user_book_shelf_books (user_book_shelf_id, books_id) values (:userBookShelfId, :book_id)", 
			nativeQuery = true)
	public void createUserBookShelfBooks(
			@Param("userBookShelfId") Long userBookShelfId, 
			@Param("book_id") Long book_id);
}
