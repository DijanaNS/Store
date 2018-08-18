package com.store.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.store.model.Book;

public interface BookService {
	Page<Book> findAll(int page);
	Book findOne(Long id);
	void save(Book book);
	void delete(Long id);
	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	Page<Book> findByCategoryId(Long categoryId, int page);
	Page<Book> search(String title, int page);
}
