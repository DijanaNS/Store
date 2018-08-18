package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.CartItem;
import com.store.repository.CartItemRepository;
import com.store.service.CardItemService;
@Service
public class CardItemImpl implements CardItemService {
	
	@Autowired
	CartItemRepository repository;
	
	@Override
	public CartItem findOne(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void delete(CartItem item) {
		repository.delete(item);

	}

	@Override
	public void save(CartItem item) {
		repository.save(item);

	}

	@Override
	public void save(List<CartItem> items) {
		repository.save(items);
		
	}

}
