package com.qa.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.spring.domain.Product;

/**
 * @author Rhys Evans
 *
 */
public interface ProductRepository extends JpaRepository <Product, Long>{

}
