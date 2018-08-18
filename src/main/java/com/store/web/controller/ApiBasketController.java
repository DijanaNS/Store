package com.store.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.CartItem;
import com.store.model.ShoppingCart;
import com.store.service.ShoppingCardService;
import com.store.support.CardDTOToCard;
import com.store.support.CartToCartDTO;
import com.store.support.ShoppingCartToShoppingCartDTO;
import com.store.web.dto.CardItemDTO;
import com.store.web.dto.ShoppingCardDTO;

@RestController
@RequestMapping(value="/api/baskets")
public class ApiBasketController {
	
	@Autowired
	CardDTOToCard toCart;
	@Autowired
	CartToCartDTO toDto;
	@Autowired
	ShoppingCardService shoppingService;
	@Autowired
	ShoppingCartToShoppingCartDTO toCartDTO;
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	ResponseEntity<CardItemDTO> addItem(HttpServletRequest request, @RequestBody CardItemDTO dto){
		CartItem item = toCart.convert(dto);
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		System.out.println(shoppingCart + "add");
		shoppingCart.addItem(item);
		for(int i = 0; i < shoppingCart.getItems().size(); i++) {
			System.out.println(shoppingCart.getItems().get(i));
		}
		request.getSession().setAttribute("cart", shoppingCart);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/cartItems")
	ResponseEntity<List<CardItemDTO>> getAll(HttpServletRequest request){
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		System.out.println(shoppingCart + "cartItem");
		//System.out.println(shoppingCart.getItems().size());
		List<CartItem> all = shoppingCart.getItems();
		return new ResponseEntity<>(toDto.convert(all), HttpStatus.OK);
	}
//	@RequestMapping("/removeItem")
//	@RequestMapping("/updateCartItem")
	@RequestMapping(method=RequestMethod.GET, value="/shopping")
	ResponseEntity<ShoppingCardDTO> getCart(HttpServletRequest request){
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		System.out.println(shoppingCart + "shopping");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String ord = dateFormat.format(new Date());
		String status = "pending";
		//ShoppingCardDTO dto = toCartDTO.convert(shoppingCart);
		ShoppingCardDTO dto = new ShoppingCardDTO();
		dto.setOrderingDate(ord);
		dto.setStatus(status);
		dto.setTotalPrice(shoppingCart.getTotalPrice()); 
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/save")
	ResponseEntity<ShoppingCardDTO> save(HttpServletRequest request){
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		shoppingService.save(shoppingCart);
		ShoppingCart newShopping = new ShoppingCart();
		newShopping.setBasket(shoppingCart.getBasket());
		newShopping.setUser(shoppingCart.getUser());
		request.getSession().setAttribute("cart", newShopping);
		System.out.println(request.getSession().getAttribute("cart"));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
