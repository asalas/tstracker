package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.model.Consultoria;
import com.cloudfoundry.tstracker.model.Desarrollador;

/**
 * Servicio de la entidad Consultoria
 * 
 * @author asalas
 * 
 */
public interface ConsultoraService {

	void persist(Consultoria consultora);

	void merge(Consultoria consultora);

	void save(Consultoria consultora);

	void remove(Consultoria consultora);

	Consultoria findById(Long consultoraId);

	List<Consultoria> getAll();
	
	List<Consultoria> getByDesarrollador(Desarrollador desarrollador);
}
