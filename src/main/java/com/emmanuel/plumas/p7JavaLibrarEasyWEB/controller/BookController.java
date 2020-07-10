package com.emmanuel.plumas.p7JavaLibrarEasyWEB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BookEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value="/")
	public String getIndex() {
		return "accueil";
	}
	
	@GetMapping(value="/books")
	public String getIndex(Model model) {
		
		List<BookEntity> bookEntities=bookService.getAllBooks();
		model.addAttribute("bookEntities", bookEntities);
	
		return "books";
	}
	
	
	
}
