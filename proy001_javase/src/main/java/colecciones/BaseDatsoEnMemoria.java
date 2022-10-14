package colecciones;

import java.util.*;

public class BaseDatsoEnMemoria {
	private static Map<Integer, Alumno> tablaAlumnos;

	static {
		tablaAlumnos = new HashMap<Integer, Alumno>();
	}

	public static Alumno getAlumnoById(int id) {
		return tablaAlumnos.get(id);
	}

	public static void addAlumnos(Alumno a) {
		tablaAlumnos.put(a.getId(), a);
	}

	public static void grabarBD() {
		// ir a la base datos y grabar la tabla
		Collection<Alumno> alumnos = tablaAlumnos.values();
		for (Alumno a : alumnos) {
			System.out.println("Inserto en Bd" + a);
		}
	}

}

class Alumno {
	private Integer id;
	private String nombre;

	public Alumno(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

}
