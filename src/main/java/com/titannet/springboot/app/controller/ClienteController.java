package com.titannet.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.titannet.springboot.app.entity.Cliente;
import com.titannet.springboot.app.service.IClienteService;
import com.titannet.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes ("cliente")
public class ClienteController {
	
	@Autowired(required=true)	
	//@Qualifier("clienteDao")
	private IClienteService clienteService;

	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page",defaultValue="0") int page,Model model) {
		Pageable pageRequest=new PageRequest(page,5);
		Page<Cliente>clientes=clienteService.findAll(pageRequest);
		PageRender<Cliente> pageRender= new PageRender<>("/listar",clientes);
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo","Formulario Cliente");
			return "form";
		}
		String mensajeFlash=(cliente.getId()!=null)? "Cliente Editado con éxito":"Cliente creado con éxito";
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:listar";
	}
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String,Object> model,RedirectAttributes flash) {
		Cliente cliente=null;
		if(id>0) {
			cliente=clienteService.findOne(id);	
			if (cliente==null) {
				flash.addFlashAttribute("error","el ID del cliente no existe");
				return "redirect:/listar";
			}
		}else {
			flash.addFlashAttribute("error","el ID del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put ("cliente",cliente);
		model.put("titulo","Editar Cliente");		
		return "form";
	}
	
	@RequestMapping (value="/eliminar/{id}")
	public String eliminar (@PathVariable(value="id") Long id) {
		if (id>0) {
			clienteService.delete(id);
		}
	return "redirect:/listar";	
	}
}
