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
public class ClienteBusiness implements IClienteBusiness<Cliente>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteRepository clienteRepository;

	@Transactional
	@Override
	public Long insert(Cliente entidad) throws Exception {
		return clienteRepository.insert(entidad);

	}

	@Transactional
	@Override
	public Long update(Cliente entidad) throws Exception {
		return clienteRepository.update(entidad);

	}

	@Transactional
	@Override
	public void delete(Cliente entidad) throws Exception {
		 clienteRepository.delete(entidad);

	}

	@Override
	public List<Cliente> findAll() throws Exception {

		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) throws Exception {
		
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> findByName(String name) throws Exception {
		
		return clienteRepository.findByName(name);
	}

}
