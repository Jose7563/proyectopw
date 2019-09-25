package com.hampcode.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.ProductoBusiness;
import com.hampcode.business.StockBusiness;
import com.hampcode.model.entity.Producto;
import com.hampcode.model.entity.Stock;
import com.hampcode.util.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class StockController implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductoBusiness productoBusiness;
	@Inject
	private StockBusiness stockBusiness; 
	private Stock stock;
	private List<Stock> stocks; 
	private List<Producto> products; 
	private Long filter; 
	
	
	
	@PostConstruct
	public void init() {
		stocks = new ArrayList<>();
		products= new ArrayList<Producto>(); 
		getAllProductos();
		
	}
	
	public void getAllProductos() {
		try {
			products = productoBusiness.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar los productos :" + e.getMessage());
		}
	}
	
	
	public void searchProductByCantidad() {
//		try {

			try {
				stocks = stockBusiness.findByCantidad(this.filter);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			resetForm();
//			if (products.isEmpty()) {
//				Message.messageInfo("No se encontraron productos");
//
//			}
//
//		} catch (Exception e) {
//			Message.messageError("Error Producto  :" + e.getMessage());
//		}
//	}
	
	
	}
	
	public void resetForm() {
		this.filter = null;
		this.stock = new Stock();
	}
	
	
	
}
