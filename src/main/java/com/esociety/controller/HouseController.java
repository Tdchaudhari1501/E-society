package com.esociety.controller;

import java.util.List;

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
	public String listVehicle(Model m) {
	List<HouseEntity> listHouse=repoHouse.findAll();
		m.addAttribute("listHouse", listHouse);
		return "ListHouse";
	}
}
