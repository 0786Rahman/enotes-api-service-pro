package com.enotesApi.service;

import java.util.List;
import com.enotesApi.entity.Category;

public interface CategoryService {
	public Boolean saveCategory(Category category);
	public List<Category> getAllCategory();

}
