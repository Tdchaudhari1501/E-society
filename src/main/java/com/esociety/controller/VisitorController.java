package com.esociety.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.esociety.entity.DeliverablesEntity;
import com.esociety.entity.HouseEntity;
import com.esociety.entity.MemberEntity;
import com.esociety.entity.UserEntity;
import com.esociety.entity.VisitorCategoryEntity;
import com.esociety.entity.VisitorEntity;
import com.esociety.repository.HouseRepository;
import com.esociety.repository.VisitorCategoryRepository;
import com.esociety.repository.VisitorRepository;
import com.esociety.service.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VisitorController {

	@Autowired
	VisitorRepository repoVisitor;

	@Autowired
	HouseRepository repoHouse;

	@Autowired
	Cloudinary cloudinary;
	@Autowired
	MailService serviceMail;

	@Autowired
	VisitorCategoryRepository repoVisitorCate;

	@GetMapping("newvisitor")
	public String newVisitor(Model model) {
		List<HouseEntity> allHouse = repoHouse.findAll();// all state
		model.addAttribute("allHouse", allHouse);

		List<VisitorCategoryEntity> allvisitorcate = repoVisitorCate.findAll();// all state
		model.addAttribute("allvisitorcate", allvisitorcate);
		return "NewVisitor";

	}

	@PostMapping("savevisitor")
	public String saveVisitor(VisitorEntity visitorEntity) {

		visitorEntity.setDate(new Date());

		repoVisitor.save(visitorEntity);

		return "redirect:/listvisitor";
	}

	@GetMapping("listvisitor")
	public String listVehicle(Model m) {
		List<VisitorEntity> listVisitor = repoVisitor.findAll();
		m.addAttribute("listVisitor", listVisitor);
		return "ListVisitor";
	}
	@GetMapping("reportvisitor")
	public String ReportlistVehicle(Model m) {
		List<VisitorEntity> listVisitor = repoVisitor.findAll();
		m.addAttribute("listVisitor", listVisitor);
		return "ReportVisitor";
	}

	@GetMapping("viewvisitor")
	public String viewVehicle(Integer visitorId, Model model) {
		// ?
		System.out.println("id ===> " + visitorId);
		Optional<VisitorEntity> op = repoVisitor.findById(visitorId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			VisitorEntity visitor = op.get();
			// send data to jsp ->
			model.addAttribute("visitor", visitor);

		}

		return "ViewVisitor";
	}

	@GetMapping("editvisitor")
	public String editVisitor(Integer visitorId, Model model) {
		Optional<VisitorEntity> op = repoVisitor.findById(visitorId);
		if (op.isEmpty()) {
			return "redirect:/listvisitor";
		} else {
			model.addAttribute("vehicle", op.get());
			return "EditVisitor";

		}
	}

	@PostMapping("updatevisitor")
	public String updateVisitor(VisitorEntity visitorEntity) {// pcode vhreg type vid

		System.out.println(visitorEntity.getVisitorId());// id? db?

		Optional<VisitorEntity> op = repoVisitor.findById(visitorEntity.getVisitorId());

		if (op.isPresent()) {
			VisitorEntity dbVisitor = op.get(); // pcode vhreg type id userId
			dbVisitor.setPurpose(visitorEntity.getPurpose());// code
			dbVisitor.setAllowed(visitorEntity.getAllowed());// type
			dbVisitor.setVisitorName(visitorEntity.getVisitorName());// type
			dbVisitor.setMobileNo(visitorEntity.getMobileNo());// type
			dbVisitor.setEntryTime(visitorEntity.getEntryTime());// type
			dbVisitor.setExitTime(visitorEntity.getExitTime());// type

			//
			repoVisitor.save(dbVisitor);
		}
		return "redirect:/listvisitor";
	}

	@GetMapping("deletevisitor")
	public String deleteVisitor(Integer visitorId) {
		repoVisitor.deleteById(visitorId);// delete from members where memberID = :memberId
		return "redirect:/listvisitor";
	}

	// User Dashboard
	@GetMapping("myvisitors")
	public String myVisitors(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		model.addAttribute("user", user);
		List<Object[]> allVisitor = repoVisitor.getAll(user.getUserId());
		model.addAttribute("allVisitor", allVisitor);

		return "MyVisitors";
	}

	// for user add member
	@GetMapping("addvisitor")
	public String newMember(Model model) {
		List<HouseEntity> allHouse = repoHouse.findAll();// all state
		model.addAttribute("allHouse", allHouse);

		List<VisitorCategoryEntity> allvisitorcate = repoVisitorCate.findAll();// all state
		model.addAttribute("allvisitorcate", allvisitorcate);
		return "AddVisitor";

	}

	@PostMapping("addvisitor")
	public String addVisitor(VisitorEntity visitorEntity, MultipartFile profilePic, HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		visitorEntity.setUserId(userId);
		visitorEntity.setDate(new Date());
		String generatedOtp = String.valueOf(new Random().nextInt(899999) + 100000);
		visitorEntity.setOtp(generatedOtp);

		// Optionally send via email
		UserEntity user1 = (UserEntity) session.getAttribute("user");
		serviceMail.sendBookingConfirmation(visitorEntity.getMobileNo(), 
		    "Your OTP for Visitor Entry", 
		    "Please show this OTP at the gate: " + generatedOtp);

		if (profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png")
				|| profilePic.getOriginalFilename().endsWith(".jpeg")) {

			try {

				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
				visitorEntity.setProfilePhoto(result.get("url").toString());

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {

			model.addAttribute("error", "Not valid type of Profile Pic");
			return "AddVisitor";
		}
		
		
		repoVisitor.save(visitorEntity);
		return "redirect:/myvisitors";
	}
	
	
	@GetMapping("deleteuservisitor")
	public String deleteuservisitor(Integer visitorId) {
		repoVisitor.deleteById(visitorId);//delete from members where memberID = :memberId
		return "redirect:/myvisitors";
	}
	
	
	@GetMapping("viewuservisitor")
	public String viewuservisitor(Integer visitorId, Model model) {
		// ?
		System.out.println("id ===> " + visitorId);
		Optional<VisitorEntity> op = repoVisitor.findById(visitorId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			VisitorEntity visitor = op.get();
			// send data to jsp ->
			model.addAttribute("visitor", visitor);

		}

		return "ViewUserVisitor";
	}
	
	@GetMapping("edituservisitor")
 	public String editDeliverables(Integer visitorId,Model model) {
 		Optional<VisitorEntity> op = repoVisitor.findById(visitorId);
 		if (op.isEmpty()) {
 			return "redirect:/myvisitors";
 		} else {
 			model.addAttribute("visitor",op.get());
 			return "EditUserVisitor";
 
 		}
 	}
	
	@PostMapping("updateuservisitor")
 	public String updateDeliverables(VisitorEntity visitorEntity) {//pcode vhreg type vid 
 		
 		System.out.println(visitorEntity.getVisitorId());//id? db? 
 
 		Optional<VisitorEntity> op = repoVisitor.findById(visitorEntity.getVisitorId());
 		
 		if(op.isPresent())
 		{
 			VisitorEntity dbVisitor = op.get(); //pcode vhreg type id userId 
 			dbVisitor.setAllowed(visitorEntity.getAllowed());//code 
 			dbVisitor.setEntryTime(visitorEntity.getEntryTime());//code 
 			dbVisitor.setExitTime(visitorEntity.getExitTime());//code 
 			dbVisitor.setVisitorName(visitorEntity.getVisitorName());// type
 			dbVisitor.setMobileNo(visitorEntity.getMobileNo());//code 
 			dbVisitor.setPurpose(visitorEntity.getPurpose());//code 

 			

 			//
 			repoVisitor.save(dbVisitor);
 		}
 		return "redirect:/myvisitors";
 	}
	
     
	
	// Guard - Dashboard
    @GetMapping("guard-dashboard")
    public String guardDashboard(Model model) {
        List<VisitorEntity> visitors = repoVisitor.findAll();
        model.addAttribute("visitors", visitors);
        return "GuardDashboard";
    }

    @GetMapping("approvevisitor")
    public String approveVisitor(@RequestParam Integer visitorId) {
        Optional<VisitorEntity> op = repoVisitor.findById(visitorId);
        if (op.isPresent()) {
            VisitorEntity v = op.get();
            v.setAllowed(1);
            repoVisitor.save(v);
        }
        return "redirect:/guard-dashboard";
    }

    @GetMapping("entryexit")
    public String updateEntryExit(@RequestParam Integer visitorId, @RequestParam String type) {
        Optional<VisitorEntity> op =repoVisitor.findById(visitorId);
        if (op.isPresent()) {
            VisitorEntity v = op.get();
            if ("entry".equals(type)) {
                v.setEntryTime(LocalTime.now().toString());
            } else {
                v.setExitTime(LocalTime.now().toString());
            }
            repoVisitor.save(v);
        }
        return "redirect:/guard-dashboard";
    }
    
    @PostMapping("verifyvisitorotp")
    public String verifyOtp(@RequestParam String mobileNo, @RequestParam String otp, Model model) {
        List<VisitorEntity> visitors = repoVisitor.findAll();

        Optional<VisitorEntity> match = visitors.stream()
            .filter(v -> v.getMobileNo().equals(mobileNo) && v.getOtp().equals(otp))
            .findFirst();

        if (match.isPresent()) {
            VisitorEntity v = match.get();
            v.setAllowed(1);
            repoVisitor.save(v);
            model.addAttribute("message", "OTP Verified! Visitor Approved.");
            
            return "guard-dashboard";
            
        } else {
            model.addAttribute("message", "Invalid OTP or Mobile Number.");
        }

        return "verifyOtp";
    }

 // Loads OTP form page
    @GetMapping("verifyvisitorotp")
    public String loadOtpForm() {
        return "verifyOtp"; // This should be your HTML/JSP file
    }
}
