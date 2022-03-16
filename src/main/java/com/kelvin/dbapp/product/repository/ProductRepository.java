package com.kelvin.dbapp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelvin.dbapp.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	

	
}