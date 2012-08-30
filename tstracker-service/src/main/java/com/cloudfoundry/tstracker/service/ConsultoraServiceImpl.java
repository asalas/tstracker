package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.dao.ConsultoraDAO;
import com.cloudfoundry.tstracker.model.Consultoria;

/**
 * Implementacion del servicio de la entidad Consultoria
 * 
 * @author asalas
 * 
 */
public class ConsultoraServiceImpl implements ConsultoraService {

	private ConsultoraDAO consultoraDAO;

	@Override
	public void persist(Consultoria consultora) {
		this.consultoraDAO.persist(consultora);
	}

	@Override
	public void merge(Consultoria consultora) {
		this.consultoraDAO.merge(consultora);
	}

	@Override
	public void save(Consultoria consultora) {
		Consultoria dbConsultora = this.findById(consultora.getId());
		if(dbConsultora == null) {
			this.persist(consultora);			
		} else {
			this.merge(consultora);
		}
	}

	@Override
	public void remove(Consultoria consultora) {
		this.consultoraDAO.remove(consultora);		
	}

	@Override
	public Consultoria findById(Long consultoraId) {
		return this.consultoraDAO.findById(consultoraId);
	}

	@Override
	public List<Consultoria> getAll() {
		return this.consultoraDAO.findAll();
	}
	
	public ConsultoraDAO getConsultoraDAO() {
		return consultoraDAO;
	}

	public void setConsultoraDAO(ConsultoraDAO consultoraDAO) {
		this.consultoraDAO = consultoraDAO;
	}
}