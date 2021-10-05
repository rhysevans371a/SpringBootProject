package com.qa.spring.repo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.activation.DataSource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.qa.spring.domain.Product;

import nl.jqno.equalsverifier.internal.util.Assert;
@AutoConfigureTestDatabase
@ExtendWith(SpringExtension.class)
@DataJpaTest

public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;
	  @Autowired private DataSource dataSource;
	  @Autowired private JdbcTemplate jdbcTemplate;
	  @Autowired private EntityManager entityManager;
//	  @Autowired private Product userRepository;

	  @Test
	  public void injectedComponentsAreNotNull(){
	    assertThat(dataSource).isNotNull();
	    assertThat(jdbcTemplate).isNotNull();
	    assertThat(entityManager).isNotNull();
	    assertThat(repository).isNotNull();
	  }
	

	@Test
	public void saveTest() {
		Product product = new Product("Apple", "Fruit", "each", 0.50);
		repository.save(product);
		Assert.assertEquals(null, repository.findByName("Apple"), product);
	}

}