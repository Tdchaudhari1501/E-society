package com.esociety.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.HouseEntity;
import com.esociety.repository.HouseRepository;

@Controller
public class HouseController {

	@Autowired
	HouseRepository repoHouse;
	
	@GetMapping("newhouse")
	public String newHouse() {
		return "NewHouse";
	}
	
	@PostMapping("savehouse")
	public String saveHouse(HouseEntity houseEntity) {
		
		repoHouse.save(houseEntity);
		return "redirect:/listHouse";
	}
	@GetMapping("listHouse")
	public String listHouse(Model m) {
	List<HouseEntity> listHouse=repoHouse.findAll();
		m.addAttribute("listHouse", listHouse);
		return "ListHouse";
	}
	@GetMapping("reporthouse")
	public String ReportlistHouse(Model m) {
	List<HouseEntity> listHouse=repoHouse.findAll();
		m.addAttribute("listHouse", listHouse);
		return "ReportHouse";
	}
	@GetMapping("viewhouse")
	public String viewHouse(Integer houseId, Model model) {
		// ?
		System.out.println("id ===> " + houseId);
		Optional<HouseEntity> op = repoHouse.findById(houseId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			HouseEntity house = op.get();
			// send data to jsp ->
			model.addAttribute("house", house);

		}

		return "ViewHouse";
	}
	
	@GetMapping("edithouse")
 	public String editHouse(Integer houseId,Model model) {
 		Optional<HouseEntity> op = repoHouse.findById(houseId);
 		if (op.isEmpty()) {
 			return "redirect:/listhouse";
 		} else {
 			model.addAttribute("house",op.get());
 			return "EditHouse";
 
 		}
 	}
	
	@PostMapping("updatehouse")
 	public String updateHouse(HouseEntity houseEntity) {//pcode vhreg type vid 
 		
 		System.out.println(houseEntity.getHouseId());//id? db? 
 
 		Optional<HouseEntity> op = repoHouse.findById(houseEntity.getHouseId());
 		
 		if(op.isPresent())
 		{
 			HouseEntity dbHouse = op.get(); //pcode vhreg type id userId 
 			dbHouse.setTitle(houseEntity.getTitle());//code 
 			dbHouse.setHouseNo(houseEntity.getHouseNo());
 			

 			//
 			repoHouse.save(dbHouse);
 		}
 		return "redirect:/listHouse";
 	}
	
	@GetMapping("deletehouse")
	public String deletehouse(Integer houseId) {
		repoHouse.deleteById(houseId);//delete from members where memberID = :memberId
		return "redirect:/listHouse";
	}
}
