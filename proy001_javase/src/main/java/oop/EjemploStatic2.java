package oop;
import java.sql.Connection;

public class EjemploStatic2 {
	
	public static final String USER_DB = "ALFRESCO";
	public static final String URL_DB = "asdfadg";
	
	/*
	 * No queremos que se instancie objetos de la clase EjemploStatic2
	 * se declara el constructor private
	 */
	
	private EjemploStatic2() {
		
	} 
	
	public static Connection getConection() {
		return null;
	}

}
