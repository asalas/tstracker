package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.ProyectoDAO;

/**
 * Implementacion del servicio de la entidad Proyecto
 * 
 * @author asalas
 * 
 */
public class ProyectoServiceImpl implements ProyectoService {

	private ProyectoDAO proyectoDAO;

	public ProyectoDAO getProyectoDAO() {
		return proyectoDAO;
	}

	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}
	
}
