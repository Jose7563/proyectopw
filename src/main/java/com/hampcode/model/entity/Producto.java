package com.hampcode.model.entity;

import java.math.BigDecimal;
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
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	@Column(name = "nombre")
	private String nombre; 
	
	@Column(name = "ubicacion")
	private String ubicacion;
	
	@Column(name = "cantidad")
	private Long cantidad;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_vencimiento")
	private Date fecha_venciminento;
	
	@Column(name = "precio_unitario")
	private BigDecimal  precio_unitario;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria; 

	
	
	
	
	
	
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha_venciminento() {
		return fecha_venciminento;
	}

	public void setFecha_venciminento(Date fecha_venciminento) {
		this.fecha_venciminento = fecha_venciminento;
	}

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	
	

}
