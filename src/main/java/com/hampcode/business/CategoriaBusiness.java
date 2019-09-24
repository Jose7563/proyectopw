package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Categoria;

import com.hampcode.model.repository.ICategoriaRepository;

@Named
public class CategoriaBusiness implements ICategoriaBusiness<Categoria>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoriaRepository<Categoria> categoriaRepository;

	@Transactional
	@Override
	public Long insert(Categoria entidad) throws Exception {
		return categoriaRepository.insert(entidad);

	}

	@Transactional
	@Override
	public Long update(Categoria entidad) throws Exception {
		return categoriaRepository.update(entidad);

	}

	@Transactional
	@Override
	public void delete(Categoria entidad) throws Exception {
		 categoriaRepository.delete(entidad);

	}

	@Override
	public List<Categoria> findAll() throws Exception {

		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> findById(Long id) throws Exception {
		
		return categoriaRepository.findById(id);
	}

	@Override
	public List<Categoria> findByName(String name) throws Exception {
		
		return categoriaRepository.findByName(name);
	}

}
