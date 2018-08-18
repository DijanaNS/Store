package com.store.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Basket;
import com.store.model.ShoppingCart;
import com.store.model.User;
import com.store.service.BasketService;
import com.store.service.ShoppingCardService;
import com.store.service.UserService;
import com.store.support.UserDTOToUser;
import com.store.support.UserRegistrationDTOToUser;
import com.store.support.UserToUserDTO;
import com.store.web.dto.UserDTO;
import com.store.web.dto.UserRegistrationDTO;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value="/api/users")
public class ApiUsersController {
	
	@Autowired
	UserService service;
	
	@Autowired
	UserRegistrationDTOToUser toUser;
	
	@Autowired
	UserDTOToUser dtoToUser;
	
	@Autowired
	UserToUserDTO toDto;
	
	@Autowired
	BasketService basketService;
	
	@Autowired
	ShoppingCardService scService;
	
	@RequestMapping(method=RequestMethod.GET, value="/saved")
	ResponseEntity<UserDTO> getUser(HttpServletRequest request){
		
		if(request.getSession().getAttribute("user") == null)
			return new ResponseEntity<>(HttpStatus.OK);
		User user = (User) request.getSession(false).getAttribute("user");
		System.out.println(user);
		return new ResponseEntity<>(toDto.convert(user), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	ResponseEntity<UserDTO> edit(@PathVariable Long id, @RequestBody UserDTO dto){
		
		if(!id.equals(dto.getId()))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		User user = dtoToUser.convert(dto);
		service.save(user);
		return new ResponseEntity<>(toDto.convert(user), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	ResponseEntity<UserDTO> add(@Validated @RequestBody UserRegistrationDTO dto){
		User user = toUser.convert(dto);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Basket basket = new Basket();
		basketService.save(basket);
		user.setBasket(basket);
		basket.setUser(user);
		service.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.POST, value="/login")
	ResponseEntity<UserDTO> login(HttpServletRequest request, @RequestBody UserDTO dto){
		User user = service.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		System.out.println(user);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
//		HttpSession session = request.getSession();
//		session.setAttribute("user", user);
		ShoppingCart cart = new ShoppingCart();
		cart.setBasket(user.getBasket());
		cart.setUser(user);
		cart.setItems(new ArrayList<>());
		HttpSession session = request.getSession();
		session.setAttribute("cart", cart);
		System.out.println(cart + " hello");
		return new ResponseEntity<>(toDto.convert(user), HttpStatus.OK);
	}
}
