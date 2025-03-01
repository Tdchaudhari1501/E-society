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
	private Date date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIsPickup() {
		return isPickup;
	}
	public void setIsPickup(String isPickup) {
		this.isPickup = isPickup;
	}
	
	
}
