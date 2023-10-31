package com.example.demo.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
 
@Entity
public class Product {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prdId;
	private String prdName;
	private float prdPrice;
	public Product() {
		super();
	}
	public Product(String prdName, float prdPrice) {
		super();
		this.prdName = prdName;
		this.prdPrice = prdPrice;
	}
	public Product(int prdId, String prdName, float prdPrice) {
		super();
		this.prdId = prdId;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
	}
 
 
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public double getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(float prdPrice) {
		this.prdPrice = prdPrice;
	}
	@Override
	public String toString() {
		return "Product [prdId=" + prdId + ", prdName=" + prdName + ", prdPrice=" + prdPrice + "]";
	}
	
}