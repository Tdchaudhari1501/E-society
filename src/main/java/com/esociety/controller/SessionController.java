package com.esociety.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.UserEntity;

@Controller
public class SessionController {
	@GetMapping(value = {"/", "signup"})
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("login")  // url
	public String login() {  //method
		return "Login";    // return jsp name
	}
	@PostMapping("validatedata")
	public String validatedata(UserEntity userEntity) {
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		return "Home";
	}
	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity) {
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getLastName());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		System.out.println(userEntity. getContactNum());
		
		return "Login";//jsp
	}
	
	@GetMapping("forgotpassword")
	public String forgotPassword() {
		return "forgot";//jsp
	}
	@PostMapping("sendOtp")
	public String resetpassword() {
		return "changepassword";
	}
	@PostMapping("updatepassword")
	public String updatepassword() {
		return "Login";
	}
}