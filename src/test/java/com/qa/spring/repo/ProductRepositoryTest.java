package com.qa.spring.repo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.qa.spring.domain.Product;

import nl.jqno.equalsverifier.internal.util.Assert;

@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;


	@Test
	public void saveTest() {
		Product product = new Product("Apple", "Fruit", "each", 0.50);
		repository.save(product);
		Assert.assertEquals(null, repository.findByName("Apple"), product);
	}

}