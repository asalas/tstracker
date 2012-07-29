package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.model.Proyecto;

/**
 * Servicio para la entidad Proyecto
 * @author asalas
 * 
 */
public interface ProyectoService {
	
	public void persist(Proyecto proyecto);
	
	public void merge(Proyecto proyecto);
	
	public void save(Proyecto proyecto);
	
	public void remove(Proyecto proyecto);
	
	public Proyecto findById(Long proyectoId);
	
	public List<Proyecto> getAll();
	
	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador);

}
