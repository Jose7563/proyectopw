package com.hampcode.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ProveedorBusiness;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.util.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProveedorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Proveedor proveedor; 
	private List<Proveedor> proveedores;
	private Proveedor proveedorSelect;
	private String filterName; 
	
	@Inject
	private ProveedorBusiness proveedorBusiness; 
	
	
	
	@PostConstruct
	public void init() {
		
		proveedor= new Proveedor(); 
		proveedores= new ArrayList<>(); 
		
		getAllProveedores();
		
	}
	
	
	
	public void getAllProveedores() {
		
		try {
			proveedores= proveedorBusiness.findAll(); 

		} catch (Exception e) {
			Message.messageError("NO hay registro de Porveedores" + e.getMessage());
		}
		
	}
	
	
	public String newProveedor() {
		return "insertProveedor.xhtml"; 
	}
	
	public String listProveedor() {
		return "listProveedor.xhtml"; 
	}
	
	public String saveProduct() {
		String view = "";
		try {

			if (proveedor.getId() != null) {
				proveedorBusiness.update(proveedor);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				proveedorBusiness.insert(proveedor);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllProveedores();  
			resetForm();            //
			view = "listProveedor";			//  
		} catch (Exception e) {
			Message.messageError("Error Proveedor :" + e.getStackTrace());
		}

		return view;
	}
	
	
	public String editProducto() {
		String view = "";
		try {
			if (this.proveedorSelect != null) {

				this.proveedor = proveedorSelect;

				view = "/proveedor/updateProveedor";// Vista actualizar
			} else {
				Message.messageInfo("Debe seleccionar un proveedor");
			}
		} catch (Exception e) {
			Message.messageError("Error Proveedor :" + e.getMessage());
		}

		return view;
	}

	
	public void searchProveedortByName() {
		try {

			proveedores = proveedorBusiness.findByName(this.filterName.trim());
			resetForm();
			if (proveedores.isEmpty()) {
				Message.messageInfo("No se encontraron proveedores");

			}

		} catch (Exception e) {
			Message.messageError("Error Proveedor :" + e.getMessage());
		}
	}
	
	
	public void selectProveedor(SelectEvent e) {
		this.proveedorSelect = (Proveedor) e.getObject();
	}
	
	public void resetForm() {
		this.filterName = "";
		this.proveedor = new Proveedor();
	}


	
	
	
	
 /////////7
	
	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public List<Proveedor> getProveedores() {
		return proveedores;
	}



	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}



	public Proveedor getProveedorSelect() {
		return proveedorSelect;
	}



	public void setProveedorSelect(Proveedor proveedorSelect) {
		this.proveedorSelect = proveedorSelect;
	}



	public String getFilterName() {
		return filterName;
	}



	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
	
	
	

	
	

	
	
}
