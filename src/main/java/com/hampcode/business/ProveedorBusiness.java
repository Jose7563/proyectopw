package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Proveedor;
import com.hampcode.model.repository.ProveedorRepository;

@Named
public class ProveedorBusiness implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ProveedorRepository proveedorRepository;

	@Transactional
	public Long insert(Proveedor entidad) throws Exception {
		return proveedorRepository.insert(entidad);
	}

	@Transactional
	public Long update(Proveedor entidad) throws Exception {
		return proveedorRepository.update(entidad);
	}

	@Transactional
	public void delete(Proveedor entidad) throws Exception {
		proveedorRepository.delete(entidad);
	}

	public List<Proveedor> findAll() throws Exception {
		return proveedorRepository.findAll();
	}

//	public Optional<Producto> findById(Long id) throws Exception {
//
//		Producto product;
//
//		TypedQuery<Producto> query = em.createQuery("FROM Producto p WHERE p.id=?1", Producto.class);
//		query.setParameter(1, id);
//
//		product = query.getSingleResult();
//
//		return Optional.of(product);
//	}

	public List<Proveedor> findByName(String name) throws Exception {
		return proveedorRepository.findByName(name);
	}

}
