package com.sovanm.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// websocket.convertAndSend("/topic/new-product", savedProduct);
	@PostMapping("/product")
	public Product saveProduct(@RequestBody ProductDTO product) {

		Product savedProduct = productService.saveProduct(product);
		return savedProduct;
	}

	@DeleteMapping("/product/{id}")
	public Boolean deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return true;
	}

	@SendTo("/topic/delete-product")
	@MessageMapping("/delete-product")
	public int deleteProductByWS(int id) {
		
		if (productService.deleteProduct(id)) {
			return id;
		} else {
			return -1;
		}
	}

	@SendTo("/topic/new-product")
	@MessageMapping("/save-product")
	public Product saveProductByWS(ProductDTO product) {
		return productService.saveProductByWS(product);
	}
}
