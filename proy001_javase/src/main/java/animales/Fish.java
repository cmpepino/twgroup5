package animales;

public class Fish extends Animal implements Pet{
	//atributos
	private String name;
	
	//constructores
	public Fish(String n) {
		super(0);
		this.name = n;
	}
	public Fish() {
		this(null);
	}
	
	//metodos
	public void eat() {
		System.out.println("me alimento con pienso para peces");
	}
	@Override
	public void walk() {
		System.out.println("Yo no camino :( Los peces nadan");
	}
	
	//metodos de la clase abstracta
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return "Mi nombre es " + name;
	}
	
	public void play() {
		System.out.println("Yo no juego. te ignoro jajajaja");
	}
	

}
