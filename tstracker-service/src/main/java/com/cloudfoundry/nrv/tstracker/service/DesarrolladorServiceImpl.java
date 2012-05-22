package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.DesarrolladorDAO;

/**
 * Implementacion del servicio de la entidad Desarrollador
 * 
 * @author asalas
 * 
 */
public class DesarrolladorServiceImpl implements DesarrolladorService {

	private DesarrolladorDAO desarrolladorDAO;

	public DesarrolladorDAO getDesarrolladorDAO() {
		return desarrolladorDAO;
	}

	public void setDesarrolladorDAO(DesarrolladorDAO desarrolladorDAO) {
		this.desarrolladorDAO = desarrolladorDAO;
	}
}
