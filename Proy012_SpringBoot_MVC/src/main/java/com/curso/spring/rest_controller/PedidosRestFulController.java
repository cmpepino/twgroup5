package com.curso.spring.rest_controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.excepciones.PedidosException;
import com.curso.spring.servicios.PedidoService;

@RestController
//doy permiso a esta url a poder comunicarse con este servidor
@CrossOrigin(origins = { "http://localhost:4200" } , 
methods = {RequestMethod.GET, 
		   RequestMethod.POST, 
		   RequestMethod.DELETE, 
		   RequestMethod.PUT,
		   RequestMethod.OPTIONS})

//para crear un Restful WebService
public class PedidosRestFulController {

	@Autowired
	private PedidoService pedidoService;

	// get all
	@GetMapping("/ws/pedidos")
	public Collection<Pedido> all() {
		return pedidoService.getPedidos(null);
	}

	// get by Id
	@GetMapping("/ws/pedidos/{id}")
	public Pedido getByID(@PathVariable("id") Integer id) {
		System.out.println();
		Optional<Pedido> p = pedidoService.getPedido(id);

		return p.get();
	}

	// Insert
	@PostMapping("/ws/pedidos")
	public Pedido addPedido(@RequestBody Pedido newPedido) {

		return pedidoService.generarPedido(newPedido);

	}

	// delete

	@DeleteMapping("/ws/pedidos/{id}")
	public void eliminarPedidoByID(@PathVariable("id") Integer id) throws PedidosException {
		
		pedidoService.detelteById(id);
			
	}
	
	@ExceptionHandler({PedidosException.class, Exception.class})
	public String manejarExcepcion(HttpServletRequest req, Exception e){
		return "error" + e.getMessage();
	}
	
	

	// Update

	@PutMapping("/ws/pedidos")
	public Pedido modificarPedidoByID(@RequestBody Pedido pedidoAModificar) {
		Pedido pModificar = pedidoService.modificarPeddido(pedidoAModificar);
		return pModificar;
	}

	// Update Descripcion de un producto

	@PutMapping("/ws/pedidos/{id}/{desc}")
	public Pedido modificarDesc(@PathVariable ("id") Integer id, @PathVariable ("desc") String desc) {
		Optional<Pedido> pedidoBaseDatos = pedidoService.getPedido(id);
		Pedido pModificar = new Pedido();
		pModificar.setId(id);
		pModificar.setDesc(desc);
		pModificar.setUser(pedidoBaseDatos.get().getUser());
		pModificar.setDate(pedidoBaseDatos.get().getDate());
		pModificar.setEntregado(pedidoBaseDatos.get().isEntregado());
		pedidoService.modificarPeddido(pModificar);
		return pModificar;
	}

}
