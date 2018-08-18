package com.store.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.CartItem;
import com.store.service.BasketService;
import com.store.service.BookService;
import com.store.service.ShoppingCardService;
import com.store.web.dto.CardItemDTO;
@Component
public class CardDTOToCard implements Converter<CardItemDTO, CartItem> {

	@Autowired
	BookService service;
	
	@Autowired
	ShoppingCardService shopping;
	
	@Autowired
	BasketService basket;
	@Override
	public CartItem convert(CardItemDTO arg) {
		CartItem card = new CartItem();
		card.setCount(arg.getCount());
		card.setBook(service.findOne(arg.getBookId()));
		card.setBasket(basket.findOne(arg.getBasketId()));
		return card;
	}

}
