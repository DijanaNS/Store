package com.store.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.User;

import com.store.web.dto.UserDTO;
@Component
public class UserToUserDTO implements Converter<User, UserDTO> {
	
	@Override
	public UserDTO convert(User arg) {
		UserDTO dto = new UserDTO();
		dto.setEmail(arg.getEmail());
		dto.setFirstName(arg.getFirstName());
		dto.setLastName(arg.getLastName());
		dto.setPassword(arg.getPassword());
		dto.setRoleId(arg.getRole().getId());
		dto.setUsername(arg.getUsername());
		dto.setId(arg.getId());
		dto.setBasketId(arg.getBasket().getId());
		return dto;
	}

}
