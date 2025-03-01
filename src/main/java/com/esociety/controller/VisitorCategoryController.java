package com.esociety.controller;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("viewvisitorcategory")
	public String viewVisitorCategory(Integer visitorCategoryId, Model model) {
		// ?
		System.out.println("id ===> " + visitorCategoryId);
		Optional<VisitorCategoryEntity> op = repoVisitorCategory.findById(visitorCategoryId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			VisitorCategoryEntity visitorcategory = op.get();
			// send data to jsp ->
			model.addAttribute("visitorcategory", visitorcategory);

		}

		return "ViewVisitorCategory";
	}
	
	@GetMapping("deletevisitorcategory")
	public String deletehouse(Integer visitorCategoryId) {
		repoVisitorCategory.deleteById(visitorCategoryId);//delete from members where memberID = :memberId
		return "redirect:/listVisitorCategory";
	}
}
