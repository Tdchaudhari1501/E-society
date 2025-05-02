package com.esociety.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esociety.entity.VisitorEntity;
import com.esociety.repository.VisitorRepository;

@Service
public class VisitorService {
	 @Autowired
	    private VisitorRepository visitorRepo;
	 
	public VisitorEntity addVisitor(VisitorEntity visitor) {
        return visitorRepo.save(visitor);
    }

    public List<VisitorEntity> getAllVisitors() {
        return visitorRepo.findAll();
    }

    public List<VisitorEntity> getVisitorsByResident(Integer userId) {
        return visitorRepo.findByUserId(userId);
    }

    public VisitorEntity updateStatus(Integer visitorId, String status) {
        VisitorEntity v = visitorRepo.findById(visitorId).orElse(null);
        if (v != null) {
            v.setStatus(status);
            return visitorRepo.save(v);
        }
        return null;
    }
    public VisitorEntity addVisitor1(VisitorEntity visitor) {
        visitor.setOtp(generateOTP());
        visitor.setStatus("Pending");
        return visitorRepo.save(visitor);
    }

    private String generateOTP() {
        Random rand = new Random();
        int otp = 1000 + rand.nextInt(9000); // 4-digit OTP
        return String.valueOf(otp);
    }

}
