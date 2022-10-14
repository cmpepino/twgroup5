package oop;

public class Cliente {
	private static final double DESCUENTO_MAX = 30;
		
	private String nombre;
	
	public void verDatos() {
		System.out.println("... los datoss del cliente");
		
	}
	
	public void hazAlgo() {
		System.out.println("trabajando ...");
	}
	
}

final class ClienteVIP extends Cliente{

	@Override
	public void verDatos() {
		// TODO Auto-generated method stub
		super.verDatos();
	}
	
	@Override
	public void hazAlgo() {
		// TODO Auto-generated method stub
		 
	}
	
}
//error de compilacion
/*
class ClienteExtraVIP extends ClienteVIP{
	
}*/
