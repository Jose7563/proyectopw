package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Cliente;


@Named
public class ClienteRepository implements RepositoryBase<Cliente>, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	@Override
	public void insert(Cliente entidad) throws Exception {
		em.persist(entidad);

	}

	@Override
	public void update(Cliente entidad) throws Exception {
		em.merge(entidad);

	}

	@Override
	public void delete(Cliente entidaD) throws Exception {
		em.remove(entidaD);

	}

	@Override
	public List<Cliente> findAll() throws Exception {

		List<Cliente> clientes = new ArrayList<>(); // creo una lista 
		TypedQuery<Cliente> query= em.createQuery("FROM Cliente c", Cliente.class);
		  clientes=  query.getResultList();

		return clientes;
	}

	@Override
	public Optional<Cliente> findById(Long id) throws Exception {
		
		Cliente clientefind; 
		
		TypedQuery<Cliente> query= em.createQuery("FROM Cliente c WHERE c.id=?1", Cliente.class);
		query.setParameter(1,id); 
		
		clientefind= query.getSingleResult();
		return Optional.of(clientefind);
	}

	@Override
	public List<Cliente> findByName(String name) throws Exception {
		
		List<Cliente> clientes= new ArrayList<>(); 
		
		TypedQuery<Cliente> query= em.createQuery("FROM Cliente c WHERE c.nombre LIKE ?1", Cliente.class);
		query.setParameter(1, "%"+name+"%"); 
		 clientes=  query.getResultList();
		return clientes;
	}

}
