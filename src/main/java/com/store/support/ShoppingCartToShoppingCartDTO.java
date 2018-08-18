package com.store.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.ShoppingCart;
import com.store.web.dto.ShoppingCardDTO;
@Component
public class ShoppingCartToShoppingCartDTO implements Converter<ShoppingCart, ShoppingCardDTO> {
	
	@Override
	public ShoppingCardDTO convert(ShoppingCart arg) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ShoppingCardDTO dto = new ShoppingCardDTO();
		dto.setOrderingDate(dateFormat.format(new Date()));
		dto.setStatus("pending");
		dto.setTotalPrice(arg.calculatePrice());
		return dto;
	}

}
