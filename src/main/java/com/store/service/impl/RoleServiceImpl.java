package com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Role;
import com.store.repository.RoleRepository;
import com.store.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository rep;
	
	@Override
	public Role findOne(Long id) {
		return rep.findOne(id);
	}

	@Override
	public void save(Role role) {
		rep.save(role);

	}

}
