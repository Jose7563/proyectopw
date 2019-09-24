package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="boletas")
public class BoletaPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="cantidad_vendida")
	 private String cantidaVendida; 
	
	@ManyToOne
	@JoinColumn(name="producto_id", nullable=false)
	private Producto producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCantidaVendida() {
		return cantidaVendida;
	}

	public void setCantidaVendida(String cantidaVendida) {
		this.cantidaVendida = cantidaVendida;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	} 
	
	
}
