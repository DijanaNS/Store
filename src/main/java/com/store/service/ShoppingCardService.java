package com.store.service;

import java.util.List;

import com.store.model.CartItem;
import com.store.model.ShoppingCart;

public interface ShoppingCardService {
		
	List<ShoppingCart> findAll();
	void save(ShoppingCart card);
	void addtoDB(ShoppingCart card);
	void addItem(CartItem item, ShoppingCart card);
	void deleteItem(CartItem item, ShoppingCart card);
	//ShoppingCart findOne(Long id);
	List<ShoppingCart> findByBasketId(Long basketId);
}
