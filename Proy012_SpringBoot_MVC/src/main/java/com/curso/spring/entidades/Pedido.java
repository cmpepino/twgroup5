package com.curso.spring.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pedido implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PED_SEQ")
	@SequenceGenerator(sequenceName = "PEDIDO_SEQ", name = "PED_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USUARIO")
	private String user;

	@Column(name = "DESCRIPCION")
	@NotNull
	@Size(min = 2)
	private String desc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_PEDIDO")
	private Date date;

	@Column(name = "ENTREGADO")
	private boolean entregado;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, String cliente, String producto, Date date, boolean entregado) {
		super();
		this.id = id;
		this.user = cliente;
		this.desc = producto;
		this.date = date;
		this.entregado = entregado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String cliente) {
		this.user = cliente;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String producto) {
		this.desc = producto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + user + ", producto=" + desc + ", date=" + date + ", entregado="
				+ entregado + "]";
	}

}
