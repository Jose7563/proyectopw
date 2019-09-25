package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Proveedor;

@Named
public class ProveedorRepository implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em; 
	
	
	public Long insert(Proveedor entidad) throws Exception {
		em.persist(entidad);
		return entidad.getId();
	}

	public Long update(Proveedor entidad) throws Exception {
		em.merge(entidad);
		return entidad.getId();
	}

	public void delete(Proveedor entidad) throws Exception {
		em.remove(entidad);
	}

	public List<Proveedor> findAll() throws Exception {
		List<Proveedor> products = new ArrayList<>();

		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor pr", Proveedor.class);
		products = query.getResultList();

		return products;
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

		List<Proveedor> products;

		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor pr WHERE pr.nombreEmpresa LIKE ?1", Proveedor.class);
		query.setParameter(1, "%" + name + "%");
		products = query.getResultList();

		return products;
	}

	
	
	
	

}
