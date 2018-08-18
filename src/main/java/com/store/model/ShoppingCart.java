package com.store.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class ShoppingCart {
	@Id
	@GeneratedValue
	private Long id;
	private Date orderingDate = new Date();
	private Date deliveryDate;
	private Integer totalPrice;
	private String status;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy="card")
	private List<CartItem> items = new ArrayList<>();
	@ManyToOne
	private Basket basket;
	
	public ShoppingCart() {
		this.totalPrice = 0;
		this.status = "pending";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderingDate() {
		return orderingDate;
	}
	public void setOrderingDate(Date orderingDate) {
		this.orderingDate = orderingDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
		if(!user.getCards().contains(this))
			user.getCards().add(this);
	}
	public List<CartItem> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}
	
	public Integer calculatePrice() {
		Integer total = 0;
		for(int i = 0; i < items.size(); i++) {
			total += (items.get(i).getBook().getPrice() * items.get(i).getCount());
		}
		return total;
	}
	
	public void addItem(CartItem item) {
		this.items.add(item);
		item.setCard(this);
		this.totalPrice = calculatePrice();
	}
	
	public void removeItem(CartItem item) {
		this.items.remove(item);
		if(item.getCard().equals(this))
			item.setCard(null);
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
		if(!basket.getCarts().contains(this))
			basket.getCarts().add(this);
	}
	@Override
	public String toString() {
		return "ShoppingCart [orderingDate=" + orderingDate + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", user=" + user.getId() + ", basket=" + basket.getId() + "]";
	}
	
	
	
	
}
