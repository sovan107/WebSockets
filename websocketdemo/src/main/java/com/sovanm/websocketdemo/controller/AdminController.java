package com.sovanm.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sovanm.websocketdemo.dto.ProductDTO;
import com.sovanm.websocketdemo.entity.Product;
import com.sovanm.websocketdemo.service.ProductService;

@RestController
public class AdminController {

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/product")
	public Product saveProduct(@RequestBody ProductDTO product) {
		return productService.saveProduct(product);
	}

	@MessageMapping("/product")
	public Product saveProductByWS(ProductDTO product) {
		return productService.saveProduct(product);
	}
}
