package com.store.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.Category;
import com.store.service.CategoryService;
import com.store.web.dto.CategoryDTO;
@Component
public class CategoryDTOToCategory implements Converter<CategoryDTO, Category> {
	
	@Autowired
	CategoryService service; 
	
	@Override
	public Category convert(CategoryDTO arg) {
		Category cat;
		if(arg.getId() == null) {
			cat = new Category();
		} else {
			cat = service.getOne(arg.getId());
		}
		cat.setDescription(arg.getDescription());
		cat.setName(arg.getName());
		return cat;
	}

}
