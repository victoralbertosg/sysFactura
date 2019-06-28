package com.titannet.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.titannet.springboot.app.service.IProductoService;
import com.titannet.springboot.app.entity.Producto;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {

//singleton
@Autowired
IProductoService productoService; 


@RequestMapping(value="/listar", method=RequestMethod.GET)
public String listar (Model model) {	
	List<Producto> productos  = productoService.findall();
	model.addAttribute("Titulo","listar producto");
	model.addAttribute("productos",productos);	
	return "producto/listarProducto";
}

@RequestMapping(value="/listar/{term}", method=RequestMethod.GET)
public String listarbyNombre (@PathVariable (value="term" ) String prod,Model model) {	
	List<Producto> productos  = productoService.findByNombre(prod);
	model.addAttribute("Titulo","listar producto");
	model.addAttribute("productos",productos);	
	return "producto/listarProducto";
}



}
