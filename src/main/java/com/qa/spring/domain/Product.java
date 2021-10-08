/**
 * 
 */
package com.qa.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rhys Evans
 *
 */
@Entity
@Data // Lombok annotation to use getter, setter and equals() etc
@AllArgsConstructor // Lombok annotation to call all variable constructor
@NoArgsConstructor // Lombok annotation to call empty constructor

public class Product {
//	Column names for database

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productID;
//	@NotNull
	private String productName;

	private String aisleName;

	private String unitSize;

	private double unitPrice;

	public Product(@NotNull String productName, String aisleName, String unitSize, double unitPrice) {
		super();
		this.productName = productName;
		this.aisleName = aisleName;
		this.unitSize = unitSize;
		this.unitPrice = unitPrice;
	}

	/***************************************************************************************
	 * All other getter and setters etc commented out due to Lombok not requiring
	 * these
	 ***************************************************************************************/

//	Constructors

	/**
	 * @param productID
	 * @param productName
	 * @param aisleName
	 * @param unitSize
	 * @param unitPrice
	 */
//	public Product(Long productID, @NotNull String productName, String aisleName, String unitSize, double unitPrice) {
//		super();
//		this.productID = productID;
//		this.productName = productName;
//		this.aisleName = aisleName;
//		this.unitSize = unitSize;
//		this.unitPrice = unitPrice;
//	}
//
//	/**
//	 * @param productName
//	 * @param aisleName
//	 * @param unitSize
//	 * @param unitPrice
//	 */

//
//	/**
//	 * 
//	 */
//	public Product() {
//		super();
//	}
////	Getters and setters
//
//	/**
//	 * @return the productID
//	 */
//	public Long getProductID() {
//		return productID;
//	}
//
//	/**
//	 * @param productID the productID to set
//	 */
//	public void setProductID(Long productID) {
//		this.productID = productID;
//	}
//
//	/**
//	 * @return the productName
//	 */
//	public String getProductName() {
//		return productName;
//	}
//
//	/**
//	 * @param productName the productName to set
//	 */
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	/**
//	 * @return the aisleName
//	 */
//	public String getAisleName() {
//		return aisleName;
//	}
//
//	/**
//	 * @param aisleName the aisleName to set
//	 */
//	public void setAisleName(String aisleName) {
//		this.aisleName = aisleName;
//	}
//
//	/**
//	 * @return the unitSize
//	 */
//	public String getUnitSize() {
//		return unitSize;
//	}
//
//	/**
//	 * @param unitSize the unitSize to set
//	 */
//	public void setUnitSize(String unitSize) {
//		this.unitSize = unitSize;
//	}
//
//	/**
//	 * @return the unitPrice
//	 */
//	public double getUnitPrice() {
//		return unitPrice;
//	}
//
//	/**
//	 * @param unitPrice the unitPrice to set
//	 */
//	public void setUnitPrice(double unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//	// equals and hashCode methods
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(aisleName, productID, productName, unitPrice, unitSize);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return Objects.equals(aisleName, other.aisleName) && Objects.equals(productID, other.productID)
//				&& Objects.equals(productName, other.productName)
//				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice)
//				&& Objects.equals(unitSize, other.unitSize);
//	}

}
