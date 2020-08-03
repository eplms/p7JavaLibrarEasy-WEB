package com.emmanuel.plumas.p7JavaLibrarEasyWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BorrowEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.services.BorrowService;

@Controller
public class BorrowController {

	@Autowired
	@Qualifier("BorrowService")
	private BorrowService borrowService;
	
	@GetMapping(value="/borrowByUserLastName")
	public String getBorrowByUserLastName(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userLastName = "empty";
		if (principal instanceof UserDetails) {
			userLastName = ((UserDetails) principal).getUsername();
			
			
		} else {
			userLastName = principal.toString();
		}
		List<BorrowEntity> borrowEntities=borrowService.getBorrowByUserLastName(userLastName);
		model.addAttribute("borrowEntities", borrowEntities);
		model.addAttribute("principal",userLastName);
		return "borrowByUserLastName";
	}
	
}
