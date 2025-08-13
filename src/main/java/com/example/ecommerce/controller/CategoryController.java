package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	// Create 
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	// Get all
	@GetMapping
	public  List<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	// Get by ID
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	// Update
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
		return categoryService.updateCategory(id, updatedCategory);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}

}
