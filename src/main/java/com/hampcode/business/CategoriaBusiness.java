package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Categoria;
import com.hampcode.model.repository.CategoriaRepository;

@Named
public class CategoriaBusiness implements  Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;

	@Transactional
	public Long insert(Categoria entidad) throws Exception {
		return categoriaRepository.insert(entidad);

	}

	@Transactional
	public Long update(Categoria entidad) throws Exception {
		return categoriaRepository.update(entidad);

	}

	@Transactional
	public void delete(Categoria entidad) throws Exception {
		 categoriaRepository.delete(entidad);

	}

	
	public List<Categoria> findAll() throws Exception {

		return categoriaRepository.findAll();
	}

	
	public Optional<Categoria> findById(Long id) throws Exception {
		
		return categoriaRepository.findById(id);
	}

	
	public List<Categoria> findByName(String name) throws Exception {
		
		return categoriaRepository.findByName(name);
	}

}
