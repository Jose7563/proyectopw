package com.hampcode.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stocks")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name="cantidad_inicial")
	private Long cantidadInicial; 
	 
	
	@Column(name="cantidad_final")
	private Long cantidadFinal; 
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Producto producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Long getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(Long cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public Long getCantidadFinal() {
		return cantidadFinal;
	}

	public void setCantidadFinal(Long cantidadFinal) {
		this.cantidadFinal = cantidadFinal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	} 
	
	
	

}
