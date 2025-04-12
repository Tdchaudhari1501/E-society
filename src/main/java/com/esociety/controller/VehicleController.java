package com.esociety.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.UserEntity;
import com.esociety.entity.VehicleEntity;
import com.esociety.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class VehicleController {
	@Autowired
	VehicleRepository repoVehicle;
	
	@GetMapping("newvehicle")
	public String newVehicle() {
		return "NewVehicle";
	}
	
	@PostMapping("savevehicle")
	public String saveVehicle(VehicleEntity vehicleEntity,HttpSession session) {
		UserEntity user = (UserEntity)session.getAttribute("user");//Object
		Integer userId = user.getUserId();
		
		vehicleEntity.setUserId(userId);
		repoVehicle.save(vehicleEntity);
		return "redirect:/listvehicle";
	}

	@GetMapping("listvehicle")
	public String listVehicle(Model m) {
	List<VehicleEntity> listVehical	=repoVehicle.findAll();
		m.addAttribute("listVehical", listVehical);
		return "ListVehicle";
	}
	@GetMapping("reportvehicle")
	public String ReportlistVehicle(Model m) {
	List<VehicleEntity> listVehical	=repoVehicle.findAll();
		m.addAttribute("listVehical", listVehical);
		return "ReportVehicle";
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
	
	@GetMapping("editvehicle")
 	public String editVehicle(Integer vehicleId,Model model) {
 		Optional<VehicleEntity> op = repoVehicle.findById(vehicleId);
 		if (op.isEmpty()) {
 			return "redirect:/listvehicle";
 		} else {
 			model.addAttribute("vehicle",op.get());
 			return "EditVehicle";
 
 		}
 	}
	
	@PostMapping("updatevehicle")
 	public String updateVehicle(VehicleEntity vehicleEntity) {//pcode vhreg type vid 
 		
 		System.out.println(vehicleEntity.getVehicleId());//id? db? 
 
 		Optional<VehicleEntity> op = repoVehicle.findById(vehicleEntity.getVehicleId());
 		
 		if(op.isPresent())
 		{
 			VehicleEntity dbVehicle = op.get(); //pcode vhreg type id userId 
 			dbVehicle.setParkingCode(vehicleEntity.getParkingCode());//code 
 			dbVehicle.setVehicleType(vehicleEntity.getVehicleType());//type 
 			dbVehicle.setVehicleNo(vehicleEntity.getVehicleNo());//type 

 			//
 			repoVehicle.save(dbVehicle);
 		}
 		return "redirect:/listvehicle";
 	}
 	
	
	@GetMapping("deletevehicle")
	public String deleteVehicle(Integer vehicleId) {
		repoVehicle.deleteById(vehicleId);//delete from members where memberID = :memberId
		return "redirect:/listvehicle";
	}
	
}
