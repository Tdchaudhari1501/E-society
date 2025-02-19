package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.VisitorCategoryEntity;
import com.esociety.repository.VisitorCategoryRepository;

@Controller
public class VisitorCategoryController {
	
	@Autowired
	VisitorCategoryRepository repoVisitorCategory;
	
	@GetMapping("newvisitorcategory")
	public String newVisitorCategory() {
		return "VisitorCategory";
	}
	
	@PostMapping("savevisitorcategory")
	public String saveVisitorCategory(VisitorCategoryEntity visitorCategoryEntity) {
		
		repoVisitorCategory.save(visitorCategoryEntity);
		
		return "redirect:/listVisitorCategory";
	}
	@GetMapping("listVisitorCategory")
	public String listVehicle(Model m) {
	List<VisitorCategoryEntity> listVisitorCategory=repoVisitorCategory.findAll();
		m.addAttribute("listVisitorCategory", listVisitorCategory);
		return "ListVisitorCategory";
	}
}
