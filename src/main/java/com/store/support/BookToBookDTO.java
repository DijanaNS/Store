package com.store.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.Book;
import com.store.web.dto.BookDTO;
@Component
public class BookToBookDTO implements Converter<Book, BookDTO> {

	@Override
	public BookDTO convert(Book book) {
		BookDTO dto = new BookDTO();
		dto.setId(book.getId());
		dto.setAuthor(book.getAuthor());
		dto.setCategoryId(book.getCategory().getId());
		dto.setCategoryName(book.getCategory().getName());
		dto.setFormat(book.getFormat());
		dto.setImageUrl("/app/images/covers/" + book.getImgNumber() + ".png");
		dto.setIsbn(book.getIsbn());
		dto.setPagesNumber(book.getPagesNumber());
		dto.setPrice(book.getPrice());
		dto.setPublisher(book.getPublisher());
		dto.setTitle(book.getTitle());
		dto.setYear(book.getYear());
		dto.setCount(book.getCount());
		dto.setDescription(book.getDescription());
		dto.setSmallDescription(book.getDescription());
		return dto;
	}
	
	public List<BookDTO> convert(List<Book> books){
		List<BookDTO> dtos = new ArrayList<>();
		for(Book book: books) {
			dtos.add(convert(book));
		}
		return dtos;
	}

}
