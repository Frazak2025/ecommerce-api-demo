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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//Create product using this url POST localhost:8080/api/products?categoryId=1&tagIds=1,2
	//Get all products or get product by id = localhost:8080/api/products
	// get all categories, or get category by id localhost:8080/api/categories
	@PostMapping
	public Product addProduct(@RequestBody Product product, @RequestParam Long categoryId, @RequestParam List<Long> tagIds) {
		// Now to create a new product have to specify the category ID - DTO
		// Temporarily use RequestPram
		// Best practice use proper DTO
		return productService.createProduct(product, categoryId, tagIds);
	}
	
	@GetMapping
	public  List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	// Get by ID
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	// Update
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
		return productService.updateProduct(id, updatedProduct);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}
