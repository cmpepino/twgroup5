package com.curso.mercado.servicios;

import java.util.List;


import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.Producto_JPA_DAO;
//import com.curso.db.PoolConexiones;
//import com.curso.mercado.persistencia.ProductoDataBaseDAO;
//import com.curso.mercado.persistencia.ProductoInMemoryDAO;

public class ProductosService {

	private GenericDAO<Producto> dao;

	public ProductosService() {
		/*
		 * PoolConexiones pool = new PoolConexiones();
		 * this.dao = new ProductoDataBaseDAO(pool.getConnection());
		*/
		this.dao = new Producto_JPA_DAO();
	}

	public List<Producto> dameTodosLosProductos() {
		return dao.getAll();
	}

	public void darAltaProducto(Producto p) {
		// valida que p no es null
		// validar descripcion
		// validar precio
		dao.add(p);
	}

}
