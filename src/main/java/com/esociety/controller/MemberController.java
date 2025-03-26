package com.esociety.controller;

import java.io.IOException;
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
import com.esociety.entity.HouseEntity;
import com.esociety.entity.MemberEntity;
import com.esociety.entity.UserEntity;
import com.esociety.entity.VisitorEntity;
import com.esociety.repository.HouseRepository;
import com.esociety.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	MemberRepository repoMember;

	@Autowired
	HouseRepository repoHouse;

	@Autowired
	Cloudinary cloudinary;

	@GetMapping("newmember")
	public String newMember(Model model) {
		List<HouseEntity> allHouse = repoHouse.findAll();// all state
		model.addAttribute("allHouse", allHouse);
		return "NewMember";

	}

	// for admin add member
	@PostMapping("savemember")
	public String saveMember(MemberEntity memberEntity, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		memberEntity.setUserId(userId);
		repoMember.save(memberEntity);
		return "redirect:/listmember";
	}
	@GetMapping("newusermember")
	public String newUserMember(Model model) {
		List<HouseEntity> allHouse = repoHouse.findAll();// all state
		model.addAttribute("allHouse", allHouse);
		return "AddMember";
	}
	// for user add member
	@PostMapping("addmember")
	public String addMember(MemberEntity memberEntity, MultipartFile profilePic, HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		memberEntity.setUserId(userId);

		if (profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png")
				|| profilePic.getOriginalFilename().endsWith(".jpeg")) {

			try {

				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
				memberEntity.setProfilePhoto(result.get("url").toString());

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {

			model.addAttribute("error", "Not valid type of Profile Pic");
			return "AddMember";
		}
		repoMember.save(memberEntity);
		return "redirect:/mymembers";
	}

	@GetMapping("listmember")
	public String listVehicle(Model m) {
		List<MemberEntity> listMember = repoMember.findAll();
		m.addAttribute("listMember", listMember);
		return "ListMember";
	}

	@GetMapping("mymembers")
	public String myMembers(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> allMember = repoMember.getAll(user.getUserId());
		model.addAttribute("allMember", allMember);
		model.addAttribute("user", user);
		return "MyMembers";
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
	
	@GetMapping("editmember")
 	public String editMember(Integer memberId,Model model) {
 		Optional<MemberEntity> op = repoMember.findById(memberId);
 		if (op.isEmpty()) {
 			return "redirect:/listmember";
 		} else {
 			model.addAttribute("member",op.get());
 			return "EditMember";
 
 		}
 	}
	
	@PostMapping("updatemember")
 	public String updateMember(MemberEntity memberEntity) {//pcode vhreg type vid 
 		
 		System.out.println(memberEntity.getMemberId());//id? db? 
 
 		Optional<MemberEntity> op = repoMember.findById(memberEntity.getMemberId());
 		
 		if(op.isPresent())
 		{
 			MemberEntity dbMember = op.get(); //pcode vhreg type id userId 
 			dbMember.setMembername(memberEntity.getMembername());//code 
 			dbMember.setAge(memberEntity.getAge());//type 
 			
 
 			
 			repoMember.save(dbMember);
 		}
 		return "redirect:/listmember";
 	}

	@GetMapping("deletemember")
	public String deleteMember(Integer memberId) {
		repoMember.deleteById(memberId);// delete from members where memberID = :memberId
		return "redirect:/listmember";
	}

}
