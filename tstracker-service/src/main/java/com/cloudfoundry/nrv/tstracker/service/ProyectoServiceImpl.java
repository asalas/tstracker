package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.dao.ProyectoDAO;
import com.cloudfoundry.nrv.tstracker.model.Desarrollador;
import com.cloudfoundry.nrv.tstracker.model.Proyecto;

/**
 * Implementacion del servicio de la entidad Proyecto
 * 
 * @author asalas
 * 
 */
public class ProyectoServiceImpl implements ProyectoService {

	private ProyectoDAO proyectoDAO;
	
	@Override
	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador) {		
		return this.proyectoDAO.getAllByDesarrollador(desarrollador);
	}
	

	public ProyectoDAO getProyectoDAO() {
		return proyectoDAO;
	}

	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}
	
}
