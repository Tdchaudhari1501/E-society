package com.esociety.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.DeliverablesEntity;
import com.esociety.entity.HouseEntity;

import com.esociety.repository.DeliverablesRepository;
import com.esociety.repository.HouseRepository;

@Controller
public class DeliverablesController {
	
	@Autowired
	DeliverablesRepository repoDeliverable;
	@Autowired
	HouseRepository repoHouse;
	
	@GetMapping("newdeliverable")
	public String newDeliverable(Model model) {
		List<HouseEntity> allHouse = repoHouse.findAll();// all state	
		model.addAttribute("allHouse",allHouse);
		
		return "NewDeliverable";
	}
	
	@PostMapping("savedeliverable")
	public String saveDeliverable(DeliverablesEntity deliverablesEntity) {
		
		deliverablesEntity.setDate(new Date());
		repoDeliverable.save(deliverablesEntity);
		
		return "redirect:/listDeliverable";
	}
	@GetMapping("listDeliverable")
	public String listDeliverable(Model m) {
	List<DeliverablesEntity> listDeliverable=repoDeliverable.findAll();
		m.addAttribute("listDeliverable", listDeliverable);
		return "ListDeliverable";
	}
	
	@GetMapping("viewdeliverable")
	public String viewdeliverable(Integer deliverablesId, Model model) {
		// ?
		System.out.println("id ===> " + deliverablesId);
		Optional<DeliverablesEntity> op = repoDeliverable.findById(deliverablesId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
		DeliverablesEntity deliverable = op.get();
			// send data to jsp ->
			model.addAttribute("deliverable", deliverable);

		}

		return "ViewDeliverable";
	}
	
	@GetMapping("editdeliverable")
 	public String editDeliverable(Integer deliverablesId,Model model) {
 		Optional<DeliverablesEntity> op = repoDeliverable.findById(deliverablesId);
 		if (op.isEmpty()) {
 			return "redirect:/listdeliverable";
 		} else {
 			model.addAttribute("deliverable",op.get());
 			return "EditDeliverable";
 
 		}
 	}
	
	@PostMapping("updatedeliverable")
 	public String updateDeliverable(DeliverablesEntity deliverablesEntity) {//pcode vhreg type vid 
 		
 		System.out.println(deliverablesEntity.getDeliverablesId());//id? db? 
 
 		Optional<DeliverablesEntity> op = repoDeliverable.findById(deliverablesEntity.getDeliverablesId());
 		
 		if(op.isPresent())
 		{
 			DeliverablesEntity dbDeliverable = op.get(); //pcode vhreg type id userId 
 			dbDeliverable.setIsPickup(deliverablesEntity.getIsPickup());//code 
 			

 			//
 			repoDeliverable.save(dbDeliverable);
 		}
 		return "redirect:/listdeliverable";
 	}
	
	@GetMapping("deletedeliverable")
	public String deletedeliverable(Integer deliverablesId) {
		repoDeliverable.deleteById(deliverablesId);//delete from members where memberID = :memberId
		return "redirect:/listDeliverable";
	}
}
