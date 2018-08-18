package com.store.service;

import com.store.model.Role;

public interface RoleService {
	Role findOne(Long id);
	void save(Role role);
}
