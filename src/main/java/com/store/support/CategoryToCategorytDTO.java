package com.store.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.model.Category;
import com.store.web.dto.CategoryDTO;
@Component
public class CategoryToCategorytDTO implements Converter<Category, CategoryDTO> {

	@Override
	public CategoryDTO convert(Category arg) {
		CategoryDTO dto = new CategoryDTO();
		dto.setDescription(arg.getDescription());
		dto.setId(arg.getId());
		dto.setName(arg.getName());
		return dto;
	}
	
	public List<CategoryDTO> convert(List<Category> args) {
		List<CategoryDTO> dtos = new ArrayList<>();
		for(Category arg: args) {
			dtos.add(convert(arg));
		}
		return dtos;
	}
}
