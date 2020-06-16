package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;
import com.bookstore.webapp.api.bookstoreapi.entity.BookComment;

public interface BookCommentRepository extends CrudRepository<BookComment, Long> {

	public List<BookComment> findAllByUsername(String username);
	public List<BookComment> findAllByBook(Book book);
}
