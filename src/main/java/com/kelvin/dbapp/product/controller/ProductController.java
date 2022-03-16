package com.kelvin.dbapp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.dbapp.product.model.Product;
import com.kelvin.dbapp.product.serive.ProductService;


@Controller
public class ProductController {

	@Autowired
    private ProductService productService;
	
 	//product - page
	@GetMapping("/productpage")
	public String page(Model model){
		List<Product> productList = productService.findAll();
		model.addAttribute("product",productList);		
		return "main/productpage";
	}
	
	
 	//find all
	@GetMapping("/product")
	public String getAll(Model model){
		List<Product> productList = productService.findAll();
		model.addAttribute("product",productList);		
		return "product/productList";
	}
	
    //Return web page
	@GetMapping("/productAdd")
	public String addProduct() {
	return "product/productAdd";
	}
	
	//Return page n get byId for UPDATE
	@GetMapping("/productEdit/{id}")
	public String EditProduct(@PathVariable Integer id, Model model) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
	return "product/productEdit";
	}
	
	//Return Detail page 
	@GetMapping("/productDetail/{id}")
	public String DetailProduct(@PathVariable Integer id, Model model) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
	return "product/productDetail";
	}
	
	//ADD NEW
	@PostMapping("/product")
		public String save(Product product) {
			productService.save(product);
			return "redirect:/product";	
	}
	//DELETE
	@RequestMapping (value="/product/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "redirect:/product";	
	}
	
	//UPDATE
	@RequestMapping (value="/product/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Product product) {
		productService.save(product);
		return "redirect:/product";	
	}
	
}
