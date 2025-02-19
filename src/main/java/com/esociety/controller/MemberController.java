package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.MemberEntity;

import com.esociety.repository.MemberRepository;

@Controller
public class MemberController {
	@Autowired
	MemberRepository repoMember;
     
	@GetMapping("newmember")
	public String newMember() {
		return "NewMember";
		
	}
	@PostMapping("savemember")
	public String saveMember(MemberEntity memberEntity) {
		repoMember.save(memberEntity);
		return "redirect:/listmember";
	}
	
	@GetMapping("listmember")
	public String listVehicle(Model m) {
	List<MemberEntity> listMember	=repoMember.findAll();
		m.addAttribute("listMember", listMember);
		return "ListMember";
	}
	
}
