package com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Basket;
import com.store.repository.BasketRepository;
import com.store.service.BasketService;
@Service
public class BasketImpl implements BasketService {
	
	@Autowired
	BasketRepository rep;
	@Override
	public void save(Basket basket) {
		rep.save(basket);

	}

	@Override
	public Basket findOne(Long id) {
		return rep.findOne(id);

	}

}
