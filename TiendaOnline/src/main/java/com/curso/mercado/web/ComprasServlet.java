package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.mercado.entidades.Usuario;
import com.curso.mercado.servicios.VentasService;
import com.curso.mercado.servicios.excepciones.VentasException;

@WebServlet(urlPatterns = "comprar", loadOnStartup = 3)
public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private VentasService v = new VentasService();

	public ComprasServlet() {
		super();
		System.out.println(".... instanciando ComprasServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);

		VentasService v = new VentasService();
		String idProducto = req.getParameter("idProducto");
		String cant = req.getParameter("Cantidad");
		
		int idProd = -1;
		if(idProducto != null ) {
			idProd = Integer.parseInt(idProducto);
		}
		
		int idCant = -1;
		if(cant != null ) {
			idCant = Integer.parseInt(cant);
		}
		//validacion
		
		
		String mensaje = "";//al crear esto aqui no hace falta po
		
		
		try {
			v.comprarProducto(idProd, idCant);
			mensaje = "Has comprado " + idCant+" unidad. ";
			//comprar ok
			//volver a lista
		} catch (VentasException e) {
			mensaje = "No se ha comprado. " + e.getMessage();
			
			
//			req.setAttribute("errorVenta", e.getMessage());
//			RequestDispatcher rd = req.getRequestDispatcher("lista-producto.jsp");
//			rd.forward(req, resp);
//			//volver a lista
//			//lista devuelve el error
		}
		req.setAttribute("mensaje", mensaje);
		//Lista<Producto> lista = ;
		//RequestDispatcher rd = req.getRequestDispatcher("lista-productos.jsp");
		
		//despacho la peticion a la listaProductosServlet q
		//esta se encarga de obtener lista y despachar la pagina jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProducto");
		rd.forward(req, resp);
		/*
		 * linea 56 -> indicarle al procesador que se va a cambiar al servlet indicado.
		 * linea 57 -> ejecuta la accion. le pasa el baton al servlet indicado .
		 * la linea 56 es como añadir lo que hace el servlet nombrado como /listaProducto
		 * en este servlet.
		 * 
		 */
		
		

	}

}
