package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Category;
import com.store.repository.CategoryRepository;
import com.store.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository repository;
	@Override
	public List<Category> getAll() {
		return repository.findAll();
	}

	@Override
	public Category getOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Category category) {
		repository.save(category);

	}

}
