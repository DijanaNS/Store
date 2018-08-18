package com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.User;
import com.store.repository.UserRepository;
import com.store.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public User findOne(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public void save(User user) {
		repository.save(user);

	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		
		return repository.findByUsernameAndPassword(username, password);
	}

}
