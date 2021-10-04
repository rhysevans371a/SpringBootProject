package com.qa.spring.services;

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
	public List<Product> listAll() {
		return repo.findAll();
	}

//	Create
	public void create(Product product) {
		repo.save(product);
	}

//	Read
	public Product read(Long productID) {
		return this.repo.findById(productID).get();
	}
	//update 
		public Product update(Product product, Long productID) {
			Product exists = this.repo.findById(productID);
			exists.setProductName(product.getProductName());
			exists.setAisleName(product.getAisleName());
			exists.setUnitPrice(product.getUnitPrice());
			exists.setUnitSize(product.getUnitSize());
			return this.repo.saveAndFlush(exists);

		}

}
