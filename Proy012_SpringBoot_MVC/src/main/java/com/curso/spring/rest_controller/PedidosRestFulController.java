package com.curso.spring.rest_controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.servicios.PedidoService;

@RestController
//para crear un Restful WebService
public class PedidosRestFulController {

	@Autowired
	private PedidoService pedidoService;
	
	// get all
	@GetMapping("/ws/pedidos")
	public Collection<Pedido> all(){
		
		return pedidoService.getPedidos(null);
	}
		
	// get by Id
//	@GetMapping("/ws/pedidos/{id}")
//	public String getByID(@PathVariable("id") Integer id){
//		
//		return pedidoService.getPedido(id).toString();
//	}
	
	@GetMapping("/ws/pedidos/{id}")
	public Pedido getByID(@PathVariable ("id") Integer id){
		System.out.println();
		Optional<Pedido> p = pedidoService.getPedido(id);
		
		return p.get();
	}
	
	// Insert
	
//	@PostMapping("/ws/pedidos")
//	public void addPedido(Model model, @ModelAttribute ("desc") String desc) {
//		Pedido p = new Pedido();
//		p.setUser("Maite");
//		p.setDate(new Date());
//		p.setDesc(desc);
//		p.setEntregado(true);
//		
//		pedidoService.generarPedido(p);
//		
//	} 
	
	
	@PostMapping("/ws/pedidos")
	public Pedido addPedido(@RequestBody Pedido newPedido) {
			
		return pedidoService.generarPedido(newPedido);
		
	}
		
	// delete
	
	@DeleteMapping("/ws/pedidos")
	public void eliminarPedidoByID(Model model, @ModelAttribute ("id") Integer id) {
		pedidoService.detelteById(id);
		
	}
	
		// Update
	
	@PutMapping("/ws/pedidos")
	public void modificarPedidoByID(Model model, @ModelAttribute ("id") Integer id,
												 @ModelAttribute ("nombre") String nombre,
												 @ModelAttribute ("desc") String desc,
												 @ModelAttribute ("desc") String des) {
		pedidoService.detelteById(id);
		
	}
	
	
	
	
	

}
