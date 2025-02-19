package com.esociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.StateEntity;
import com.esociety.repository.StateRepository;
@Controller
public class StateController {
	@Autowired
	StateRepository repoState; //obeject of interface
	@GetMapping("newstate")
    public String newstate() {
	   return "NewState";
   }
	@PostMapping("savestate")
	public String savestate(StateEntity state) {
		System.out.println(state.getStateName());
		
		repoState.save(state);
		return "NewState";
	}
}
