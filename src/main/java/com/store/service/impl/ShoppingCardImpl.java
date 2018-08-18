package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.CartItem;
import com.store.model.ShoppingCart;
import com.store.repository.CartItemRepository;
import com.store.repository.ShoppingCartRepository;
import com.store.service.ShoppingCardService;
@Service
public class ShoppingCardImpl implements ShoppingCardService {
	
	@Autowired
	ShoppingCartRepository repository;
	
	@Autowired
	CartItemRepository cardRep;
	
	@Override
	public List<ShoppingCart> findAll() {
		
		return repository.findAll();
	}

	@Override
	public void save(ShoppingCart card) {
		repository.save(card);
		cardRep.save(card.getItems());

	}

	@Override
	public void addItem(CartItem item, ShoppingCart card) {
		card.addItem(item);

	}

	@Override
	public void deleteItem(CartItem item, ShoppingCart card) {
		card.removeItem(item);
		
	}

	@Override
	public List<ShoppingCart> findByBasketId(Long basketId) {
		
		return repository.findByBasketId(basketId);
	}

	@Override
	public void addtoDB(ShoppingCart cart) {
		repository.save(cart);
		
	}

}
