package com.kelvin.dbapp.product.serive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.product.model.Product;
import com.kelvin.dbapp.product.repository.ProductRepository;

@Service
public class ProductService {

@Autowired ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public void save(Product product) {
		
		productRepository.save(product);	
	}
	
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Product getById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}
	
}
