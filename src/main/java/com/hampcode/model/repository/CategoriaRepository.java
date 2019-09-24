package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Categoria;

@Named
public class CategoriaRepository implements ICategoriaRepository<Categoria>, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	@Override
	public Long insert(Categoria entidad) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entidad);
		return entidad.getId();
	}

	@Override
	public Long update(Categoria entidad) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entidad);
		return entidad.getId();
	}

	@Override
	public void delete(Categoria entidad) throws Exception {
		// TODO Auto-generated method stub
		em.remove(entidad);
	}

	@Override
	public List<Categoria> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Categoria> categorias = new ArrayList<Categoria>();

		TypedQuery<Categoria> query = em.createQuery("FROM Categoria c ", Categoria.class);
		categorias = query.getResultList();

		return categorias;
		}

	@Override
	public Optional<Categoria> findById(Long id) throws Exception {
		// TODO Auto-generated method stub

		Categoria categoria;

		TypedQuery<Categoria> query = em.createQuery("FROM Categoria c WHERE c.id=?1", Categoria.class);
		query.setParameter(1, id);

		categoria = query.getSingleResult();

		return Optional.of(categoria);
	}

	@Override
	public List<Categoria> findByName(String name) throws Exception {
		// TODO Auto-generated method stub

		List<Categoria> categorias;

		TypedQuery<Categoria> query = em.createQuery("FROM Categoria c WHERE c.nombre LIKE ?1", Categoria.class);
		query.setParameter(1, "%" + name + "%");
		categorias = query.getResultList();

		return categorias;
	}

}
