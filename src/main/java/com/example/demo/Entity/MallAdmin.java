package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MallAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mallAdminId;
	private String mallAdminName;
	private String mall;
	private String mallAdminPassword;
	private String mallAdminPhone;
	public int getMallAdminId() {
		return mallAdminId;
	}
	public void setMallAdminId(int mallAdminId) {
		this.mallAdminId = mallAdminId;
	}
	public String getMallAdminName() {
		return mallAdminName;
	}
	public void setMallAdminName(String mallAdminName) {
		this.mallAdminName = mallAdminName;
	}
	public String getMall() {
		return mall;
	}
	public void setMall(String mall) {
		this.mall = mall;
	}
	public String getMallAdminPassword() {
		return mallAdminPassword;
	}
	public void setMallAdminPassword(String mallAdminPassword) {
		this.mallAdminPassword = mallAdminPassword;
	}
	public String getMallAdminPhone() {
		return mallAdminPhone;
	}
	public void setMallAdminPhone(String mallAdminPhone) {
		this.mallAdminPhone = mallAdminPhone;
	}
	
	@Override
	public String toString() {
		return "MallAdmin [mallAdminId=" + mallAdminId + ", mallAdminName=" + mallAdminName + ", mall=" + mall
				+ ", mallAdminPassword=" + mallAdminPassword + ", mallAdminPhone=" + mallAdminPhone + "]";
	}
	
	
	
	
	
	
	

}
