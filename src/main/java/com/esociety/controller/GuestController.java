package com.esociety.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestController{
	@GetMapping("NewGuest")
	public String newGuest() {
		return "NewGuest";
	}
	@PostMapping("saveGuest")
	public String saveGuest() {
		return "Login";
	}
	
}