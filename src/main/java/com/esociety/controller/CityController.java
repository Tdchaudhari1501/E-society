package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.CityEntity;
import com.esociety.entity.StateEntity;
import com.esociety.repository.CityRepository;
import com.esociety.repository.StateRepository;

@Controller
public class CityController {
	@Autowired
	CityRepository repoCity;
	
	@Autowired
	StateRepository repoState;
	
	@GetMapping("newcity")
	public String newCity(Model model) {
		
		List<StateEntity> allState = repoState.findAll();// all state	
		model.addAttribute("allState",allState);
		return "NewCity";
	}
	
	@PostMapping("savecity")
	public String saveCity(CityEntity cityEntity) {
		
		repoCity.save(cityEntity);
		return "redirect:/newcity";
	}

}
