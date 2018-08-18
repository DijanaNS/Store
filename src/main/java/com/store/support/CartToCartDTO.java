package com.store.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.CartItem;
import com.store.web.dto.CardItemDTO;
@Component
public class CartToCartDTO implements Converter<CartItem, CardItemDTO> {

	@Override
	public CardItemDTO convert(CartItem arg) {
		CardItemDTO dto = new CardItemDTO();
		dto.setBasketId(arg.getBasket().getId());
		dto.setBookId(arg.getBook().getId());
		dto.setCount(arg.getCount());
		dto.setBookName(arg.getBook().getTitle() + " " + arg.getBook().getAuthor());
		dto.setPrice(arg.getBook().getPrice());
		return dto;
	}
	
	public List<CardItemDTO> convert(List<CartItem> args){
		List<CardItemDTO> list = new ArrayList<>();
		for(CartItem arg: args) {
			list.add(convert(arg));
		}
		return list;
	}

}
