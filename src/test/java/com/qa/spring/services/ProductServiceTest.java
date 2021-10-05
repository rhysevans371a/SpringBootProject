package com.qa.spring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Test
	public void readByIdTest() {
		Optional<Product> OptionalOutput = Optional.of(new Product(1L, "Apple", "Fruit", "each", 0.50));
		Product output = new Product(1L, "Apple", "Fruit", "each", 0.50);
		Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);
		assertEquals(output, this.service.read(1L));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void updateTest() {
		Product input = new Product(1L, "Apple", "Fruit", "each", 0.50);
		Optional<Product> existing = Optional.of(new Product(1L, "Pear", "Fruit", "each", 0.50));
		Product output = new Product(1L, "Apple", "Fruit", "each", 0.50);

		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);

		assertEquals(output, this.service.update(input, 1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	}

	@Test
	public void deleteTrueTest() {

		Mockito.when(this.repo.existsById(1L)).thenReturn(false);

		assertTrue(this.service.delete(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}

	@Test
	public void deleteFalseTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(true);

		assertFalse(this.service.delete(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}

}
