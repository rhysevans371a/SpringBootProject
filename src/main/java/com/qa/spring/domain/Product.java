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
//	Getters and setters
	
	/**
	 * @return the productID
	 */
	public Long getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the aisleName
	 */
	public String getAisleName() {
		return aisleName;
	}

	/**
	 * @param aisleName the aisleName to set
	 */
	public void setAisleName(String aisleName) {
		this.aisleName = aisleName;
	}

	/**
	 * @return the unitSize
	 */
	public String getUnitSize() {
		return unitSize;
	}

	/**
	 * @param unitSize the unitSize to set
	 */
	public void setUnitSize(String unitSize) {
		this.unitSize = unitSize;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
