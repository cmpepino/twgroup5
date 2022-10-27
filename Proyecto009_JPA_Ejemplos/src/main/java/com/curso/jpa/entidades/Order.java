package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO1_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "CURSO1_SEQ", allocationSize = 1)
	private Long orderId;
	@Column(name = "DESCRIPTION")
	private String descripcion;
	//NO ES EL MAPEO QUE QUIERO.
	//CUANDO LLAME AL CUSTOMER NO QUIERO SOLO EL ID
	/*@Column(name = "CUSTOMER_ID	")
	private Long idCliente;*/
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", //nombre de la columna fk en la tabla Order
				referencedColumnName = "ID")//nombre de la columna pk en la tabla Customer
	private Customer cliente;
	
	//Constructores
	public Order() {
		super();
	}
	public Order(Long orderId, String descripcion, Customer cliente) {
		super();
		this.orderId = orderId;
		this.descripcion = descripcion;
		this.cliente = cliente;
	}
	
	//Metodos
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Customer getCliente() {
		return cliente;
	}
	public void setCliente(Customer cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", descripcion=" + descripcion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}
	
}
