package com.esociety.model;

import java.time.LocalDateTime;

@Data
public class Notification {
    private String title;
    private String message;
    private LocalDateTime timestamp;
	public void setTimestamp(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
}
