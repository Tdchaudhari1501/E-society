package com.esociety.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.esociety.entity.VisitorEntity;
import com.esociety.repository.VisitorRepository;

@Controller
public class VisitorController {
	
	@Autowired
	VisitorRepository repoVisitor;
	
	@GetMapping("newvisitor")
	public String newVisitor() {
		return "NewVisitor";
		
	}
	
	@PostMapping("savevisitor")
	public String saveVisitor(VisitorEntity visitorEntity) {
		
		visitorEntity.setDate(new Date());
		
		repoVisitor.save(visitorEntity);
		
		return "redirect:/listvisitor";
	}
	@GetMapping("listvisitor")
	public String listVehicle(Model m) {
	List<VisitorEntity> listVisitor=repoVisitor.findAll();
		m.addAttribute("listVisitor", listVisitor);
		return "ListVisitor";
	}
}
