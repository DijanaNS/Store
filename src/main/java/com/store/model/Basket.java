package com.store.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Basket {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy="basket")
	private List<ShoppingCart> carts;
	
	@OneToOne(mappedBy="basket")
	private User user;
	
	@OneToMany(mappedBy="basket")
	private List<CartItem> items;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ShoppingCart> getCarts() {
		return carts;
	}
	public void setCarts(List<ShoppingCart> carts) {
		this.carts = carts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	
}
