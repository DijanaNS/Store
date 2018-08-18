package com.store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

import com.store.model.Book;
import com.store.model.User;
import com.store.service.BookService;
import com.store.support.BookDTOToBook;
import com.store.support.BookToBookDTO;
import com.store.web.dto.BookDTO;

@RestController
@RequestMapping(value="/api/books")
public class ApiBooksController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BookToBookDTO toDto;
	
	@Autowired
	BookDTOToBook toBook;
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getAll(@RequestParam(required=false) String title, 
			@RequestParam(required=false) Long id,
			@RequestParam(defaultValue="0") int page){
		System.out.println(id);
		Page<Book> allBooks;
		if(title != null) {
			allBooks = bookService.search(title, page);
		} else if(id != null) {
			allBooks = bookService.findByCategoryId(id, page);
		}else {
			allBooks = bookService.findAll(page);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(allBooks.getTotalPages()));
		return new ResponseEntity<>(toDto.convert(allBooks.getContent()),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	ResponseEntity<BookDTO> getOne(@PathVariable Long id){
		Book book = bookService.findOne(id);
		if(book == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(toDto.convert(book), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	ResponseEntity<BookDTO> edit(HttpServletRequest request, @PathVariable Long id, @RequestBody BookDTO dto){
		User user = (User) request.getSession(false).getAttribute("user");
		if(!user.getRole().getId().equals(2l))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		if(!id.equals(dto.getId()))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Book book = toBook.convert(dto);
		bookService.save(book);
		return new ResponseEntity<>(toDto.convert(book), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	ResponseEntity<BookDTO> delete(@PathVariable Long id){
		
		if(bookService.findOne(id) == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		bookService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	ResponseEntity<BookDTO> add( @Validated @RequestBody BookDTO dto){
		Book book = toBook.convert(dto);
		bookService.save(book);
		return new ResponseEntity<>(toDto.convert(book), HttpStatus.CREATED);
	}
}
