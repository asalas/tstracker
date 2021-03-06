package com.terminaltics.tstracker.service;

import java.util.List;

import com.terminaltics.tstracker.model.Tarea;

/**
 * Servicio de la entidad Tarea
 * 
 * @author asalas
 * 
 */
public interface TareaService {
	
	public void persist(Tarea tarea);
	
	public void merge(Tarea tarea);
	
	public void save(Tarea tarea);
	
	public void remove(Tarea tarea);
	
	public Tarea findById(Long tareaId);
	
	public List<Tarea> getAll();
	
}
