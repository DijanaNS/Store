package com.store.service;

import com.store.model.Basket;

public interface BasketService {
	
	void save(Basket basket);
	Basket findOne(Long id);
}
