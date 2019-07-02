package com.titannet.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.titannet.springboot.app.service.IBookService;
import com.titannet.springboot.app.service.IProductoService;
import com.titannet.springboot.app.entity.Book;
import com.titannet.springboot.app.entity.Producto;

@Controller
public class BookController {

//singleton
@Autowired
IBookService bookService; 


@RequestMapping(value="/all", method=RequestMethod.GET)
public String listar (Model model) {	
	List<Book> books  = bookService.findall();
	model.addAttribute("Titulo","listar libros");
	model.addAttribute("libros",books);	
	return "books/allBooks";
}


}
