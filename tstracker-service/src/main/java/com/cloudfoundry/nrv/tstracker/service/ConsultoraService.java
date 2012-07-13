package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.model.Consultora;

/**
 * Servicio de la entidad Consultora
 * 
 * @author asalas
 * 
 */
public interface ConsultoraService {
	
	public void persist(Consultora consultora);
	
	public void merge(Consultora consultora);
	
	public void save(Consultora consultora);
	
	public void remove(Consultora consultora);
	
	public Consultora findById(Long consultoraId);
	
	public List<Consultora> getAll();
}
