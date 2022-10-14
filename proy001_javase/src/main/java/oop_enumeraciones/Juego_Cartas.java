package oop_enumeraciones;

public class Juego_Cartas {
	Carta c1 = new Carta(Palos.OROS,2);
	
	System.out.println(Palos.OROS);
	System.out.println(Palos.OROS.ordinal());
	
	Palos [] valores = Palos.values();
	System.out.println("... los palos son ");
	
	
}
