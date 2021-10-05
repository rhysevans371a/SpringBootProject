package com.qa.spring.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.spring.domain.Product;
import com.qa.spring.repo.ProductRepository;
@RunWith(MockitoJUnitRunner.class)

public class ProductServiceTest {
	@InjectMocks
	private ProductService service;
	
	@Mock
	private ProductRepository repo;

	
	@Test
	public void createTest() {
		Product input = new Product("Apple", "Fruit", "each", 0.50);
		Product output = new Product(1L, "Apple", "Fruit", "each", 0.50);
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	@Test
	public void getAllTest() {
		List<Product> output = new ArrayList<>();
		output.add(new Product("Apple", "Fruit", "each", 0.50));
		Mockito.when(this.repo.findAll()).thenReturn(output);
		assertEquals(output, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
}
