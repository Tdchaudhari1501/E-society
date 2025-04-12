package com.esociety.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.esociety.entity.DeliverablesEntity;
import com.esociety.entity.HouseEntity;
import com.esociety.entity.UserEntity;
import com.esociety.entity.VisitorCategoryEntity;
import com.esociety.entity.VisitorEntity;
import com.esociety.repository.DeliverablesRepository;
import com.esociety.repository.HouseRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeliverablesController {
	
	@Autowired
	DeliverablesRepository repoDeliverable;
	@Autowired
	HouseRepository repoHouse;
	@Autowired
	Cloudinary cloudinary;
	
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
	@GetMapping("reportDeliverable")
	public String ReportlistDeliverable(Model m) {
	List<DeliverablesEntity> listDeliverable=repoDeliverable.findAll();
		m.addAttribute("listDeliverable", listDeliverable);
		return "ReportDeliverable";
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
 			dbDeliverable.setName(deliverablesEntity.getName());
 			dbDeliverable.setAmount(deliverablesEntity.getAmount());
 			

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
	
	
	
	// User Dashboard
		@GetMapping("mydeliverables")
		public String myDeliverable(HttpSession session, Model model) {
			UserEntity user = (UserEntity) session.getAttribute("user");
			model.addAttribute("user", user);
			List<Object[]> allDeliverable = repoDeliverable.getAll(user.getUserId());
			model.addAttribute("allDeliverable", allDeliverable);

			return "MyDeliverables";
		}

		// for user add member
		@GetMapping("adddeliverable")
		public String newDeliverables(Model model) {
			List<HouseEntity> allHouse = repoHouse.findAll();// all state
			model.addAttribute("allHouse", allHouse);

			
			return "AddDeliverable";

		}

		@PostMapping("adddeliverable")
		public String addDeliverable(DeliverablesEntity deliverablesEntity, MultipartFile profilePic, HttpSession session, Model model) {
			UserEntity user = (UserEntity) session.getAttribute("user");
			Integer userId = user.getUserId();
			deliverablesEntity.setUserId(userId);
			deliverablesEntity.setDate(new Date());

			if (profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png")
					|| profilePic.getOriginalFilename().endsWith(".jpeg")) {

				try {

					Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
					deliverablesEntity.setProductPhoto(result.get("url").toString());

				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			} else {

				model.addAttribute("error", "Not valid type of Profile Pic");
				return "AddDeliverable";
			}
			repoDeliverable.save(deliverablesEntity);
			return "redirect:/mydeliverables";
		}
		
		@GetMapping("deleteuserdeliverable")
		public String deletedeliverables(Integer deliverablesId) {
			repoDeliverable.deleteById(deliverablesId);//delete from members where memberID = :memberId
			return "redirect:/mydeliverables";
		}
		
		
		@GetMapping("viewuserdeliverable")
		public String viewdeliverables(Integer deliverablesId, Model model) {
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

			return "ViewUserDeliverable";
		}
		
		@GetMapping("edituserdeliverable")
	 	public String editDeliverables(Integer deliverablesId,Model model) {
	 		Optional<DeliverablesEntity> op = repoDeliverable.findById(deliverablesId);
	 		if (op.isEmpty()) {
	 			return "redirect:/mydeliverables";
	 		} else {
	 			model.addAttribute("deliverable",op.get());
	 			return "EditUserDeliverable";
	 
	 		}
	 	}
		
		@PostMapping("updateuserdeliverable")
	 	public String updateDeliverables(DeliverablesEntity deliverablesEntity) {//pcode vhreg type vid 
	 		
	 		System.out.println(deliverablesEntity.getDeliverablesId());//id? db? 
	 
	 		Optional<DeliverablesEntity> op = repoDeliverable.findById(deliverablesEntity.getDeliverablesId());
	 		
	 		if(op.isPresent())
	 		{
	 			DeliverablesEntity dbDeliverable = op.get(); //pcode vhreg type id userId 
	 			dbDeliverable.setIsPickup(deliverablesEntity.getIsPickup());//code 
	 			dbDeliverable.setName(deliverablesEntity.getName());
	 			dbDeliverable.setAmount(deliverablesEntity.getAmount());
	 			

	 			//
	 			repoDeliverable.save(dbDeliverable);
	 		}
	 		return "redirect:/mydeliverables";
	 	}
}
