package animales;

public class Cat extends Animal implements Pet {
	//atributos
	private String name;
	//Constructores
	public Cat(String n) {
		super(4);
		this.name = n;		
	}
	public Cat() {
		this(null);
	}
	//metodos
	@Override
	public void eat() {
		System.out.println("Como pienso para gatos");
	}
	
	//Metodos de la clase abstracta
	public String getName() {
		return "Mi nombre es" + name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public void play() {
		System.out.println("Juego persiguiendo cosas y arrañando todo");
	}
	
	
}
