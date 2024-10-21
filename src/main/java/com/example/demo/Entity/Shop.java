package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shopeId;
	private String shopCategory;
	private int  employeeId;
	private String shopName;
	private String customers;
	private String shopStatus;
	private String shopOwner;
	private String leaseStatus;

	

	public int getShopeId() {
		return shopeId;
	}



	public void setShopeId(int shopeId) {
		this.shopeId = shopeId;
	}



	public String getShopCategory() {
		return shopCategory;
	}



	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public String getShopName() {
		return shopName;
	}



	public void setShopName(String shopName) {
		this.shopName = shopName;
	}



	public String getCustomers() {
		return customers;
	}



	public void setCustomers(String customers) {
		this.customers = customers;
	}



	public String getShopStatus() {
		return shopStatus;
	}



	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}



	public String getShopOwner() {
		return shopOwner;
	}



	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}



	public String getLeaseStatus() {
		return leaseStatus;
	}



	public void setLeaseStatus(String leaseStatus) {
		this.leaseStatus = leaseStatus;
	}



	@Override
	public String toString() {
		return "Shop [shopeId=" + shopeId + ", shopCategory=" + shopCategory + ", employeeId=" + employeeId
				+ ", shopName=" + shopName + ", customers=" + customers + ", shopStatus=" + shopStatus + ", shopOwner="
				+ shopOwner + ", leaseStatus=" + leaseStatus + "]";
	}



	
	

}
