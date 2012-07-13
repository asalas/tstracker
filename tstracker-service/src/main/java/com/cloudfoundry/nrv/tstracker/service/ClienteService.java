package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.model.Cliente;

public interface ClienteService {

	public void persist(Cliente cliente);
	
	public void merge(Cliente cliente);
	
	public void save(Cliente cliente);
	
	public void remove(Cliente cliente);
	
	public Cliente findById(Long clienteId);
	
	public List<Cliente> getAll();
}
