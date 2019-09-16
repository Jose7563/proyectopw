package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Producto;
import com.hampcode.model.repository.IProductoRepository;

@Named
public class ProductoBusiness implements IProductoBusiness<Producto>,Serializable{

	@Inject
	private IProductoRepository<Producto> productoRepository; 
	
	@Transactional
	@Override
	public Long insert(Producto entidad) throws Exception {
		return productoRepository.insert(entidad); 
	}

	@Transactional
	@Override
	public Long update(Producto entidad) throws Exception {
		return productoRepository.update(entidad);
	}

	@Transactional
	@Override
	public void delete(Producto entidad) throws Exception {
		productoRepository.delete(entidad);
	}

	@Override
	public List<Producto> findAll() throws Exception {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findById(Long id) throws Exception {
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> findByName(String name) throws Exception {
		return productoRepository.findByName(name);
	}
	
	private static final long serialVersionUID = 1L;


}
