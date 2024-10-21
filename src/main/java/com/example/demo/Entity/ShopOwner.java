package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shopOwnerId;
	private String shopOwnerName;
	private String shopOwnerAddress;
	private int shopId;
	
	
	
	public int getShopOwnerId() {
		return shopOwnerId;
	}
	public void setShopOwnerId(int shopOwnerId) {
		this.shopOwnerId = shopOwnerId;
	}
	public String getShopOwnerName() {
		return shopOwnerName;
	}
	public void setShopOwnerName(String shopOwnerName) {
		this.shopOwnerName = shopOwnerName;
	}
	public String getShopOwnerAddress() {
		return shopOwnerAddress;
	}
	public void setShopOwnerAddress(String shopOwnerAddress) {
		this.shopOwnerAddress = shopOwnerAddress;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	
	@Override
	public String toString() {
		return "ShopOwner [shopOwnerId=" + shopOwnerId + ", shopOwnerName=" + shopOwnerName + ", shopOwnerAddress="
				+ shopOwnerAddress + ", shopId=" + shopId + "]";
	}
	
	
	
	
	
	
	

}
