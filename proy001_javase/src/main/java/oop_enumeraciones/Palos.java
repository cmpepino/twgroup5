package oop_enumeraciones;

public 	enum Palos {
	OROS, BASTOS, PICAS, COPAS
}


//enum avanzadas
enum ModelosCoches{
	BASICO("Solo tiene motro y rueda"), // ModelosCoches.Basico = new ModelosCoches
	MEDIO("Tiene aire acondicionado"), 
	SUPERIOR("con navegador");
	
	//ATRIBUTOS
	private String descripcion;
	//CONSTRUCTORES
	private ModelosCoches(String s) {
		this.descripcion = s;
	}
	//METODOS
	public String getDescripcion() {
		return descripcion;
	}
}