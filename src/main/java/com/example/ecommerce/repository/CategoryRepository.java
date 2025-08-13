package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	//List<Category> findByName(String name);

}
