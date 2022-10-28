package com.curso.mercado.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTOS")
public class ProductoEntity implements Serializable {

	// Atributos
	@Id
	@Column(name = "ID_PRODUCTO")
	private Integer idProducto;
	@Column(name = "DESCRIPCION")
	private String descripProducto;
	@Column(name = "PRECIO")
	private Double precioProducto;
	@Column(name = "STOCK")
	private Integer stockProducto;

	// Constructores

	public ProductoEntity() {
		super();
	}

	public ProductoEntity(Integer idProducto, String descripProducto, Double precioProducto) {
		super();
		this.idProducto = idProducto;
		this.descripProducto = descripProducto;
		this.precioProducto = precioProducto;
		this.stockProducto = 5;
	}

	// Metodos

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripProducto() {
		return descripProducto;
	}

	public void setDescripProducto(String descripProducto) {
		this.descripProducto = descripProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Integer getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoEntity other = (ProductoEntity) obj;
		return Objects.equals(idProducto, other.idProducto);
	}

	@Override
	public String toString() {
		return "ProductoEntity [idProducto=" + idProducto + ", descripProducto=" + descripProducto + ", precioProducto="
				+ precioProducto + ", stockProducto=" + stockProducto + "]";
	}

}
