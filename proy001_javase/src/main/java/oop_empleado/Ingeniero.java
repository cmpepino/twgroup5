package oop_empleado;

public class Ingeniero extends Empleado {
	private String proyecto;
	
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getProyecto() {
		return proyecto;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + " Su proyecto " + proyecto;
	}
	
}
