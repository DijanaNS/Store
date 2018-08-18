package com.store.service;

import com.store.model.User;

public interface UserService {
	
	User findOne(Long id);
	void save(User user);
	User findByUsernameAndPassword(String username, String password);
}
