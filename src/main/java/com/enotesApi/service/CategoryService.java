package com.enotesApi.service;

import java.util.List;

import com.enotesApi.dto.ActiveCategoryDto;
import com.enotesApi.dto.CategoryDto;


public interface CategoryService {
	public Boolean saveCategory(CategoryDto categoryDto);
	public List<CategoryDto> getAllCategory();
	public List<ActiveCategoryDto> getActiveCategory();

}
