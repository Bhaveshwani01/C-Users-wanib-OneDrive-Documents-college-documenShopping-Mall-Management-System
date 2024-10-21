package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mall {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mallID;
	private String mallAdmin;
	private String mallName;
	private String mallLocation;
	private int shopId;
	private String categories;


	public long getMallID() {
		return mallID;
	}


	public void setMallID(long mallID) {
		this.mallID = mallID;
	}


	public String getMallAdmin() {
		return mallAdmin;
	}



	public void setMallAdmin(String mallAdmin) {
		this.mallAdmin = mallAdmin;
	}



	public String getMallName() {
		return mallName;
	}



	public void setMallName(String mallName) {
		this.mallName = mallName;
	}



	public String getMallLocation() {
		return mallLocation;
	}


	public void setMallLocation(String mallLocation) {
		this.mallLocation = mallLocation;
	}


	public int getShopId() {
		return shopId;
	}


	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	
	public String getCategories() {
		return categories;
	}


	public void setCategories(String categories) {
		this.categories = categories;
	}



	@Override
	public String toString() {
		return "Shop [mallID=" + mallID + ", mallAdmin=" + mallAdmin + ", mallName=" + mallName + ", mallLocation="
				+ mallLocation + ", shopId=" + shopId + ", categories=" + categories + "]";
	}



	
	

}
