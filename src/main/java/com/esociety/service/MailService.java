package com.esociety.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 
@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	public void sendWelcomeMail(String email, String firstName) {
		String subject = "Greetings of Day!!!";
		String body = "hi, " + firstName+"\n"
				+ "We hope this email finds you well.We are thrilled to inform you that"
				+" you have been selected to join the prestigious team at Alembic in Detailing Team . Your hard work, dedication, and impressive skills"
				+" have earned you this remarkable opportunity.";
		String from = "chaudharitd1501@gmail.com";
		// logic
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}
	
	public void sendOtpForForgetPassword(String email, String firstName,String otp) {
		String subject = "OTP for Resetpassword";
		String body = "Hey " + firstName
				+ ", It seems you have request for forget password, please use below otp for reset password.  If not then simply ignore the message!OTP:"+otp;
		String from = "chaudharitd1501@gmail.com";

		// logic
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);

	}
	
	public void sendBookingConfirmation(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("td1501@yopmail.com"); // Replace with your configured sender email
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
	
}