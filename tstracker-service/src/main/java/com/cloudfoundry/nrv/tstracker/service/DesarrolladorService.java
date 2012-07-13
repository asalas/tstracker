package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.model.Desarrollador;

/**
 * Servicio de la entidad Desarrollador
 * 
 * @author asalas
 * 
 */
public interface DesarrolladorService {

	public Desarrollador findById(String nombreUsuario);
	
}
