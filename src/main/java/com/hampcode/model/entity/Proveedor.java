package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name = "proveedores")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	@Column(name="nombre_empresa")
	 private String nombreEmpresa; 
	
	@Column(name="email")
	 private String email; 
	
//	@Size(min=9, message = "El celular debe tener 9 digitos")
	@Column(name="telefono")
	 private Long telefono; 
	
//	@Size(min = 11 ,message = "EL valor del ruc  ingresado debe tener 11 digitos")
	@Column(name="ruc")
	 private Long ruc;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono( Long telefono) {
		this.telefono = telefono;
	}

	public Long getRuc() {
		return ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	} 
	
	
	
	

	
	 
	

}
