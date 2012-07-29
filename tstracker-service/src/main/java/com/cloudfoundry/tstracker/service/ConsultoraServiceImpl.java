package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.dao.ConsultoraDAO;
import com.cloudfoundry.tstracker.model.Consultora;

/**
 * Implementacion del servicio de la entidad Consultora
 * 
 * @author asalas
 * 
 */
public class ConsultoraServiceImpl implements ConsultoraService {

	private ConsultoraDAO consultoraDAO;

	@Override
	public void persist(Consultora consultora) {
		this.consultoraDAO.persist(consultora);
	}

	@Override
	public void merge(Consultora consultora) {
		this.consultoraDAO.merge(consultora);
	}

	@Override
	public void save(Consultora consultora) {
		Consultora dbConsultora = this.findById(consultora.getId());
		if(dbConsultora == null) {
			this.persist(consultora);			
		} else {
			this.merge(consultora);
		}
	}

	@Override
	public void remove(Consultora consultora) {
		this.consultoraDAO.remove(consultora);		
	}

	@Override
	public Consultora findById(Long consultoraId) {
		return this.consultoraDAO.findById(consultoraId);
	}

	@Override
	public List<Consultora> getAll() {
		return this.consultoraDAO.findAll();
	}
	
	public ConsultoraDAO getConsultoraDAO() {
		return consultoraDAO;
	}

	public void setConsultoraDAO(ConsultoraDAO consultoraDAO) {
		this.consultoraDAO = consultoraDAO;
	}
}