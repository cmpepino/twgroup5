package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "CURSO_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	// @Column(name ="CUSTRECORD_RECID")
	// private Long recordId;
	// se utilizo el de abajo para recibir no solo el
	// recordID si no todos los datos que estan enlazados con el dato que se pide
	@OneToOne
	@JoinColumn(name = "CUSTRECORD_RECID") // forma de decir que es la foreing key
	private Record record;

	// atributo con la lista de todos los pedidos
	@OneToMany(mappedBy = "cliente",
			   fetch = FetchType.LAZY) //mappedBy con el nombre del atributo que tiene el FK
	private Collection<Order> pedidos;

	public Customer() {
		super();
	}

	public Customer(Integer id, String customerName, Record record) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.record = record;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Collection<Order> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Order> pedidos) {
		this.pedidos = pedidos;
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}

	// en el string no se llama las foreing Key para evitar la aparicion de bucles
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + "]";
	}

}
