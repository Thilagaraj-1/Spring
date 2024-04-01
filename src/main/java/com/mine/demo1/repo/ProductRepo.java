package com.mine.demo1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mine.demo1.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM PRODUCTS WHERE price <= :price", nativeQuery = true)
	List<Product> findByPrice(double price);
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE PRICE >= :p1 AND PRICE <= :p2", nativeQuery = true)
	List<Product> findBetweenPrice(double p1, double p2);
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE name = :name ", nativeQuery = true)
	List<Product> findByName(String name);
}
