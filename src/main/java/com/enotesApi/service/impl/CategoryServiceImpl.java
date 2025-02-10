package com.enotesApi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotesApi.entity.Category;
import com.enotesApi.repository.CategoryRepo;
import com.enotesApi.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setIsActive(true);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category saveCategory = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}else {
		return true;
		}
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		return categories;
	}

}
