package com.enotesApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotesApi.entity.Category;
import com.enotesApi.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
		Boolean saveCategory = this.categoryService.saveCategory(category);
		if(saveCategory) {
			return new ResponseEntity<>("Save successfully Category",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Not Save successfully Category",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping
	public ResponseEntity<?> getAllCategory(){
		List<Category> allCategory = this.categoryService.getAllCategory();
		if(CollectionUtils.isEmpty(allCategory)) {
			return ResponseEntity.noContent().build();
		}else {
			return new ResponseEntity<>(allCategory,HttpStatus.OK);
		}
	}
}
