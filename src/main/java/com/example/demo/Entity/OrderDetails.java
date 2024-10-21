package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderDetailsId;
	private String dateOfPurchase;
	private float Total;
	private int customerId;
	private String paymentMode;
	private int shopId;
	public int getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", dateOfPurchase=" + dateOfPurchase + ", Total="
				+ Total + ", customerId=" + customerId + ", paymentMode=" + paymentMode + ", shopId=" + shopId + "]";
	}

	
	
	
	
	
	
	

}
