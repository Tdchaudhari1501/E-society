package com.esociety.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	 @Table(name = "contact")
	 public class ContactEntity{
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Integer contactId;
	 	private String contactName;
	 	private String contactEmail;
	 	private String contactMessage;
	 	private String subject;
	 	public Integer getContactId() {
	 		return contactId;
	 	}
	 	public void setContactId(Integer contactId) {
	 		this.contactId = contactId;
	 	}
	 	public String getContactName() {
	 		return contactName;
	 	}
	 	public void setContactName(String contactName) {
	 		this.contactName = contactName;
	 	}
	 	public String getContactEmail() {
	 		return contactEmail;
	 	}
	 	public void setContactEmail(String contactEmail) {
	 		this.contactEmail = contactEmail;
	 	}
	 	public String getContactMessage() {
	 		return contactMessage;
	 	}
	 	public void setContactMessage(String contactMessage) {
	 		this.contactMessage = contactMessage;
	 	}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
	
	 	
}
