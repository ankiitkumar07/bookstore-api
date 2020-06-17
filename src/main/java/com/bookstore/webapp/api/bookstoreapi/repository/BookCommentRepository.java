package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;
import com.bookstore.webapp.api.bookstoreapi.entity.BookComment;
import com.bookstore.webapp.api.bookstoreapi.entity.User;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {

	public List<BookComment> findAllByUser(User user);
	public List<BookComment> findAllByBook(Book book);
}
