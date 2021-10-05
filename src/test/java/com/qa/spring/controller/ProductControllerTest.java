package com.qa.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.spring.domain.Product;
import com.qa.spring.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest

public class ProductControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private ProductService service;
	@Test
	public void createTest() throws Exception {
		Product product = new Product("Apple", "Fruit", "each", 0.50);
		String productAsJSON = this.mapper.writeValueAsString(product);
		
		Mockito.when(this.service.create(product)).thenReturn(product);
		
		mvc.perform(post("/Product/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(productAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(productAsJSON));		
	}
	@Test
	public void readAllTest() throws Exception {
		Product product = new Product("Apple", "Fruit", "each", 0.50);
		List<Product> output = new ArrayList<>();
		output.add(product);
		String outputAsJSON = this.mapper.writeValueAsString(output);
		
		Mockito.when(this.service.readAll()).thenReturn(output);
		
		mvc.perform(get("/Product/Read")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	@Test
	public void readIdTest() throws Exception {
		Product product = new Product("Apple", "Fruit", "each", 0.50);
		String productAsJSON = this.mapper.writeValueAsString(product);
		
		Mockito.when(this.service.read(1L)).thenReturn(product);
		
		mvc.perform(get("/Product/read/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(productAsJSON));
	}
	
}
