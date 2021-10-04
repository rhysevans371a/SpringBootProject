package com.qa.spring.services;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.spring.domain.Product;

import com.qa.spring.repo.ProductRepository;

/**
 * @author Rhys Evans
 *
 */
@Service
public class ProductService {
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
	//update 
		public Product update(Product product, Long productID) {
			Product exists = this.repo.findById(productID).get();
			exists.setProductName(product.getProductName());
			exists.setAisleName(product.getAisleName());
			exists.setUnitPrice(product.getUnitPrice());
			exists.setUnitSize(product.getUnitSize());
			return this.repo.saveAndFlush(exists);

		}
		
		//delete
		public boolean delete(Long id) throws FileNotFoundException {
			if (!this.repo.existsById(id)) {
				throw new FileNotFoundException();
			}
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
		}
}
