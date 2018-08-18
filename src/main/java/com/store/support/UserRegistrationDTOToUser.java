package com.store.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.User;
import com.store.service.RoleService;
import com.store.web.dto.UserRegistrationDTO;
@Component
public class UserRegistrationDTOToUser implements Converter<UserRegistrationDTO, User> {
	
	@Autowired
	RoleService roleService;
	@Override
	public User convert(UserRegistrationDTO arg) {
		User user = new User();
		if(!arg.getPassword().equals(arg.getPasswordConfirmation()))
			return null;
		user.setUsername(arg.getUsername());
		user.setPassword(arg.getPassword());
		user.setEmail(arg.getEmail());
		user.setRole(roleService.findOne(1l)); 
		return user;
	}

}
