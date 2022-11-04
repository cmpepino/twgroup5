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
			//si no existe una sesion iniciada, o sea no existe un usuario logeado, se debe redirigir hacia el login controller
			//para eso se utiliza el comando <redirect:/url> --> indica que el navegador se dirija a la url especificada
			//si se pone solamente la url, el programa se dirige al jsp que tega el nombre de la url.
			//esto tiene un problema porque no esta creada la instancia que utiliza esta pagina.
			return "redirect:/login";
		}
				
		return "home";
	}
	
}
