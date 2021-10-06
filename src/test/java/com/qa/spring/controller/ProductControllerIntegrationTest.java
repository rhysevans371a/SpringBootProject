package com.qa.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.spring.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class ProductControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Product input = new Product("Pear", "Fruit", "each", 0.50);
		Product output = new Product(2L, "Pear", "Fruit", "each", 0.50);
		String inputAsJSON = this.mapper.writeValueAsString(input);
		String outputAsJSON = this.mapper.writeValueAsString(output);

		mvc.perform(post("/Product/create").contentType(MediaType.APPLICATION_JSON).content(inputAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void readAllTest() throws Exception {
		Product input = new Product(1L, "Apple", "Fruit", "each", 0.50);
		List<Product> output = new ArrayList<>();
		output.add(input);
		String outputAsJSON = this.mapper.writeValueAsString(output);

		mvc.perform(get("/Product/Read").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void readByIdTest() throws Exception {
		Product input = new Product(1L, "Apple", "Fruit", "each", 0.50);
		String inputAsJSON = this.mapper.writeValueAsString(input);

		mvc.perform(get("/Product/read/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(inputAsJSON));
	}
}
