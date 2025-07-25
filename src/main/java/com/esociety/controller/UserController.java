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
import com.esociety.entity.UserEntity;
import com.esociety.entity.VehicleEntity;
import com.esociety.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserRepository repoUser;
	@Autowired
	Cloudinary cloudinary;

	@GetMapping("home")
	public String home() {
		return "Home";
	}

	

	@GetMapping("listuser")
	public String listUser(Model model) {
		List<UserEntity> users = repoUser.findAll();
		model.addAttribute("users", users);
		return "ListUser";
	}

	@GetMapping("viewuser")
	public String viewUser(Integer userId, Model model) {
		// ?
		System.out.println("id ===> " + userId);
		Optional<UserEntity> op = repoUser.findById(userId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			UserEntity users = op.get();
			// send data to jsp ->
			model.addAttribute("users", users);

		}

		return "ViewUser";
	}

	@GetMapping("deleteuser")
	public String deleteuser(Integer userId) {
		repoUser.deleteById(userId);// delete from members where memberID = :memberId
		return "redirect:/listuser";
	}

//	@GetMapping("userprofile")
//	public String forgotpassword() {
//		return "UserProfile";
//	}

}
