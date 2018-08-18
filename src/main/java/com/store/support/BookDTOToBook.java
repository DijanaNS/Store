package com.store.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.Book;
import com.store.service.BookService;
import com.store.service.CategoryService;
import com.store.web.dto.BookDTO;
@Component
public class BookDTOToBook implements Converter<BookDTO, Book> {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	public Book convert(BookDTO dto) {
		Book book;
		if(dto.getId() == null) {
			book = new Book();
			book.setCategory(categoryService.getOne(dto.getCategoryId()));
		} else {
			book = bookService.findOne(dto.getId());
			if(book == null)
				throw new IllegalArgumentException("Nepostojeci ID");
		}
		book.setAuthor(dto.getAuthor());
		book.setFormat(dto.getFormat());
		book.setImgNumber(dto.getImgNumber());
		book.setIsbn(dto.getIsbn());
		book.setPagesNumber(dto.getPagesNumber());
		book.setPrice(dto.getPrice());
		book.setPublisher(dto.getPublisher());
		book.setTitle(dto.getTitle());
		book.setYear(dto.getYear());
		book.setCount(dto.getCount());
		book.setDescription(dto.getDescription());
		return book;
	}

}
