package com.sovanm.websocketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sovanm.websocketdemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
