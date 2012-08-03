package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.dao.DesarrolladorDAO;
import com.cloudfoundry.tstracker.model.Desarrollador;

/**
 * Implementacion del servicio de la entidad Desarrollador
 * 
 * @author asalas
 * 
 */
public class DesarrolladorServiceImpl implements DesarrolladorService {

	private DesarrolladorDAO desarrolladorDAO;
	
	@Override
	public Desarrollador findById(String nombreUsuario) {
		return this.desarrolladorDAO.findById(nombreUsuario);
	}

	public DesarrolladorDAO getDesarrolladorDAO() {
		return desarrolladorDAO;
	}

	public void setDesarrolladorDAO(DesarrolladorDAO desarrolladorDAO) {
		this.desarrolladorDAO = desarrolladorDAO;
	}
}