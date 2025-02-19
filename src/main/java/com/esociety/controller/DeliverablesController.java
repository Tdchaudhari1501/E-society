package com.esociety.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.DeliverablesEntity;
import com.esociety.repository.DeliverablesRepository;

@Controller
public class DeliverablesController {
	
	@Autowired
	DeliverablesRepository repoDeliverable;
	
	
	@GetMapping("newdeliverable")
	public String newDeliverable() {
		return "Deliverables";
	}
	
	@PostMapping("savedeliverable")
	public String saveDeliverable(DeliverablesEntity deliverablesEntity) {
		
		deliverablesEntity.setDate(new Date());
		repoDeliverable.save(deliverablesEntity);
		
		return "Deliverables";
	}
}
