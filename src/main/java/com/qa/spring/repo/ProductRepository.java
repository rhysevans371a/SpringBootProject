package com.qa.spring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.spring.domain.Product;

/**
 * @author Rhys Evans
 *
 */
public interface ProductRepository extends JpaRepository <Product, Long>{
//	@Query(value = "SELECT * FROM Product Where product_name = ?1", nativeQuery = true)
//	List<Product>findByName(String name);
	Optional<Product> findByName(String productName);
}
