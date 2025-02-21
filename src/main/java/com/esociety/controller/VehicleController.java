package com.esociety.controller;

import java.util.List;
import java.util.Optional;

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
	@GetMapping("viewvehicle")
	public String viewVehicle(Integer vehicleId, Model model) {
		// ?
		System.out.println("id ===> " + vehicleId);
		Optional<VehicleEntity> op = repoVehicle.findById(vehicleId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			VehicleEntity vehicle = op.get();
			// send data to jsp ->
			model.addAttribute("vehicle", vehicle);

		}

		return "ViewVehicle";
	}
	
	@GetMapping("deletevehicle")
	public String deleteVehicle(Integer vehicleId) {
		repoVehicle.deleteById(vehicleId);//delete from members where memberID = :memberId
		return "redirect:/listvehicle";
	}
	
}
