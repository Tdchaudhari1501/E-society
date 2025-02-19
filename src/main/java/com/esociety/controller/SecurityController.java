package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.esociety.entity.SecurityEntity;
import com.esociety.repository.SecurityRepository;

@Controller
public class SecurityController {
	
	@Autowired
	SecurityRepository repoSecurity;
	
	@GetMapping("newsecurity")
	public String newSecurity() {
		return "NewSecurity";
	}
	
	@PostMapping("savesecurity")
	public String saveSecurity(SecurityEntity securiyEntity) {
		
		repoSecurity.save(securiyEntity);
		return "redirect:/listsecurity";
	}
	
	@GetMapping("listsecurity")
	public String listVehicle(Model m) {
	List<SecurityEntity> listSecurity=repoSecurity.findAll();
		m.addAttribute("listSecurity", listSecurity);
		return "ListSecurity";
	}
}
