package com.emmanuel.plumas.p7JavaLibrarEasyWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BorrowEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.services.BorrowService;

@Controller
public class BorrowController extends CommonController{

	@Autowired
	@Qualifier("BorrowService")
	private BorrowService borrowService;
	
	@GetMapping(value="/borrowByUserLastName")
	public String getBorrowByUserLastName(Model model)  {
		String userLastName=getPrincipal();
		List<BorrowEntity> oldBorrowEntities=borrowService.getOldBorrowByUserLastName(userLastName);
		List<BorrowEntity> currentBorrowEntities=borrowService.getCurrentBorrowByUserLastName(userLastName);
		
		model.addAttribute("oldBorrowEntities", oldBorrowEntities);
		model.addAttribute("currentBorrowEntities", currentBorrowEntities);
		model.addAttribute("principal",userLastName);
		return "borrowByUserLastName";
	}
	
}
