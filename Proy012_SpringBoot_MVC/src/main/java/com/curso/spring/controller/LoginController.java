package com.curso.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

		model.addAttribute("usuarioForm", new Usuario());

		return "login";
	}

	// Recojo los datos del formulario
	@PostMapping("/login")
	//notar que se coloco un @Valid --> validara la varaible usr con las validaciones declaradas en la clase usuario
	public String goHome(Model model, @ModelAttribute("usuarioForm") @Valid Usuario usr,BindingResult bindingResult) {
		
		//ver si paso la validacion
		if(bindingResult.hasErrors()) {
			return "login";
		}
		

		// boolean valido = loginService.validarLog(nombre,clave)

		boolean valido = true;// estoy forzando que sea verdadero pero esto se debe validar en un service

		// TODO Llamara un service para que haga la tarea login

		if (usr.getNombre().trim().equalsIgnoreCase("Luis")) {

			usr.setRol("cliente");

		} else {

			usr.setRol("admin");
		}

		if (valido) {
			model.addAttribute("usuario", usr);
		}
		return "home";
		// return "login";
	}
}
