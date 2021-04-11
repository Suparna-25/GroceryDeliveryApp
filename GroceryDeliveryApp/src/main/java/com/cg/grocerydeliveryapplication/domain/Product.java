package com.cg.grocerydeliveryapplication.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;



@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	@NotBlank(message="product name should not be null")
	@Size(min=5, max=10)
	private String productName;
	@NotBlank(message="category name should not be null")
	@Size(min=5, max=15)
//	@ManyToOne	(cascade=CascadeType.ALL)
//	@JoinColumn(name="CAT_ID")
	private String categoryName;
	@NotNull(message="quantity should not zero")
    @Max(1000)
	private int quantity;
	@NotNull(message="price should not zero")
   	private double price;
	
	public Product() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public  String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
