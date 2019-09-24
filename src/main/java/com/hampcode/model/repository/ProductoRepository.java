package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Producto;
@Named
public class ProductoRepository  implements Serializable{


	@PersistenceContext(unitName = "pwPU")
	private EntityManager em ; 
	
	
	public Long insert(Producto entidad) throws Exception {
		em.persist(entidad);
		return entidad.getId();
	}

	
	public Long update(Producto entidad) throws Exception {
		em.merge(entidad);
		return entidad.getId();
	}

	
	public void delete(Producto entidad) throws Exception {
		em.remove(entidad);
	}

	
	public List<Producto> findAll() throws Exception {
		List<Producto> products=new ArrayList<Producto>();
		
		TypedQuery<Producto> query= em.createQuery("FROM Producto p ", Producto.class);
		products =query.getResultList();
		
		return products;
	}

	
	public Optional<Producto> findById(Long id) throws Exception {
		
		Producto product; 
		
		TypedQuery<Producto> query= em.createQuery("FROM Producto p WHERE p.id=?1", Producto.class);
		 query.setParameter(1,id); 
		
		product=  query.getSingleResult();
		
		
		
		return Optional.of(product);
	}

	
	public List<Producto> findByName(String name) throws Exception {
		
		List<Producto> products;
		
		TypedQuery<Producto> query= em.createQuery("FROM Producto p WHERE p.nombre LIKE ?1", Producto.class);
		query.setParameter(1, "%"+ name+ "%");
		 products= query.getResultList();
		
		return products;
	}
	
	
	
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	

}
