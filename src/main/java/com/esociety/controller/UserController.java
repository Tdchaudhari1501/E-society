package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.esociety.entity.UserEntity;
import com.esociety.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository repositoryUser;
	
	@GetMapping("home")
	public String home() {
		return "Home";
	}
	@GetMapping("listuser")
	public String listUser(Model model) {
		List<UserEntity> users = repositoryUser.findAll(); 
		model.addAttribute("users",users);
		return "ListUser";
	}
	
	
	
	
}
