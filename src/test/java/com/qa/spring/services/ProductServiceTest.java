package com.qa.spring.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

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


    @Test
    public void readOneTest() {
        Optional<Product> OptionalOutput = Optional.of(new Product(1L, "Apple", "Fruit", "each", 0.50));
        Product output = new Product(1L, "Apple", "Fruit", "each", 0.50);
        Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);
        assertEquals(output, this.service.read(1L));
        Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
    }
}
