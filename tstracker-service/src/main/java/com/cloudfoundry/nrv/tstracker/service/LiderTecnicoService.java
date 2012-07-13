package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.model.LiderTecnico;

/**
 * Servicio de la entidad LiderTecnico
 * 
 * @author asalas
 * 
 */
public interface LiderTecnicoService {

	public void persist(LiderTecnico liderTecnico);
	
	public void merge(LiderTecnico liderTecnico);
	
	public void save(LiderTecnico liderTecnico);
	
	public void remove(LiderTecnico liderTecnico);
	
	public LiderTecnico findById(Long liderTecnicoId);
	
	public List<LiderTecnico> getAll();	
	
}