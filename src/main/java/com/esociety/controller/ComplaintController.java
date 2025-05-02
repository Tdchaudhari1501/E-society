package com.esociety.controller;

import java.util.List;
import java.util.Optional;

import com.esociety.entity.ComplaintEntity;
import com.esociety.entity.UserEntity;
import com.esociety.repository.ComplaintRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepo;

    @GetMapping("newcomplaint")
    public String newComplaint(Model model) {
        return "NewComplaint";
    }

    @PostMapping("savecomplaint")
    public String saveComplaint(@ModelAttribute ComplaintEntity complaint,@RequestParam(required = false) String otherType, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        complaint.setUserId(user.getUserId());
        // If otherType is filled, override the selected type
        if (otherType != null && !otherType.trim().isEmpty()) {
            complaint.setType(otherType.trim());
        }
        complaint.setStatus("Pending");
        complaintRepo.save(complaint);
        return "redirect:/mycomplaints";
    }

    @GetMapping("mycomplaints")
    public String myComplaints(@RequestParam(defaultValue = "") String type,
            @RequestParam(defaultValue = "") String status, Model model, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        List<ComplaintEntity> list= complaintRepo.findByUserIdAndTypeContainingAndStatusContaining(
                user.getUserId(),
                type,
                status
            );
        model.addAttribute("mycomplaints", list);
        model.addAttribute("selectedType", type);
        model.addAttribute("selectedStatus", status);
        return "MyComplaints";
    }

    @GetMapping("admincomplaints")
    public String allComplaints(Model model) {
        List<ComplaintEntity> list = complaintRepo.findAll();
        model.addAttribute("complaints", list);
        return "AdminComplaints";
    }

    @GetMapping("updatecomplaintstatus")
    public String updateStatus(@RequestParam Integer id, @RequestParam String status) {
        Optional<ComplaintEntity> op = complaintRepo.findById(id);
        if (op.isPresent()) {
            ComplaintEntity complaint = op.get();
            complaint.setStatus(status);
            complaintRepo.save(complaint);
        }
        return "redirect:/admincomplaints";
    }
}
