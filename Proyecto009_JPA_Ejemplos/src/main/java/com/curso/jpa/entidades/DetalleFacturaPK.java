package com.curso.jpa.entidades;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Embeddable
public class DetalleFacturaPK {
	private int idFactura;
	private int lineaDetalle;
	
}

@Entity
class DetalleFactura{
	@EmbeddedId
	private DetalleFacturaPK id;
	
	private String detalle;
}



/**
 * 		Detalle de factura
 * 
 * 		Id_Factura  Linea  Detalle
 * 			1		  1     Lapiz
 * 			1         2     Zapato
 * 			2         1     SSS
 *          2         2     LAsdf
 * */
