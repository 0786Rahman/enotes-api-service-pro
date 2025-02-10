package com.enotesApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotesApi.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
