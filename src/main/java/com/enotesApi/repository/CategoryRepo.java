package com.enotesApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotesApi.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrue();

}
