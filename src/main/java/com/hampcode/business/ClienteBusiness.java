package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Cliente;
import com.hampcode.model.repository.ClienteRepository;

@Named
public class ClienteBusiness implements  Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteRepository clienteRepository;

	@Transactional
	
	public Long insert(Cliente entidad) throws Exception {
		return clienteRepository.insert(entidad);

	}

	@Transactional
	public Long update(Cliente entidad) throws Exception {
		return clienteRepository.update(entidad);

	}

	@Transactional
	public void delete(Cliente entidad) throws Exception {
		 clienteRepository.delete(entidad);

	}

	
	public List<Cliente> findAll() throws Exception {

		return clienteRepository.findAll();
	}

	
	public Optional<Cliente> findById(Long id) throws Exception {
		
		return clienteRepository.findById(id);
	}

	
	public List<Cliente> findByName(String name) throws Exception {
		
		return clienteRepository.findByName(name);
	}

}
