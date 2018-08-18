package com.store.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.service.BookService;
import com.store.service.CategoryService;
import com.store.support.BookToBookDTO;
import com.store.support.CategoryDTOToCategory;
import com.store.support.CategoryToCategorytDTO;
import com.store.web.dto.BookDTO;
import com.store.web.dto.CategoryDTO;
import com.store.model.Book;
import com.store.model.Category;
@RestController
@RequestMapping(value="/api/categories")
public class ApiCategoriesController {
	
	@Autowired
	CategoryService service;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BookToBookDTO bookToDto;
	
	@Autowired
	CategoryToCategorytDTO toDto;
	
	@Autowired
	CategoryDTOToCategory toCategory;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<CategoryDTO>> getAll(){
		List<Category> all = service.getAll();
		return new ResponseEntity<>(toDto.convert(all), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}/books")
	ResponseEntity<List<BookDTO>> getBooks(@PathVariable Long id, @RequestParam(defaultValue="0") int page){
		Page<Book> books = bookService.findByCategoryId(id, page);
		return new ResponseEntity<>(bookToDto.convert(books.getContent()), HttpStatus.OK);
	}
	

	@RequestMapping(method=RequestMethod.POST)
	ResponseEntity<CategoryDTO> add(@RequestBody CategoryDTO dto){
		Category category = toCategory.convert(dto);
		service.save(category);
		return new ResponseEntity<>(toDto.convert(category), HttpStatus.CREATED);
	}
}
