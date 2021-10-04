package com.qa.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.spring.domain.Product;
import com.qa.spring.services.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/Read")
	public ResponseEntity <List<Product>> readAll() {
		return new ResponseEntity <List<Product>> (this.service.readAll(),HttpStatus.OK);
	}
	// create
	@PostMapping("/create")
	public ResponseEntity <Product> create(@RequestBody Product product) {
		return new ResponseEntity <Product> (this.service.create(product),HttpStatus.CREATED);
	}
	//Read ID
	@GetMapping("/read/{productID}")
	public ResponseEntity<Product> read(@PathVariable Long productID) {
		return new ResponseEntity <Product>(this.service.read(productID),HttpStatus.OK);
	}
}
