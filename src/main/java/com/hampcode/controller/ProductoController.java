package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.CategoriaBusiness;
import com.hampcode.business.ProductoBusiness;
import com.hampcode.model.entity.Categoria;
import com.hampcode.model.entity.Producto;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class ProductoController implements Serializable {

	private static final long serialVersionUID = 1L;

	// Inject
	@Inject
	private ProductoBusiness productoBusiness;
	@Inject
	private CategoriaBusiness categoriaBusiness;

	// Objetos a utilizar en la vista
	private Producto producto;  //NuevoCliente
	private List<Producto> products; //ListaClientes
	private Producto productSelect; //Cliente Seleccionado Editar
	private String filterName; // Criterio de Busquedap
	private String filterUbicacion; 
	
	private Categoria categoria;  
	private List<Categoria> categorias; 

	// metodos a utlizar en la vista

	@PostConstruct
	public void init() {
		producto = new Producto();
		categoria=new Categoria();
		categorias = new ArrayList<>();
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
		
		
		try {
			this.categorias= categoriaBusiness.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "insertProduct.xhtml";
	}

	public String listProducto() {
		return "listProduct.xhtml";
	}

	
	public String saveProduct() {
		String view = "";
		try {

			if (producto.getId() != null) {
				producto.setCategoria(categoria);
				productoBusiness.update(producto);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				producto.setCategoria(categoria);
				productoBusiness.insert(producto);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllProductos();  // carga los productos
			resetForm();            // crea un nuevo producto
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
				producto.setCategoria(categoria);

				this.producto = productSelect;

				view = "/producto/updateProduct";// Vista actualizar
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
	
	public void searchByUbicacion() {
		try {

			products = productoBusiness.findByUbicacion(this.filterUbicacion.trim());
			resetForm();
			if (products.isEmpty()) {
				Message.messageInfo("No se encontraron ");

			}

		} catch (Exception e) {
			Message.messageError("Error Producto  :" + e.getMessage());
		}
		
	}

	
	
	public String detailProduct() {
		String view="/producto/detalleProduct";
				return view ;
	}
	
	public void selectProducto(SelectEvent e) {
		this.productSelect = (Producto) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.filterUbicacion = ""; 
		this.producto = new Producto();
	}
	
	
	
	

	// ************ getters y setters **************+

	

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getFilterUbicacion() {
		return filterUbicacion;
	}

	public void setFilterUbicacion(String filterUbicacion) {
		this.filterUbicacion = filterUbicacion;
	}

	
	
	
	
	
	
	
	
	
	
}
