package com.store.service;

import java.util.List;

import com.store.model.Category;

public interface CategoryService {
	List<Category> getAll();
	Category getOne(Long id);
	void save(Category category);
}
