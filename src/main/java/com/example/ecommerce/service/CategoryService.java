package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Create
	public Category createCategory (Category category) {
		return categoryRepository.save(category);
	}
	
	// Read
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	} 
	
	// Read by ID
	public Category getCategoryById (Long id) {
		// findById return Optional<Category>
		// Safe way to indicate that the return data type can either be Category or null
		return categoryRepository.findById(id).orElseThrow(() 
				// if it is null, throw error -> we should not return error msg in controller
				-> new RuntimeException("Category not found"));
	}
	
	// Update
	public Category updateCategory(Long id, Category updatedCategory) {
		Category existing = getCategoryById(id);
        existing.setName(updatedCategory.getName());
        return categoryRepository.save(existing);
    }
	
	// Delete
	public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }

}
