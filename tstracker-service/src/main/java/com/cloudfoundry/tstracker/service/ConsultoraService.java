package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.model.Consultoria;

/**
 * Servicio de la entidad Consultoria
 * 
 * @author asalas
 * 
 */
public interface ConsultoraService {
	
	public void persist(Consultoria consultora);
	
	public void merge(Consultoria consultora);
	
	public void save(Consultoria consultora);
	
	public void remove(Consultoria consultora);
	
	public Consultoria findById(Long consultoraId);
	
	public List<Consultoria> getAll();
}
