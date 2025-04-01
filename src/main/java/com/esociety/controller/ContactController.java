package com.esociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.ContactEntity;
import com.esociety.repository.ContactRepository;

@Controller
public class ContactController {
	
	@Autowired
 	ContactRepository repoContact;
	
   @GetMapping("contact")
	   public String contact() {
	   return "Contact";
   }
   @PostMapping("savecontact")
	public String SaveContact(ContactEntity contactEntity, Model model) {
      repoContact.save(contactEntity);
      model.addAttribute("msg", "Your message was sent!");
		return "Contact";
	}
}
