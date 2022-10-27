package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEES", schema = "HR")
public class Empleado implements Serializable {

	// Atributos
	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	private String nombre;
	@Column(name = "LAST_NAME")
	private String apellido;
	@Column(name = "PHONE-NUMBER")
	private String telefono;
	@Column(name = "EMAIL")
	private String correoElectronico;
	@Temporal(TemporalType.DATE) // javax.persistence.Temporal
	@Column(name = "HIRE_DATE")
	private Date fechaContratacion;
	@Column(name = "SALARY")
	private Integer salario;
	@Column(name = "COMMISSION_PCT")
	private Double comisiones;
	@Column(name = "JOB_ID")
	private String idTrabajo;
	@Column(name = "MANAGER_ID")
	private Integer idJefe;
	@Column(name = "DEPARTAMENT_ID")
	private Integer idDepartamento;

	// Constructores
	public Empleado() {
		super();
	}

	public Empleado(Long id, String nombre, String apellido, String telefono, String correoElectronico,
			Date fechaContratacion, Integer salario, Double comisiones, String idTrabajo, Integer idJefe,
			Integer idDepartamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.fechaContratacion = fechaContratacion;
		this.salario = salario;
		this.comisiones = comisiones;
		this.idTrabajo = idTrabajo;
		this.idJefe = idJefe;
		this.idDepartamento = idDepartamento;
	}

	// Metodos

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public Double getComisiones() {
		return comisiones;
	}

	public void setComisiones(Double comisiones) {
		this.comisiones = comisiones;
	}

	public String getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(String idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Integer getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(Integer idJefe) {
		this.idJefe = idJefe;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
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
		Empleado other = (Empleado) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
