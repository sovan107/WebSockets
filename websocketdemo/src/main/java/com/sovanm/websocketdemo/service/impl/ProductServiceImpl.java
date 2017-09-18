package com.sovanm.websocketdemo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sovanm.websocketdemo.dto.ProductDTO;
import com.sovanm.websocketdemo.entity.Product;
import com.sovanm.websocketdemo.repository.ProductRepository;
import com.sovanm.websocketdemo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(ProductDTO product) {
		
		Product domainProduct = new Product();
		domainProduct.setName(product.getName());
		domainProduct.setCode(product.getCode());
		domainProduct.setPrice(new Double(product.getPrice()));
		domainProduct.setCreationDate(new Date());
		
		domainProduct = productRepository.save(domainProduct);
		
		return domainProduct;
	}

	@Override
	public Product saveProductByWS(ProductDTO product) {
		
		Product domainProduct = new Product();
		domainProduct.setName(product.getName());
		domainProduct.setCode(product.getCode());
		domainProduct.setPrice(new Double(product.getPrice()));
		domainProduct.setCreationDate(new Date());
		
		
		domainProduct = productRepository.save(domainProduct);
		return domainProduct;
	}

	@Override
	public List<Product> listProducts() {
		return productRepository.findAll();
	}

	@Override
	public boolean deleteProduct(int id) {
		productRepository.delete(id);
		return productRepository.findOne(id) == null;
	}

}
