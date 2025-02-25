package com.enotesApi.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotesApi.dto.ActiveCategoryDto;
import com.enotesApi.dto.CategoryDto;
import com.enotesApi.entity.Category;
import com.enotesApi.repository.CategoryRepo;
import com.enotesApi.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {
		Category category = mapper.map(categoryDto, Category.class);		
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
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtoList = categories.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
		return categoryDtoList;
	}

	@Override
	public List<ActiveCategoryDto> getActiveCategory() {
		List<Category> activeCategories =this.categoryRepo.findByIsActiveTrue();
		List<ActiveCategoryDto> activeCategoryDtoList =activeCategories.stream().map(cat->mapper.map(cat, ActiveCategoryDto.class)).toList();		
		return activeCategoryDtoList;
	}

}
