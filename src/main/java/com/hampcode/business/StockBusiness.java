package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Categoria;
import com.hampcode.model.entity.Stock;
import com.hampcode.model.repository.CategoriaRepository;
import com.hampcode.model.repository.StockRepository;

@Named
public class StockBusiness implements  Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private StockRepository stockRepository;

	@Transactional
	public Long insert(Stock entidad) throws Exception {
		return stockRepository.insert(entidad);

	}

	@Transactional
	public Long update(Stock entidad) throws Exception {
		return stockRepository.update(entidad);

	}

	@Transactional
	public void delete(Stock entidad) throws Exception {
		stockRepository.delete(entidad);

	}

	public List<Stock> findByCantidad(Long cantidad) throws Exception {
		return stockRepository.findByCantidad(cantidad);
	}

	
//	public Optional<Categoria> findById(Long id) throws Exception {
//		
//		return categoriaRepository.findById(id);
//	}
//
//	
//	public List<Categoria> findByName(String name) throws Exception {
//		
//		return categoriaRepository.findByName(name);
//	}

}
