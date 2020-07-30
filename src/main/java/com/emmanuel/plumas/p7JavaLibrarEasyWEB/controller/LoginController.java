package com.emmanuel.plumas.p7JavaLibrarEasyWEB.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping(value="/")
	public String homePage(Model model){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userLastName = "empty";
		if (principal instanceof UserDetails) {
			userLastName = ((UserDetails) principal).getUsername();
		} else {
			userLastName = principal.toString();
		}
		
	 	model.addAttribute("principal",userLastName);
		return "accueil";
	}
	
}
