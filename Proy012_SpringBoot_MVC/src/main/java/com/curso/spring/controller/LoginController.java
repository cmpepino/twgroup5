package com.curso.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class LoginController {

//	@Autowired
//	private LoginService loginService;

	// Formulario en el que pido usuario y clave
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("usuario", new Usuario());

		return "login";
	}

	// Recojo los datos del formulario
	@PostMapping("/login")
	public String goHome(Model model, 
			            @ModelAttribute("usuario") Usuario usr) {
		
		//boolean valido = loginService.validarLog(nombre,clave)
		
		usr.setRol("cliente");
		
		return "home";
		//return "login";
	}
}
