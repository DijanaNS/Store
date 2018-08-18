package com.store.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.User;
import com.store.service.UserService;
import com.store.web.dto.UserDTO;
@Component
public class UserDTOToUser implements Converter<UserDTO, User> {
	
	@Autowired
	UserService service;
	@Override
	public User convert(UserDTO arg) {
		User user = service.findOne(arg.getId());
		user.setEmail(arg.getEmail());
		user.setFirstName(arg.getFirstName());
		user.setLastName(arg.getLastName());
		user.setPassword(arg.getPassword());
		user.setUsername(arg.getUsername());
		return user;
	}

}
