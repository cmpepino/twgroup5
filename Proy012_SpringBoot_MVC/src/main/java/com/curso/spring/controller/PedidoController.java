package com.curso.spring.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.entidades.Usuario;
import com.curso.spring.repositorios.PedidoRepositoryImp;
import com.curso.spring.servicios.PedidoService;

@Controller
@SessionAttributes("usuario")
public class PedidoController {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/pedidos")
	public String pedidos(Model model) {

		// pedir la lista de pedido
		Collection<Pedido> lista = pedidoService.getPedidos(null);
		model.addAttribute("listaPedido", lista);

		// pedidoService.generarPedido(new Pedido());
		return "pedidos";
	}

	// localhost:8080/pedidos/NombreUsuario

	@GetMapping("/pedidos/{userName}")
	public String pedidosCliente(Model model, @PathVariable("userName") String name) {

		// pedir la lista del usuario

		log.info(name);
		System.out.println(name);
		Collection<Pedido> lista = pedidoService.getPedidos(name);
		model.addAttribute("listaPedido", lista);

		return "pedidos";
	}

	// ... pedido url
	// ?idPedido request param
	@GetMapping("/pedido")
	public String verDetallePedido(Model model, @RequestParam("idPedido") Optional<Integer> id) {
		// hemos declarado opcional id
		// orElse(alternativa) si no aparece devuelve null
		Integer idPedido = id.orElse(null);
		if (id.isEmpty()) {
			return "redirect:/pedidos";
		}
		System.out.println(idPedido);
		Optional<Pedido> p = pedidoService.getPedido(idPedido);
		model.addAttribute("pedido", p);
		return "detalle-pedido";
	}

	// ......Alta de un pedido..............
	@GetMapping("/alta")
	public String altaProductoFormulario(Model model) {

		model.addAttribute("altaPedido", new Pedido());

		return "alta-pedido";
	}

	// .......Grabar el pedido nuevo recibiendo los datos de un formulario
	@PostMapping("/alta")
	public String altaProducto(Model model, @ModelAttribute("altaPedido") @Valid Pedido pedido,
			BindingResult bindingResult) {

		// validar que este iniciada una sesion
		if (model.getAttribute("usuario") == null) {

			return "redirect:/login/";

		}
		// validar el campo de descripcion)
		if (bindingResult.hasErrors()) {
			return "alta-pedido";
		}

		// Dar el alta del producto
		Usuario user = (Usuario) model.getAttribute("usuario");

		pedido.setUser(user.getNombre());
		pedido.setDate(new Date());

		pedidoService.generarPedido(pedido);

		return (user.getRol().equals("cliente")) ? "redirect:/pedidos/" + user.getNombre() : "redirect:/pedidos";
		// return "home";
	}

	// .....Dar de baja un pedido.....
	// solo para admin
	@GetMapping("/pedido/delete")
	public String bajaProducto(Model model, @RequestParam("id") Integer id) {

		Usuario user = (Usuario) model.getAttribute("usuario");
		if (user.getRol().equals("cliente")) {
			return "home";
		}
		System.out.println(id);

		this.pedidoService.detelteById(id);

		return "redirect:/pedidos/";
	}

}
