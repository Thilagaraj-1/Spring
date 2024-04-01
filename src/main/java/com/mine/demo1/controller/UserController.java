package com.mine.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mine.demo1.dto.UserDto;
import com.mine.demo1.model.Product;
import com.mine.demo1.model.User;
import com.mine.demo1.repo.UserRepo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/set")
	public ResponseEntity<?> setUser(@RequestBody User u){
		User user = userRepo.save(u);
		return ResponseEntity.status(HttpStatus.OK)
				.body(user);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id){
		User user = userRepo.findById(id).get();
		UserDto ud = new UserDto(user.getName(), user.getEmail(), user.getAddress());
		return ResponseEntity.status(HttpStatus.OK)
				.body(ud);
				
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		
		User user = userRepo.findById(id).get();
		userRepo.delete(user);
		
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(user);
}

}
