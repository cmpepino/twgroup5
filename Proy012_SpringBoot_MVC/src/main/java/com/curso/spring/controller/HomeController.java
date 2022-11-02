package com.curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class HomeController {
	
	
	//@RequestMapping(method = RequestMethod.GET, path = "/")
	@GetMapping("/") // equivalente de la linea de arriba
	public String inicio(Model model) {
		//ya no hace falta poner esto porque recibe un objeto usuario con todo los parametros
		//model.addAttribute("nombre", "Luis");
		
		if(model.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
				
		return "home";
	}
	
}
