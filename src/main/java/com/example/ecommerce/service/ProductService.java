package com.example.ecommerce.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;

	
	// Create
	/*public Product createProduct (Product product) {
		return productRepository.save(product);
	}*/
	//
	public Product createProduct (Product product, Long categoryId, List<Long> tagIds) {
		// When create a new product, will get the category from categoryId
		product.setCategory(categoryService.getCategoryById(categoryId));
		
		// When create  a new product, will get the tags from tagIds
		// and set it to the product
		// transform it to SEt (to ensure no repeated tags)
		product.setTags(Set.copyOf(tagService.getByIds(tagIds)));
		return productRepository.save(product);
	}
	
	// Read
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

	// Read by ID
	public Product getProductById (Long Id) {
		return productRepository.findById(Id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	// Update
	public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existing);
    }

	
	// Delete
	public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }


}
