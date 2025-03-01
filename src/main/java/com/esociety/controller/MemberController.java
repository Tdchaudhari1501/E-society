package com.esociety.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.HouseEntity;
import com.esociety.entity.MemberEntity;
import com.esociety.entity.UserEntity;
import com.esociety.repository.HouseRepository;
import com.esociety.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	MemberRepository repoMember;
	
	@Autowired
	HouseRepository repoHouse;
     
	@GetMapping("newmember")
	public String newMember(Model model) {
		
		List<HouseEntity> allHouse = repoHouse.findAll();// all state	
		model.addAttribute("allHouse",allHouse);
		return "NewMember";
		
	}
	@PostMapping("savemember")
	public String saveMember(MemberEntity memberEntity, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		memberEntity.setUserId(userId);
		
		repoMember.save(memberEntity);
		return "redirect:/listmember";
	}
	
	@GetMapping("listmember")
	public String listVehicle(Model m) {
	List<MemberEntity> listMember	=repoMember.findAll();
		m.addAttribute("listMember", listMember);
		return "ListMember";
	}
	@GetMapping("viewmember")
	public String viewMember(Integer memberId, Model model) {
		// ?
		System.out.println("id ===> " + memberId);
		Optional<MemberEntity> op = repoMember.findById(memberId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			MemberEntity member = op.get();
			// send data to jsp ->
			model.addAttribute("member", member);

		}

		return "ViewMember";
	}
	
	@GetMapping("deletemember")
	public String deleteMember(Integer memberId) {
		repoMember.deleteById(memberId);//delete from members where memberID = :memberId
		return "redirect:/listmember";
	}
	
	
	
	
}
