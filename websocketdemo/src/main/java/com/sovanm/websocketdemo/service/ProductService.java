package com.sovanm.websocketdemo.service;

import java.util.List;

import com.sovanm.websocketdemo.dto.ProductDTO;
import com.sovanm.websocketdemo.entity.Product;

public interface ProductService {

	Product saveProduct(ProductDTO product);
	Product saveProductByWS(ProductDTO product);
	List<Product> listProducts();
}
