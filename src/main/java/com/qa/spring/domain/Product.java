/**
 * 
 */
package com.qa.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

/**
 * @author Rhys Evans
 *
 */
@Entity
@Validated

public class Product {
//	Column names for database
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productID;
	@NotNull
	private String productName;
	
	private String aisleName;
	
	private String unitSize;
	
	private double unitPrice;
	
//	Constructors
	
	/**
	 * @param productID
	 * @param productName
	 * @param aisleName
	 * @param unitSize
	 * @param unitPrice
	 */
	public Product(Long productID, @NotNull String productName, String aisleName, String unitSize, double unitPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.aisleName = aisleName;
		this.unitSize = unitSize;
		this.unitPrice = unitPrice;
	}


	/**
	 * @param productName
	 * @param aisleName
	 * @param unitSize
	 * @param unitPrice
	 */
	public Product(@NotNull String productName, String aisleName, String unitSize, double unitPrice) {
		super();
		this.productName = productName;
		this.aisleName = aisleName;
		this.unitSize = unitSize;
		this.unitPrice = unitPrice;
	}

	/**
	 * 
	 */
	public Product() {
		super();
	}
}
