package com.esociety.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visitor_category")
public class VisitorCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer visitorCategoryId;
	private String categoryName;
	public Integer getVisitorCategoryId() {
		return visitorCategoryId;
	}
	public void setVisitorCategoryId(Integer visitorCategoryId) {
		this.visitorCategoryId = visitorCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
