package com.esociety.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="deliverables")
public class DeliverablesEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliverablesId;
	private Integer houseId;
	private Integer userId;
	private String productPhoto;
	private  Date date;
	private String isPickup;
	public Integer getDeliverablesId() {
		return deliverablesId;
	}
	public void setDeliverablesId(Integer deliverablesId) {
		this.deliverablesId = deliverablesId;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	
	
	public String getIsPickup() {
		return isPickup;
	}
	public void setIsPickup(String isPickup) {
		this.isPickup = isPickup;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getProductPhoto() {
		return productPhoto;
	}
	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
