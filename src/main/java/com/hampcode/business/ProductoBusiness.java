package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Producto;
import com.hampcode.model.repository.ProductoRepository;

@Named
public class ProductoBusiness implements Serializable{

	@Inject
	private ProductoRepository productoRepository; 
	
	@Transactional
	public Long insert(Producto entidad) throws Exception {
		return productoRepository.insert(entidad); 
	}

	@Transactional
	public Long update(Producto entidad) throws Exception {
		return productoRepository.update(entidad);
	}

	@Transactional
	public void delete(Producto entidad) throws Exception {
		productoRepository.delete(entidad);
	}


	public List<Producto> findAll() throws Exception {
		return productoRepository.findAll();
	}

	
	public Optional<Producto> findById(Long id) throws Exception {
		return productoRepository.findById(id);
	}

	
	public List<Producto> findByName(String name) throws Exception {
		return productoRepository.findByName(name);
	}
	
	private static final long serialVersionUID = 1L;


}
