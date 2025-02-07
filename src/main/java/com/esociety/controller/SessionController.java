package com.esociety.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
     @GetMapping("Signup")
	public String Signup(){
		return "Signup";  //jsp name
	}
     @GetMapping("Login")
 	public String Login(){
 		return "Login";  //jsp name
 	}
}