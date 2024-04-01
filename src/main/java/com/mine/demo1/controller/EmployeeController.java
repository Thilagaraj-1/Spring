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

import com.mine.demo1.model.Employee;
import com.mine.demo1.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepo er;
	
	@PostMapping("/set")
	public ResponseEntity<?> setEmployee(@RequestBody Employee e){
		Employee employee = er.saveAndFlush(e);
		return ResponseEntity.status(HttpStatus.OK)
				.body(employee);
	}
	
	@GetMapping("/get/{eId}")
	public ResponseEntity<?> getEmployee(@PathVariable int eId){
		Employee employee = er.findById(eId).get();
		return ResponseEntity.status(HttpStatus.OK)
				.body(employee);
	}
	
}

