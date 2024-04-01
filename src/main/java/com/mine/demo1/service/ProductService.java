package com.mine.demo1.service;

import com.mine.demo1.model.Product;

public interface ProductService {
	Product findById(int id);
	Product updateProduct(int id, String name, String description, double price);
	
}
