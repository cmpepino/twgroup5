package com.curso.spring.entidades;

import java.util.Date;
import java.util.Objects;

public class Pedido {

	private Integer id;
	private String user;
	private String desc;
	private Date date;
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
		return "Pedido [id=" + id + ", cliente=" + user + ", producto=" + desc + ", date=" + date
				+ ", entregado=" + entregado + "]";
	}

}
