package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.dao.ClienteDAO;
import com.cloudfoundry.tstracker.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService {

        @Autowired
	private ClienteDAO clienteDAO;

	@Override
	public Cliente findById(Long clienteId) {
		return this.clienteDAO.findById(clienteId);
	}
	
	@Override
	public List<Cliente> getAll() {
		return this.clienteDAO.findAll();
	}
	
	@Override
	public void merge(Cliente cliente) {
		this.clienteDAO.merge(cliente);		
	}
	
	@Override
	public void persist(Cliente cliente) {
		this.clienteDAO.persist(cliente);		
	}
	
	@Override
	public void remove(Cliente cliente) {
		this.clienteDAO.remove(cliente);		
	}
	
	@Override
	public void save(Cliente cliente) {
		Cliente dbCliente = this.findById(cliente.getId());
		if(dbCliente == null) {
			this.persist(dbCliente);
		} else {
			this.merge(cliente);
		}
		
	}

}
