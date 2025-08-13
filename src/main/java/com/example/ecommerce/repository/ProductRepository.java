package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Product;

// My repository will get all the functions from JpaRepository
// The first args inside <> will be your Entity name
// The second args inside <> will be your Entity data type
// The theory term is Generic (can refer to book)

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// It knows I want to open up Select * from products where name like '?'
	List<Product> findByName(String name);
	
	// It will mapped to Select * from products where price <= 100
	List<Product> findByPriceLessThan(double price);

}
