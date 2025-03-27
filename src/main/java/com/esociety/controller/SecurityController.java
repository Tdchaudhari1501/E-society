package com.esociety.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.esociety.entity.SecurityEntity;
import com.esociety.repository.SecurityRepository;

@Controller
public class SecurityController {
	
	@Autowired
	SecurityRepository repoSecurity;
	
	@GetMapping("newsecurity")
	public String newSecurity() {
		return "NewSecurity";
	}
	
	@PostMapping("savesecurity")
	public String saveSecurity(SecurityEntity securiyEntity) {
		
		repoSecurity.save(securiyEntity);
		return "redirect:/listsecurity";
	}
	
	@GetMapping("listsecurity")
	public String listVehicle(Model m) {
	List<SecurityEntity> listSecurity=repoSecurity.findAll();
		m.addAttribute("listSecurity", listSecurity);
		return "ListSecurity";
	}
	@GetMapping("viewsecurity")
	public String viewSecurity(Integer securityId, Model model) {
		// ?
		System.out.println("id ===> " + securityId);
		Optional<SecurityEntity> op = repoSecurity.findById(securityId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			SecurityEntity security = op.get();
			// send data to jsp ->
			model.addAttribute("security", security);

		}

		return "ViewSecurity";
	}
	
	@GetMapping("editsecurity")
 	public String editSecurity(Integer securityId,Model model) {
 		Optional<SecurityEntity> op = repoSecurity.findById(securityId);
 		if (op.isEmpty()) {
 			return "redirect:/listsecurity";
 		} else {
 			model.addAttribute("security",op.get());
 			return "EditSecurity";
 
 		}
 	}
	
	@PostMapping("updatesecurity")
 	public String updateSecurity(SecurityEntity securityEntity) {//pcode vhreg type vid 
 		
 		System.out.println(securityEntity.getSecurityId());//id? db? 
 
 		Optional<SecurityEntity> op = repoSecurity.findById(securityEntity.getSecurityId());
 		
 		if(op.isPresent())
 		{
 			SecurityEntity dbSecurity = op.get(); //pcode vhreg type id userId 
 			dbSecurity.setName(securityEntity.getName());//code 
 			dbSecurity.setContactNum(securityEntity.getContactNum());//type 
 			dbSecurity.setSchedule(securityEntity.getSchedule());//type 

 			//
 			repoSecurity.save(dbSecurity);
 		}
 		return "redirect:/listsecurity";
 	}
	@GetMapping("deletesecurity")
	public String deleteSecurity(Integer securityId) {
		repoSecurity.deleteById(securityId);//delete from members where memberID = :memberId
		return "redirect:/listsecurity";
	}
}
