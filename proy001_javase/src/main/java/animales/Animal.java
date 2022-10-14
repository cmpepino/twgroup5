package animales;

public abstract class Animal {
	
	//**************ATRIBUTOS
	protected int legs;
	
	//*************Constructores
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	//*************Metodos
	public void walk() {
		System.out.println("Camino con mis " + legs + " patitas");
	}
	
	public abstract void eat();
	

}
