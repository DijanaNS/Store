package com.store.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class CartItem {
	@Id
	@GeneratedValue
	private Long id;
	private Integer count;
	@ManyToOne
	private Book book;
	@ManyToOne(fetch=FetchType.EAGER)
	private ShoppingCart card;
	@ManyToOne
	private Basket basket;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
		if(!book.getItems().contains(this)) {
			book.getItems().add(this);
		}
	}
	public ShoppingCart getCard() {
		return card;
	}
	public void setCard(ShoppingCart card) {
		this.card = card;
		if(!card.getItems().contains(this)) {
			card.getItems().add(this);
		}
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	@Override
	public String toString() {
		return "CartItem [count=" + count + ", book=" + book.getId() + ", basket=" + basket.getId() + "]";
	}
	
	
	
}
