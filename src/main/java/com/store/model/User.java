package com.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false, unique=true)
	@Email
	private String email;
	@Column(nullable=false)
	private String password;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy="user")
	private List<Address> addresses = new ArrayList<>();
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;
	@OneToMany(mappedBy="user")
	private List<ShoppingCart> cards = new ArrayList<>();
	
	@OneToOne
	@JoinColumn
	private Basket basket;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
		if(!role.getUsers().contains(this))
			role.getUsers().add(this);
	}
	public List<ShoppingCart> getCards() {
		return cards;
	}
	public void setCards(ArrayList<ShoppingCart> cards) {
		this.cards = cards;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	
	
	
}
