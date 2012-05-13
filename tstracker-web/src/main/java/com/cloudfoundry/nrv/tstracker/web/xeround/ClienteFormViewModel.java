package com.cloudfoundry.nrv.tstracker.web.xeround;

import org.zkoss.bind.annotation.Command;

import com.cloudfoundry.nrv.tstracker.model.Cliente;
import com.cloudfoundry.nrv.tstracker.service.ClienteService;
import com.cloudfoundry.nrv.tstracker.util.BeansFactory;

public class ClienteFormViewModel {

	private ClienteService clienteService;

	private Cliente cliente = new Cliente();

	@Command
	public void submit() {
		System.out.println(this.cliente.toString());
		this.clienteService = BeansFactory.getClienteService();
		this.clienteService.persistirCliente(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}