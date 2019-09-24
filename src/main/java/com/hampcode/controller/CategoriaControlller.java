package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ICategoriaBusiness;
import com.hampcode.model.entity.Categoria;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class CategoriaControlller implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		// Inject
		@Inject
		private ICategoriaBusiness<Categoria> categoriaBusiness;

		// Objetos a utilizar en la vista
		private Categoria categoria;  //NuevoCliente
		private List<Categoria> categorias; //Lista
		private Categoria categoriaSelect; //Categoria Seleccionado Editar
		private String filterName; // Criterio de Busqueda
		
		// metodos a utlizar en la vista

		@PostConstruct
		public void init() {
			categoria = new Categoria();
			categorias= new ArrayList<>();
			getAllCategorias();  // Ya deben estar cargados los clientes cuando cargaue la pagina 
		}

		public void getAllCategorias() {
			try {
				categorias = categoriaBusiness.findAll();
			} catch (Exception e) {
				Message.messageError("Error al cargar los categoriass :" + e.getMessage());
			}
		}

		public String newCategoria() {
			resetForm();              // crea un producto en blanco para ser inicializado 
			return "insertCategoria.xhtml";
		}

		public String listCategoria() {
			return "listCategoria.xhtml";
		}

		
		public String saveCategoria() {
			String view = "";
			try {

				if (categoria.getId() != null) {
					categoriaBusiness.update(categoria);
					Message.messageInfo("Registro actualizado exitosamente");
				} else {
					categoriaBusiness.insert(categoria);
					Message.messageInfo("Registro guardado exitosamente");

				}
				this.getAllCategorias();  // carga los productos
				resetForm();            // crea un nuevo producto
				view = "listCategoria";			// y lo redireccion a la lista 
			} catch (Exception e) {
				Message.messageError("Error Categoria :" + e.getStackTrace());
			}

			return view;
		}

		public String editCategoria() {
			String view = "";
			try {
				if (this.categoriaSelect != null) {
					this.categoria = categoriaSelect;

					view = "updateCategoria";// Vista actualizar
				} else {
					Message.messageInfo("Debe seleccionar un Categoria");
				}
			} catch (Exception e) {
				Message.messageError("Error Producto :" + e.getMessage());
			}

			return view;
		}

		
		public void searchCategoriaByName() {
			try {

				categorias = categoriaBusiness.findByName(this.filterName.trim());
				resetForm();
				if (categorias.isEmpty()) {
					Message.messageInfo("No se encontraron categorias");

				}

			} catch (Exception e) {
				Message.messageError("Error Categoria  :" + e.getMessage());
			}
		}

		
			
		
		public void selectCategoria(SelectEvent e) {
			this.categoriaSelect = (Categoria) e.getObject();
		}

		public void resetForm() {
			this.filterName = "";
			this.categoria = new Categoria();
		}
		
}
