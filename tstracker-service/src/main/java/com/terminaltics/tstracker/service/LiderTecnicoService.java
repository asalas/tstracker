package com.terminaltics.tstracker.service;

import java.util.List;

import com.terminaltics.tstracker.model.LiderTecnico;

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