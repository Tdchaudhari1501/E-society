package com.esociety.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
	@Autowired
	Cloudinary cloudinary;
	
	
	@GetMapping(value = {  "signup" })
	public String signup() {
		return "Signup";
	}

	@GetMapping("login") //
	public String login() { // method
		return "Login"; // return jsp name
	}
	@GetMapping(value={"index","/"}) //
	public String Index() { // method
		return "Index"; // return jsp name
	}

	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity, MultipartFile profilePic, Model model) {
//		System.out.println(userEntity.getFirstName());
//		System.out.println(userEntity.getLastName());
//		System.out.println(userEntity.getEmail());
//		System.out.println(userEntity.getPassword());
//		System.out.println(userEntity. getContactNum());
		if (profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png")
				|| profilePic.getOriginalFilename().endsWith(".jpeg")) {

			try {

				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
				userEntity.setProfilePicPath(result.get("url").toString());

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {

			model.addAttribute("error", "Not valid type of Profile Pic");
			return "Signup";
		}
		String encPassword = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
		userEntity.setRole("USER");

		repoUser.save(userEntity); // insert query
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());

		return "Login";// jsp
	}

	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {// sakira@yopmail.com
																									// sakira
//		System.out.println(email);
//		System.out.println(password);

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
				} else if (dbUser.getRole().equals("GUARD")) {

					return "redirect:/guard-dashboard";
				} 
				else {
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					return "Login";
				}
			}
		}
		model.addAttribute("error", "Invalid Credentials");
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
		model.addAttribute("msg", "Password updated");
		return "Login";
	}
	
	
	//USER Dashboard Profile Updation
	
	
	@GetMapping("editprofile")
	public String editUser(Integer userId, Model model) {

		Optional<UserEntity> op = repoUser.findById(userId);
		if (op.isEmpty()) {
			return "Not valid user";
		} else {
			model.addAttribute("user", op.get());
			return "MyProfile";
		}

	}

	@PostMapping("updateprofile")
	public String updateUser(UserEntity userEntity, Integer userId, HttpSession httpSession, MultipartFile profilePic) {

		Optional<UserEntity> op = repoUser.findById(userEntity.getUserId());

		if (op.isPresent()) {
			UserEntity dbUsers = op.get();
			dbUsers.setFirstName(userEntity.getFirstName());
			dbUsers.setLastName(userEntity.getLastName());
			dbUsers.setEmail(userEntity.getEmail());
			dbUsers.setContactNum(userEntity.getContactNum());

			if ((profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png")
					|| profilePic.getOriginalFilename().endsWith(".jpeg"))) {
				try {
					Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
					dbUsers.setProfilePicPath(result.get("url").toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			//
			repoUser.save(dbUsers);
		}

	return "redirect:/editprofile?userId="+ userEntity.getUserId();// change Id
	//	return "redirect:/home";
	}
}