package com.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String author;
	private String publisher;
	private Integer year;
	private Integer pagesNumber;
	private Integer price;
	private String format;
	private String isbn;
	private Integer imgNumber;
	@Column(length=1000)
	private String description;
	@Min(0)
	private Integer count;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy="book")
	private List<CartItem> items = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getPagesNumber() {
		return pagesNumber;
	}
	public void setPagesNumber(Integer pagesNumber) {
		this.pagesNumber = pagesNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getImgNumber() {
		return imgNumber;
	}
	public void setImgNumber(Integer imgNumber) {
		this.imgNumber = imgNumber;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
		if(!category.getBooks().contains(this)) {
			category.getBooks().add(this);
		}
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
