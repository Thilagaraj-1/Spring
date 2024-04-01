package com.mine.demo1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mine.demo1.model.Product;
import com.mine.demo1.repo.ProductRepo;
import com.mine.demo1.service.ProductService;

@RestController
@RequestMapping("/demo1")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("/set")
//	public ResponseEntity<?> setProduct(@RequestParam int id,@RequestParam String name,@RequestParam String description,@RequestParam String price){
//	public ResponseEntity<?> setProduct(@RequestParam String name,@RequestParam String description,@RequestParam double price){
	public ResponseEntity<?> setProduct(@RequestBody Product product){
////		System.out.println("The id is " + id);
//		System.out.println("The name is " + name);
//		System.out.println("The description is " + description);
//		System.out.println("The price is " + price);
//		
//		Product product = new Product();
////		product.setId(id);
//		product.setName(name);
//		product.setDescription(description);
//		product.setPrice(price);
		
		Product savedEntity = productRepo.saveAndFlush(product);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(savedEntity);
	}
	@GetMapping("/delete")
	public ResponseEntity<?> deleteProduct(@RequestParam int id){
		Product product = productRepo.findById(id).get();
		productRepo.delete(product);
		//		Product deleteEnity = productRepo.delete(product);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("data deleted");
	}
	@GetMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestParam int id,@RequestParam String name,@RequestParam String description, double price){
		
		Product product = productService.updateProduct(id, name, description, price);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(product);
		
//		Product product = productRepo.findById(id).get();
//		product.setName(name);
//		product.setDescription(description);
//		product.setPrice(price);
//		
//		Product savedEntity = productRepo.save(product);
//		
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(savedEntity);
	}
	@GetMapping("/findByPrice")
	public ResponseEntity<?> findByPrice(@RequestParam double price){
		List<Product> pprice = productRepo.findByPrice(price);
		return ResponseEntity.status(HttpStatus.OK)
				.body(pprice);
	}
	@GetMapping("/findBetweenPrice")
	public ResponseEntity<?> findBetweenPrice(@RequestParam double p1,@RequestParam double p2){
		List<Product> pbprice = productRepo.findBetweenPrice(p1, p2);
		return ResponseEntity.status(HttpStatus.OK)
				.body(pbprice);
	}
	@GetMapping("/findByName")
	public ResponseEntity<?> findByName(@RequestParam String name){
		List<Product> pname = productRepo.findByName(name);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body( pname );
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		
		Product product = productService.findById(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(product);
		
//		Optional <Product> oProduct = productRepo.findById(id);
//		if(oProduct.isPresent()) {
//			return ResponseEntity	
//					.status(HttpStatus.OK)
//					.body(oProduct.get());
//		}else {
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(null);
//		}
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getProduct() {
//		Product p1 = new Product();
//		p1.setId(1);
//		p1.setName("Led TV");
//		p1.setDescription("Sony");
//		p1.setPrice("17,000.09");
//		
//		
//		Product p2 = new Product();
//		p2.setId(2);
//		p2.setName("Refrigerator");
//		p2.setDescription("WhirlPool");
//		p2.setPrice("9,010.23");
//		
//		
//		Product p3 = new Product();
//		p3.setId(3);
//		p3.setName("Table Fan");
//		p3.setDescription("Genelix");
//		p3.setPrice("2,113.43");
		
		Product p1 = new Product(1,"Led Tv","Sony",17000.09);
		Product p2 = new Product(2,"Refrigerator","WhirlPool",9010.23);
		Product p3 = new Product(3,"Table Fan","Genelix",2113.4);
		
		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		return ResponseEntity.status(HttpStatus.OK)
		.body(list);
	}
	
	
	
	
}
