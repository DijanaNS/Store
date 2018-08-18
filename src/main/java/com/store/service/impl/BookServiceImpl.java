package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.store.model.Book;
import com.store.repository.BookRepository;
import com.store.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository repository;
	
	@Override
	public Page<Book> findAll(int page) {
		return repository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Book findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Book book) {
		repository.save(book);

	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public List<Book> findByTitle(String title) {
		
		return repository.findByTitle(title);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		
		return repository.findByAuthor(author);
	}

	@Override
	public Page<Book> findByCategoryId(Long categoryId, int page) {
		
		return repository.findByCategoryId(categoryId, new PageRequest(page, 6));
	}

	@Override
	public Page<Book> search(String title, int page) {
		String param = "%" + title + "%";
		return repository.search(param, new PageRequest(page, 6));
	}

}
