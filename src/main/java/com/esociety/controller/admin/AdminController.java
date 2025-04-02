package com.esociety.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.esociety.repository.DeliverablesRepository;
import com.esociety.repository.MemberRepository;
import com.esociety.repository.UserRepository;
import com.esociety.repository.VisitorRepository;

@Controller
public class AdminController {
	@Autowired
	UserRepository repoUser;
	
	@Autowired
	MemberRepository repoMember;
	
	@Autowired
	VisitorRepository repoVisitor;
	
	@Autowired
	DeliverablesRepository repoDeliverable;

	@GetMapping("admindashboard")
	public String adminDashboard(Model model) {
		
		//total users 
		//total members
		//this month visitors
		//this month Deliverable
		//chart 1 to 30 date by visitors
		
	//all users 	
	 Long total =	repoUser.count(); //admin  include
	 
	  //select * from by role
	 Integer totalusers= repoUser.findByRole("USER").size();
	 model.addAttribute("totalusers",totalusers);
	 
	 //total members
	 Long totalmembers= repoMember.count();
;	 model.addAttribute("totalmembers",totalmembers);
	 
   //Current month
	 java.util.Date date =new Date();
	 Calendar cal=Calendar.getInstance();
	cal.setTime(date);
	int month=cal.get(Calendar.MONTH)+1;
	
	 //This month visitor
	Integer countThisMonthVisitor=repoVisitor.countThisMonthVisitor(month);
	model.addAttribute("countThisMonthVisitor",countThisMonthVisitor);
	
	//for current Month
	SimpleDateFormat sdf=new SimpleDateFormat("MMMM");
	String currentmonth=sdf.format(date);
	model.addAttribute("currentmonth",currentmonth);
	
	
	//This Month Deliverable
	
	Integer countThisMonthDeliverable=repoDeliverable.countThisMonthDeliverable(month);
	model.addAttribute("countThisMonthDeliverable",countThisMonthDeliverable);
	
	
	
	
	//For Charts
	
	Integer monthWiseVisitors [] = new Integer[12];
	
	for(int i=1;i<=12;i++) {
		monthWiseVisitors [i-1] = repoVisitor.countThisMonthVisitor(i);
	}
	model.addAttribute("monthWiseVisitors",monthWiseVisitors);
	
		return "AdminDashboard";
	}
	
}