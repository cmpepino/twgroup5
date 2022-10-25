package com.curso.mercado.persistencia;

import java.sql.*;
import java.util.*;

import com.curso.mercado.entidades.Producto;

public class ProductoDataBaseDAO implements GenericDAO<Producto> {

	// atributos
	private Connection con;

	// Constructor
	public ProductoDataBaseDAO(Connection con) {
		this.con = con;
	}

	// Metodos
	@Override
	public void add(Producto entidad) {
		// TODO validar

		
		//esto esta comentado porque se creo un metodo que lo hace
		
		/*String consulta = "SELECT MAX(ID_PRODUCTO) FROM PRODUCTOS1";
		Statement st;*/
		try {
			/*st = con.createStatement();
			ResultSet indice = st.executeQuery(consulta);
			

			// es utilizado if porque el ResultSet solo devuelve un valor, en este caso.
			// Si devolviera mas de un valor se podria utilizar el while

			if (indice.next()) {

				// se utiliza .next() porque el indice esta por defecto en beforeFirst,
				// por lo que se utiliza esta funcion para que el indice baje al primer valor,
				// si existe,
				// en caso contrario que devuelva false

				indMaximo = indice.getInt(1);
			}*/

			// Insertar en la tabla el nuevo valor
			// se utiliza preparedStatement porque es mas seguro que el statement
			//ademas que te permite crear una plantilla de sentencia y despues poder definirle los datos
		
			int indMaximo = 0;

			String sentenciaInsert = "INSERT INTO PRODUCTOS1(ID_PRODUCTO,DESCRIPCION,PRECIO,STOCK)"
												  + " VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sentenciaInsert);
			ps.setInt(1, getUltimoIdProducto()+1);
			ps.setString(2, entidad.getDescripcion());
			ps.setDouble(3, entidad.getPrecio());
			ps.setInt(4, entidad.getStock());

			// copiando en la tabla
			ps.executeUpdate();
			System.out.println("grabo ok en la tabla");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("no se pudo crear el producto " + e.getMessage(),e);
		}

	}

	@Override
	public List<Producto> getAll() {

		ArrayList<Producto> productos = new ArrayList<Producto>();
		String consulta = "SELECT * FROM PRODUCTOS1 ORDER BY ID_PRODUCTO";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt("ID_PRODUCTO"));
				p.setDescripcion(rs.getString("DESCRIPCION"));
				p.setPrecio(rs.getDouble("PRECIO"));
				p.setStock(rs.getInt("STOCK"));
				productos.add(p);
			}

		} catch (SQLException e) {
			// e.printStackTrace(); //------> muestra la pila de llamada()
			// cuando hago mi throw new mi excepcion solo se muestra mi error,
			// se pierde las demas llamadas por lo que se pierde la trasabilidad del error
			throw new RuntimeException("DB JDBC API.  " + e.getMessage(), e);
		}
		return productos;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub

	}
	
	private int getUltimoIdProducto() {
		String consulta = "SELECT MAX(ID_PRODUCTO) FROM PRODUCTOS1";
		try {
			ResultSet indice = con.createStatement().executeQuery(consulta);
			if(indice.next()) {
				//	get<tpoValor>(<columna>)
				return indice.getInt(1);
			}else {
				return 0;
			}
		}catch(SQLException e) {
			throw new RuntimeException("No se pudo obtener id " + e.getMessage(),e);
		}		
	}

}
