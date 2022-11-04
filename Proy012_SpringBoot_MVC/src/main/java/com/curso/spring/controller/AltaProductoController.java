package com.curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class AltaProductoController {
	
	
	public String altaProducto(Model model) {
		
	
	return "alta-producto";
	}
	
	

}
