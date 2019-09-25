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
import com.hampcode.model.entity.Stock;
@Named
public class StockRepository  implements Serializable{


	@PersistenceContext(unitName = "pwPU")
	private EntityManager em ; 
	
	
	public Long insert(Stock entidad) throws Exception {
		em.persist(entidad);
		return entidad.getId();
	}

	
	public Long update(Stock entidad) throws Exception {
		em.merge(entidad);
		return entidad.getId();
	}

	
	public void delete(Stock entidad) throws Exception {
		em.remove(entidad);
	}

	
//	public List<Stock> findAll() throws Exception {
//		List<Stock> stocks=new ArrayList<Stock>();
//		
//		TypedQuery<Stock> query= em.createQuery("FROM Stock s ", Stock.class);
//		stocks =query.getResultList();
//		
//		return products;
//	}

	
//	public Optional<Producto> findById(Long id) throws Exception {
//		
//		Producto product; 
//		
//		TypedQuery<Producto> query= em.createQuery("FROM Producto p WHERE p.id=?1", Producto.class);
//		 query.setParameter(1,id); 
//		
//		product=  query.getSingleResult();
//		
//		
//		
//		return Optional.of(product);
//	}
//
//	
	public List<Stock> findByCantidad(Long cantidad) throws Exception {
		
		List<Stock> stocks;
		
		TypedQuery<Stock> query= em.createQuery("FROM Stock st WHERE st.cantidadFinal  = ?1", Stock.class);
		query.setParameter(1, cantidad);
		stocks= query.getResultList();
		
		return stocks;
	}
	
	
	
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	

}
