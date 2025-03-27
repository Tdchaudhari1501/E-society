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
		return "NewVisitorCategory";
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
	@GetMapping("editvisitorcategory")
 	public String editVisitorCategory(Integer visitorCategoryId,Model model) {
 		Optional<VisitorCategoryEntity> op = repoVisitorCategory.findById(visitorCategoryId);
 		if (op.isEmpty()) {
 			return "redirect:/listVisitorCategory";
 		} else {
 			model.addAttribute("visitorcategory",op.get());
 			return "EditVisitorCategory";
 
 		}
 	}
	
	@PostMapping("updatevisitorcategory")
 	public String updateVisitorCategory(VisitorCategoryEntity visitorCategoryEntity) {//pcode vhreg type vid 
 		
 		System.out.println(visitorCategoryEntity.getVisitorCategoryId());//id? db? 
 
 		Optional<VisitorCategoryEntity> op = repoVisitorCategory.findById(visitorCategoryEntity.getVisitorCategoryId());
 		
 		if(op.isPresent())
 		{
 			VisitorCategoryEntity dbVisitorCategory = op.get(); //pcode vhreg type id userId 
 			dbVisitorCategory.setCategoryName(visitorCategoryEntity.getCategoryName());//code 
 			

 			//
 			repoVisitorCategory.save(dbVisitorCategory);
 		}
 		return "redirect:/listVisitorCategory";
 	}
	@GetMapping("deletevisitorcategory")
	public String deletehouse(Integer visitorCategoryId) {
		repoVisitorCategory.deleteById(visitorCategoryId);//delete from members where memberID = :memberId
		return "redirect:/listVisitorCategory";
	}
}
