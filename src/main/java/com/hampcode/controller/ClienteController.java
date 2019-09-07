package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ClienteBusiness;
import com.hampcode.model.entity.Cliente;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	// Inject
	@Inject
	private ClienteBusiness clienteBusiness;

	// Objetos a utilizar en la vista
	private Cliente cliente;  //NuevoCliente
	private List<Cliente> clientes; //ListaClientes
	private Cliente clienteSelect; //Cliente Seleccionado Editar
	private String filterName; // Criterio de Busqueda

	// metodos a utlizar en la vista

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
		getAllClientes();  // Ya deben estar cargados los clientes cuando cargaue la pagina 
	}

	public void getAllClientes() {
		try {
			clientes = clienteBusiness.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar los clientes :" + e.getMessage());
		}
	}

	public String newCliente() {
		resetForm();              // crea un cliente en blanco para ser inicializado 
		return "insert.xhtml";
	}

	public String listCliente() {
		return "list.xhtml";
	}

	
	public String saveCliente() {
		String view = "";
		try {

			if (cliente.getId() != null) {
				clienteBusiness.update(cliente);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				clienteBusiness.insert(cliente);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllClientes();  // carga los clientes 
			resetForm();            // crea un nuevo cliente  
			view = "list";			// y lo redireccion a la lista 
		} catch (Exception e) {
			Message.messageError("Error Cliente :" + e.getStackTrace());
		}

		return view;
	}

	public String editCliente() {
		String view = "";
		try {
			if (this.clienteSelect != null) {
				this.cliente = clienteSelect;

				view = "update";// Vista
			} else {
				Message.messageInfo("Debe seleccionar un cliente");
			}
		} catch (Exception e) {
			Message.messageError("Error Cliente :" + e.getMessage());
		}

		return view;
	}

	
	public void searchProductByName() {
		try {

			clientes = clienteBusiness.findByName(this.filterName.trim());
			resetForm();
			if (clientes.isEmpty()) {
				Message.messageInfo("No se encontraron clientes");

			}

		} catch (Exception e) {
			Message.messageError("Error Cliente  :" + e.getMessage());
		}
	}

	public void selectCliente(SelectEvent e) {
		this.clienteSelect = (Cliente) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.cliente = new Cliente();
	}

	
	
	
	
	
	
	
	
	// getters y setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteSelect() {
		return clienteSelect;
	}

	public void setClienteSelect(Cliente clienteSelect) {
		this.clienteSelect = clienteSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	
}
