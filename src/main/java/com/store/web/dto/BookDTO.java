package com.store.web.dto;

import org.hibernate.validator.constraints.NotBlank;

public class BookDTO {
	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	private String publisher;
	private Integer year;
	private Integer pagesNumber;
	private Integer price;
	private String format;
	@NotBlank
	private String isbn;
	private String imageUrl;
	private Long categoryId;
	private String categoryName;
	@NotBlank
	private Integer count;
	private String description;
	private String smallDescription;
	private Integer imgNumber;
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
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getImgNumber() {
		return imgNumber;
	}
	public void setImgNumber(Integer imgNumber) {
		this.imgNumber = imgNumber;
	}
	public String getSmallDescription() {
		return smallDescription;
	}
	public void setSmallDescription(String description) {
		String[] part = description.split("\\.");
		if(part.length >= 1)
			this.smallDescription = part[0] + ".";
		else
			this.smallDescription = description;
	}
	
	
}
