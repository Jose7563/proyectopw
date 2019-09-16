package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import com.hampcode.business.IProductoBusiness;
import com.hampcode.model.entity.Producto;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class ProductoController implements Serializable {

	private static final long serialVersionUID = 1L;

	// Inject
	@Inject
	private IProductoBusiness<Producto> productoBusiness;

	// Objetos a utilizar en la vista
	private Producto producto;  //NuevoCliente
	private List<Producto> products; //ListaClientes
	private Producto productSelect; //Cliente Seleccionado Editar
	private String filterName; // Criterio de Busqueda

	// metodos a utlizar en la vista

	@PostConstruct
	public void init() {
		producto = new Producto();
		products = new ArrayList<Producto>();
		getAllProductos();  // Ya deben estar cargados los clientes cuando cargaue la pagina 
	}

	public void getAllProductos() {
		try {
			products = productoBusiness.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar los productos :" + e.getMessage());
		}
	}

	public String newProducto() {
		resetForm();              // crea un producto en blanco para ser inicializado 
		return "insertProduct.xhtml";
	}

	public String listProducto() {
		return "listProduct.xhtml";
	}

	
	public String saveProduct() {
		String view = "";
		try {

			if (producto.getId() != null) {
				productoBusiness.update(producto);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				productoBusiness.insert(producto);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllProductos();  // carga los clientes 
			resetForm();            // crea un nuevo cliente  
			view = "listProduct";			// y lo redireccion a la lista 
		} catch (Exception e) {
			Message.messageError("Error Producto :" + e.getStackTrace());
		}

		return view;
	}

	public String editProducto() {
		String view = "";
		try {
			if (this.productSelect != null) {
				this.producto = productSelect;

				view = "/producto/updateProduct";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Producto :" + e.getMessage());
		}

		return view;
	}

	
	public void searchProductByName() {
		try {

			products = productoBusiness.findByName(this.filterName.trim());
			resetForm();
			if (products.isEmpty()) {
				Message.messageInfo("No se encontraron productos");

			}

		} catch (Exception e) {
			Message.messageError("Error Producto  :" + e.getMessage());
		}
	}

	
	
	public void selectProducto(SelectEvent e) {
		this.productSelect = (Producto) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.producto = new Producto();
	}

	// getters y setters

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProducts() {
		return products;
	}

	public void setProducts(List<Producto> products) {
		this.products = products;
	}

	public Producto getProductSelect() {
		return productSelect;
	}

	public void setProductSelect(Producto productSelect) {
		this.productSelect = productSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	
	
	
	
	
	
	
	
	
	
}
