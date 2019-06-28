package com.titannet.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.titannet.springboot.app.service.IBookService;

@Controller
public class bookController {

	@Autowired
	IBookService bookService;
	
	@GetMapping("/all")
	public String showAll(Model model) {
	    model.addAttribute("books", bookService.findAll());
	    return "books/allBooks";
	}
	
}
