package com.terminaltics.tstracker.service;

import java.util.List;

import com.terminaltics.tstracker.dao.ClienteDAO;
import com.terminaltics.tstracker.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
        @Transactional(rollbackFor = Throwable.class)
	public void save(Cliente cliente) {
		Cliente dbCliente = this.findById(cliente.getId());
		if(dbCliente == null) {
			this.persist(dbCliente);
		} else {
			this.merge(cliente);
		}
		
	}

}
