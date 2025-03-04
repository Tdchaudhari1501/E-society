package com.esociety.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.HouseEntity;
import com.esociety.entity.VisitorCategoryEntity;
import com.esociety.entity.VisitorEntity;
import com.esociety.repository.HouseRepository;
import com.esociety.repository.VisitorCategoryRepository;
import com.esociety.repository.VisitorRepository;


@Controller
public class VisitorController {
	
	@Autowired
	VisitorRepository repoVisitor;
	
	@Autowired
	HouseRepository repoHouse;
	
	@Autowired
	VisitorCategoryRepository repoVisitorCate;
	
	@GetMapping("newvisitor")
	public String newVisitor(Model model) {
		List<HouseEntity> allHouse = repoHouse.findAll();// all state	
		model.addAttribute("allHouse",allHouse);
		
		List<VisitorCategoryEntity> allvisitorcate = repoVisitorCate.findAll();// all state	
		model.addAttribute("allvisitorcate",allvisitorcate);
		
		
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
	@GetMapping("viewvisitor")
	public String viewVehicle(Integer visitorId, Model model) {
		// ?
		System.out.println("id ===> " + visitorId);
		Optional<VisitorEntity> op = repoVisitor.findById(visitorId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			VisitorEntity visitor = op.get();
			// send data to jsp ->
			model.addAttribute("visitor", visitor);

		}

		return "ViewVisitor";
	}
	
	@GetMapping("deletevisitor")
	public String deleteVisitor(Integer visitorId) {
		repoVisitor.deleteById(visitorId);//delete from members where memberID = :memberId
		return "redirect:/listvisitor";
	}
}
