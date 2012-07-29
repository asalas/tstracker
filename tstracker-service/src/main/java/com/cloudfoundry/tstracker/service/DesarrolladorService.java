package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Desarrollador;

/**
 * Servicio de la entidad Desarrollador
 * 
 * @author asalas
 * 
 */
public interface DesarrolladorService {

	public Desarrollador findById(String nombreUsuario);
	
}
