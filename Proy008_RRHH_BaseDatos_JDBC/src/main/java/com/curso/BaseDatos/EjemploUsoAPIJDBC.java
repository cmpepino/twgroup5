package com.curso.BaseDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploUsoAPIJDBC {

	public static void main(String[] args) {
		// 1. conectarse a la bd
		try {
			// esto es el jar. le pide que cargue de forma dinamica
			// el driver de oracle jdbc y mete los jars en la libreria
			// acordarse añadir la dependencia en el pom xml
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// mysql
			// Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			return;
		}

		// 2. hacer una select
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr = "system";
		String clave = "oracle";

		// nueva version del try catch. Se puede definir una variable
		// dentro de la clausula try. Autocierra la conexion siempre
		// porque implementa una clase que se llama Autoclosable
		try (Connection con = DriverManager.getConnection(url, usr, clave)) {

			System.out.println("conectó ok");

			// 2.5 Crear una tabla
			// CREATE TABLE COFFEES(COF_NAME)

			// 3. consultar la lista de paises
			Statement st = con.createStatement();

			// 3.1 lanzar la consulta a la db
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			// 3.2. recorrer
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

			// Insertar un pais
			//DA ERROR DESPUES QUE SE HACE LA PRIMERA EJECUCION
			//1RA EJECUCION ---> LA INSERTA EL DATO 
			//CUANDO SE EJECUTA DE NUEVO DA EL ERROR QUE INDICA QUE YA EXITE EL DATO EN 
			
//			String sentenciaInsert = "INSERT INTO HR.COUNTRIES" + " VALUES ('XY', 'PAISXX',3)";
//			int regAfectado = st.executeUpdate(sentenciaInsert);
//			System.out.printf("insertó %d registros", regAfectado);

			
			
			/*
			 * Connection{
			 * 			Statement 
			 * 			PreparedStatement 
			 * 			CallableStatement} 
			 */
			// sentencia sql SELECT, INSERT, DELETE,... completa

			// mala practica
			// Statement sentencia = con.createStatement();//
			//String modiPais = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = 'ArgentinaModif' WHERE COUNTRY_ID = 'AR' ";
			
			String modifPais = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID = ? ";
			PreparedStatement ps = con.prepareStatement(modifPais);// preparedStatement tiene dentro la funcionalidad executeUpdate
			String pais = "ArgentinaModif2";
			String codigo = "AR";
			
			//pasar parametros
			ps.setString(1, pais);
			ps.setString(2, codigo);
			
			System.out.println(modifPais);
			int rows = ps.executeUpdate();
			
			System.out.println("Has modificado un pais");
			
			//crear un objeto oracle Proc Almacendo -----> ES UNA MINI_APP
			//UN PROC ALMACENADO NO SE CREA EN JAVA SOLO EN ORACLE
			//CUANDO SE CREA, SE PUEDE BORRAR 
			String crearProcAlmacenado = "CREATE OR REPLACE PROCEDURE HR.Ver_NombrePais "
					+ "(PARAM_COD_PAIS IN varchar, PARAM_NOMBRE_PAIS OUT VARCHAR)" //INDICA QUE SE PASA UNA VAR DE ENTRADA TIPO VARCHAR(2)
					+ "AS "								//PARA EMPEZAR
					+ "BEGIN "							//INICIO DEL CUERPO DE LA APLICACION
					+ "   SELECT COUNTRY_NAME INTO PARAM_NOMBRE_PAIS"
					+ "   FROM HR.COUNTRIES "			//EN QUE TABLA VA HA HACER LA CONSULTA
					+ "   WHERE COUNTRY_ID = PARAM_COD_PAIS; "
					+ "END; ";
			//con.createStatement().execute(crearProcAlmacenado);
			
			//LAMAR DESDE JAVA A UN PROC ALMACENADO
			CallableStatement call =
						con.prepareCall("{call HR.Ver_NombrePais(?,?)}");
			
			//Preparamos el parametro de entrada codigo pais
			call.setString(1, codigo);
			
			//preparar el paraemtro de salida que es el nombre
			call.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			// ejecutar el proc almacenado
			call.executeQuery();
			
			//leer el valor almacenado String 
			String nombrePaisRecuperado = call.getString(2);
			System.out.printf("Nombre es %s es %s%n", codigo, nombrePaisRecuperado);
			
			
//			ResultSet rsCall = call.executeQuery();
			

			modificarPaises(con, "AR","XX");
			
			String crearTablaProducto = "CREATE TABLE HR.PRODUCTOS "
					+ "   (	ID_PRODUCTO NUMBER NOT NULL ENABLE PRIMARY KEY,"
					+ "	DESCRIPCION VARCHAR2(50 BYTE) NOT NULL ENABLE,"
					+ "	PRECIO NUMBER DEFAULT 0 NOT NULL ENABLE, "
					+ "	STOCK NUMBER DEFAULT 0 NOT NULL ENABLE) ";
			//con.createStatement().execute(crearTablaProducto);
			
			//insertar dos productos
			String insertProducto1 = "INSERT INTO HR.PRODUCTOS "
					+ " (ID_PRODUCTO,DESCRIPCION, PRECIO,STOCK) "
					+ " VALUES (1, 'Television', 1522.8, 5)";
			String insertProducto2 = "INSERT INTO HR.PRODUCTOS "
					+ " (ID_PRODUCTO,DESCRIPCION, PRECIO,STOCK) "
					+ " VALUES (2, 'Zapatos', 152.8, 20)";
			//con.createStatement().execute(insertProducto1);
			//con.createStatement().execute(insertProducto2);
			
			
			

			
			

		} catch (SQLException e) {
			System.out.println("Error conexion " + e.getMessage());
		}

	}
	
	public static void modificarPaises(Connection conexion,String... codigos) {	//String ... --> indica parametros variables, o sea, 
	//crear un contexto transaccional
	//en el que se ejecutan como un todo varias sentencias sql
	//si una falla deben fallar todas
		try {
			conexion.setAutoCommit(false);//especifico que debo hacer el commit manualmente
			
			String modifPais = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = COUNTRY_NAME" + " || ' modif'" 
								+ " WHERE COUNTRY_ID = ? ";
			PreparedStatement ps = conexion.prepareStatement(modifPais);
						
			for(String codigo:codigos) {
				ps.setString(1, codigo);
				ps.executeUpdate();
			}
			
			//debe ser la ultima linea antes del catch pues 
			//es la que indica que haga los cambios en la DB
			//antes de esta linea todos los cambios realizados no son reflejados en la base de datos, solo en el programa
			conexion.commit(); 	
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				conexion.rollback();
			}catch(SQLException e1) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
