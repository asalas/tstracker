package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.ClienteDAO;
import com.cloudfoundry.nrv.tstracker.model.Cliente;

public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO clienteDAO;

	@Override
	public void persistirCliente(Cliente cliente) {
		this.clienteDAO.persist(cliente);
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
}
