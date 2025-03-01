package com.esociety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esociety.entity.StateEntity;
import com.esociety.repository.StateRepository;
@Controller
public class StateController {
	@Autowired
	StateRepository repoState;

@GetMapping("/newstate")
public String newState() {
 return "NewState";
}

@PostMapping("/savestate")
public String saveState(StateEntity state){
   repoState.save(state);
 return "redirect:/liststate"; // redirect to controller method
}

@GetMapping("liststate")
public String listState(Model m) {
 List<StateEntity> listState   =   repoState.findAll();
 m.addAttribute("stateList", listState);
  return "ListState";
}
}
