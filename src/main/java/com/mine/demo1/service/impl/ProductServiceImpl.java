package com.mine.demo1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mine.demo1.model.Product;
import com.mine.demo1.repo.ProductRepo;
import com.mine.demo1.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	
	@Override
	public Product findById(int id) {
		Optional<Product> iproduct = productRepo.findById(id);
		
		if(!iproduct.isEmpty())
			return iproduct.get();
		else
			return null;
	}

	@Override
	public Product updateProduct(int id, String name, String description, double price) {
		Product product = productRepo.findById(id).get();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		
		Product savedEntity = productRepo.save(product);
		

		return savedEntity;
	}

	
	
}
