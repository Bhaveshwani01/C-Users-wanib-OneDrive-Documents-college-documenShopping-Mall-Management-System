package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemID;
	private String itemName;
	private String ManufacturingDate;
	private String expiryDate;
	private String Categories;
	private float itemPrice;
	public long getItemID() {
		return itemID;
	}
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getManufacturingDate() {
		return ManufacturingDate;
	}
	public void setManufacturingDate(String manufacturingDate) {
		ManufacturingDate = manufacturingDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCategories() {
		return Categories;
	}
	public void setCategories(String categories) {
		Categories = categories;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", ManufacturingDate=" + ManufacturingDate
				+ ", expiryDate=" + expiryDate + ", Categories=" + Categories + ", itemPrice=" + itemPrice + "]";
	}


	
	

}
