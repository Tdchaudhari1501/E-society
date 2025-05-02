package com.esociety.controller;

import com.esociety.entity.FacilityBookingEntity;
import com.esociety.entity.UserEntity;
import com.esociety.repository.FacilityBookingRepository;
import com.esociety.repository.UserRepository;
import com.esociety.service.MailService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class FacilityBookingController {

    @Autowired
    private FacilityBookingRepository facilityRepo;
    
    @Autowired
	UserRepository repoUser;
    
    @Autowired
	MailService serviceMail;

    @GetMapping("bookfacility")
    public String bookForm() {
        return "BookFacility";
    }

    @PostMapping("savefacility")
    public String saveBooking(FacilityBookingEntity booking, HttpSession session, Model model) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        booking.setUserId(user.getUserId());

        // Check for double booking
        List<FacilityBookingEntity> existing = facilityRepo.findByFacilityNameAndBookingDate(
            booking.getFacilityName(), booking.getBookingDate());

        boolean isClash = existing.stream().anyMatch(b ->
            b.getStartTime().equals(booking.getStartTime()) &&
            b.getEndTime().equals(booking.getEndTime()));

        if (isClash) {
            model.addAttribute("error", "Slot already booked. Please select another time.");
            return "BookFacility";
        }

        booking.setStatus("Pending");
        facilityRepo.save(booking);
        return "redirect:/mybookings";
    }

    @GetMapping("mybookings")
    public String myBookings(HttpSession session, Model model) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        List<FacilityBookingEntity> list = facilityRepo.findByUserId(user.getUserId());
        model.addAttribute("mybookings", list);
        return "MyBookings";
    }

    @GetMapping("adminbookings")
    public String adminBookings(Model model) {
        List<FacilityBookingEntity> list = facilityRepo.findAll();
        model.addAttribute("bookings", list);
        return "AdminBookings";
    }

    @GetMapping("updatestatus")
    public String updateStatus(@RequestParam Integer id, @RequestParam String status) {
        Optional<FacilityBookingEntity> op = facilityRepo.findById(id);
        if (op.isPresent()) {
            FacilityBookingEntity b = op.get();
            b.setStatus(status);
            facilityRepo.save(b);
        
        
     // Only send email if status is "Approved"
        if ("Approved".equalsIgnoreCase(status)) {
            // Fetch the user's email from the session or database
            Integer userId = b.getUserId(); 
            Optional<UserEntity> userOpt = repoUser.findById(userId);
            if (userOpt.isPresent()) {
                String email = userOpt.get().getEmail(); // Assuming UserEntity has getEmail()
                String subject = "Facility Booking Approved";
                String message = "Hello, your booking for " + b.getFacilityName() + " on " +
                                 b.getBookingDate() + " from " + b.getStartTime() + " to " +
                                 b.getEndTime() + " has been approved.";
                serviceMail.sendBookingConfirmation(email, subject, message);
            }
          }
        if ("Rejected".equalsIgnoreCase(status)) {
            // Send rejection email
        	 Integer userId = b.getUserId(); 
             Optional<UserEntity> userOpt = repoUser.findById(userId);
             if (userOpt.isPresent()) {
                 String email = userOpt.get().getEmail(); // Assuming UserEntity has getEmail()
                 String subject = "Facility Booking Rejected";
                 String message = "Hello, your booking for " + b.getFacilityName() + " on " +
                                  b.getBookingDate() + " from " + b.getStartTime() + " to " +
                                  b.getEndTime() + " has been rejected.";
                 serviceMail.sendBookingConfirmation(email, subject, message);
            }
        }
        }
    
    
        return "redirect:/adminbookings";
    }
    
    
}
