package com.esociety.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visitor")
public class VisitorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer visitorId;
	private Integer visitorCategoryId;
	private Integer houseId;
	private String purpose;
	private Date date;
	private Integer allowed;
	private String visitorName;
	private String mobileNo;
	private String profilePhoto;
	private String entryTime;
	private String exitTime;
	public Integer getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	public Integer getVisitorCategoryId() {
		return visitorCategoryId;
	}
	public void setVisitorCategoryId(Integer visitorCategoryId) {
		this.visitorCategoryId = visitorCategoryId;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getAllowed() {
		return allowed;
	}
	public void setAllowed(Integer allowed) {
		this.allowed = allowed;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getExitTime() {
		return exitTime;
	}
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	
	
}
