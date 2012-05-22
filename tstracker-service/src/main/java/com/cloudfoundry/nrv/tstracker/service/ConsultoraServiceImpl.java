package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.ConsultoraDAO;

/**
 * Implementacion del servicio de la entidad Consultora
 * 
 * @author asalas
 * 
 */
public class ConsultoraServiceImpl implements ConsultoraService {

	private ConsultoraDAO consultoraDAO;

	public ConsultoraDAO getConsultoraDAO() {
		return consultoraDAO;
	}

	public void setConsultoraDAO(ConsultoraDAO consultoraDAO) {
		this.consultoraDAO = consultoraDAO;
	}
}
