package com.esociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.UserEntity;
import com.esociety.repository.UserRepository;
import com.esociety.service.MailService;

@Controller
public class SessionController {
	
	@Autowired
	UserRepository repoUser;
	@Autowired
	MailService serviceMail;
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
//		System.out.println(userEntity.getFirstName());
//		System.out.println(userEntity.getLastName());
//		System.out.println(userEntity.getEmail());
//		System.out.println(userEntity.getPassword());
//		System.out.println(userEntity. getContactNum());
		
		userEntity.setRole("USER");
		
		repoUser.save(userEntity);  // insert query
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		
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