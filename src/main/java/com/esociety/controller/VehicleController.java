package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.VehicleEntity;
import com.esociety.repository.VehicleRepository;

@Controller
public class VehicleController {
	@Autowired
	VehicleRepository repoVehicle;
	
	@GetMapping("newvehicle")
	public String newVehicle() {
		return "NewVehicle";
	}
	
	@PostMapping("savevehicle")
	public String saveVehicle(VehicleEntity vehicleEntity) {
		
		repoVehicle.save(vehicleEntity);
		return "redirect:/listvehicle";
	}

	@GetMapping("listvehicle")
	public String listVehicle(Model m) {
	List<VehicleEntity> listVehical	=repoVehicle.findAll();
		m.addAttribute("listVehical", listVehical);
		return "ListVehicle";
	}
	
}
