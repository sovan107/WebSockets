package com.sovanm.websocketdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sovanm.websocketdemo.entity.Product;
import com.sovanm.websocketdemo.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> products() {
		return productService.listProducts();
	}
}
