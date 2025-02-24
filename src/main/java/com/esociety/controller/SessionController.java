package com.esociety.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.UserEntity;
import com.esociety.repository.UserRepository;
import com.esociety.service.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
	
	@Autowired
	UserRepository repoUser;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MailService serviceMail;
	@GetMapping(value = {"/", "signup"})
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("login")  // url
	public String login() {  //method
		return "Login";    // return jsp name
	}
	
	
	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity) {
//		System.out.println(userEntity.getFirstName());
//		System.out.println(userEntity.getLastName());
//		System.out.println(userEntity.getEmail());
//		System.out.println(userEntity.getPassword());
//		System.out.println(userEntity. getContactNum());
		String encPassword = encoder.encode(userEntity.getPassword());
     	userEntity.setPassword(encPassword);
		userEntity.setRole("USER");
		
		repoUser.save(userEntity);  // insert query
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		
		return "Login";//jsp
	}
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password,Model model,HttpSession session) {// sakira@yopmail.com sakira
		System.out.println(email);
		System.out.println(password);

		// users -> email,password
		Optional<UserEntity> op = repoUser.findByEmail(email);
		// select * from users where email = :email and password = :password
		if (op.isPresent()) {
			// true
			// email
			UserEntity dbUser = op.get();
//			if (encoder.matches(password, dbUser.getPassword())) {
//				return "redirect:/home";
//			}
			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {
				session.setAttribute("user", dbUser); // session -> user set
				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard";
				} else if (dbUser.getRole().equals("USER")) {

					return "redirect:/home";
				} else {
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					return "Login";
				}
		    }
		}
		model.addAttribute("error","Invalid Credentials");
		return "Login";
	}
		
		@GetMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/login";// login url
		}
	
	@GetMapping("forgotpassword")
	public String forgotPassword() {
		return "forgot";//jsp
	}
	@PostMapping("sendOtp")
	public String resetpassword() {
		return "changepassword";
	}
	@PostMapping("updatepassword")
	public String updatepassword() {
		return "Login";
	}
}