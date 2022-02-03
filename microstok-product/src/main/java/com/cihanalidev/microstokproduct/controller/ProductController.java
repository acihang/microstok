package com.cihanalidev.microstokproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cihanalidev.microstokproduct.service.ProductService;
import com.cihanalidev.microstokproduct.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/1.0/buyProduct")
	public String buyProduct(@RequestBody Product product) {
		productService.buyProduct(product);
		return "Success";
	}
	
}
