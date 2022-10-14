package modulo6_equals;

import java.util.Objects;

public class Cliente {
	
	//atributos
	private int id;
	private String nombre;
	
	//Constructor
	public Cliente(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	//Metodo(Getters)
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}
	
	
	
}
