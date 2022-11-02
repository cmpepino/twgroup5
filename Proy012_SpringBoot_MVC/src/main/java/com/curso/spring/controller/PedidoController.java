package com.curso.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.entidades.Usuario;
import com.curso.spring.servicios.PedidoService;

@Controller
@SessionAttributes("usuario")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		//pedir la lista de pedido del usuario session
		Usuario usr = (Usuario)model.getAttribute("usuario");
		Collection<Pedido> lista = pedidoService.getPedidos(usr.getNombre());
		model.addAttribute("listaPedido", lista);
				
		//pedidoService.generarPedido(new Pedido());
		return "pedidos";
	}

}
