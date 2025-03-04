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
	
	@GetMapping("login")  // 
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
			return "redirect:/login";// login URL
		}
	
	@GetMapping("forgotpassword")
	public String forgotpassword() {
		return "forgot";
	}
	
	@PostMapping("sendotp")
	public String sendOtp(String email, Model model) {
		// email valid
		Optional<UserEntity> op = repoUser.findByEmail(email);
		if (op.isEmpty()) {
			// email invalid
			model.addAttribute("error", "Email not found");
			return "forgot";
		} else {
			// email valid
			// send mail OTP
			// opt generate
			// send mail OTP
			String otp = "";
			otp = (int) (Math.random() * 1000000) + "";// 0.25875621458541

			UserEntity user = op.get();
			user.setOtp(otp);
			repoUser.save(user);// update OTP for user
			serviceMail.sendOtpForForgetPassword(email, user.getFirstName(), otp);
			return "changepassword";
		}
		}
	@PostMapping("updatepassword")
	public String updatePassword(String email, String password, String otp, Model model) {
		Optional<UserEntity> op = repoUser.findByEmail(email);
		if (op.isEmpty()) {
			model.addAttribute("error", "Invalid Data");
			return "changepassword";
		} else {
			UserEntity user = op.get();
			if (user.getOtp().equals(otp)) {
				String encPwd = encoder.encode(password);
				user.setPassword(encPwd);
				user.setOtp("");
				repoUser.save(user);// update
			} else {

				model.addAttribute("error", "Invalid Data");
				return "changepassword";
			}
		}
		model.addAttribute("msg","Password updated");
		return "Login";
	}
}