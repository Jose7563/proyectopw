package com.hampcode.model.repository;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository<E> {
	
	
	
	public Long insert(E entidad) throws Exception ;
	
	
	public Long update(E entidad) throws Exception;
	
	
	public void delete(E entidad) throws Exception ;
	
	
	public List<E> findAll() throws Exception;
	
	
	public Optional<E> findById(Long id) throws Exception;
	
	
	public  List<E> findByName(String name) throws Exception;

}
