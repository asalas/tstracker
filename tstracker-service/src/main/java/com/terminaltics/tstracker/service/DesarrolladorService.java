package com.terminaltics.tstracker.service;

import com.terminaltics.tstracker.model.Desarrollador;

/**
 * Servicio de la entidad Desarrollador
 * 
 * @author asalas
 * 
 */
public interface DesarrolladorService {

	public Desarrollador findById(String nombreUsuario);
	
}
