package com.qa.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.spring.domain.Product;
import com.qa.spring.exceptions.ProductNotFoundException;
import com.qa.spring.repo.ProductRepository;

/**
 * @author Rhys Evans
 *
 */
@Service
public class ProductService {
	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}

//	Create instance of repository
	@Autowired
	private ProductRepository repo;

//	Read All
	public List<Product> readAll() {
		return repo.findAll();
	}

//	Create
	public Product create(Product product) {
		return repo.save(product);
	}

//	Read
	public Product read(Long productID) {
		return this.repo.findById(productID).get();
	}

	// update
	public Product update(Product product, Long productID) {
		Product exists = this.repo.findById(productID)
				.orElseThrow(() -> new ProductNotFoundException("Product with " + productID + " is Not Found!"));
		exists.setProductName(product.getProductName());
		exists.setAisleName(product.getAisleName());
		exists.setUnitPrice(product.getUnitPrice());
		exists.setUnitSize(product.getUnitSize());
		return this.repo.saveAndFlush(exists);

	}

	// delete
	public boolean delete(Long productID) {
		this.repo.deleteById(productID);
		return !this.repo.existsById(productID);
	}

	// FindbyName
	public List<Product> findByName(String name) {
		return this.repo.findByName(name);
	}
}
