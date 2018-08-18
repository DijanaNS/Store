package com.store.service;

import java.util.List;

import com.store.model.CartItem;

public interface CardItemService {
	
	CartItem findOne(Long id);
	void delete(Long id);
	void delete(CartItem item);
	void save(CartItem item);
	void save(List<CartItem> items);
}
