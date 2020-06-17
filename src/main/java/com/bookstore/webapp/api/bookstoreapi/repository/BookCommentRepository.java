package com.bookstore.webapp.api.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.webapp.api.bookstoreapi.entity.Book;
import com.bookstore.webapp.api.bookstoreapi.entity.BookComment;
import com.bookstore.webapp.api.bookstoreapi.entity.User;

public interface BookCommentRepository extends CrudRepository<BookComment, Long> {

	public List<BookComment> findAllByUser(User user);
	public List<BookComment> findAllByBook(Book book);
}
