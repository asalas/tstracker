package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.TareaDAO;

/**
 * Implementacion del servicio de la entidad Tarea
 * 
 * @author asalas
 * 
 */
public class TareaServiceImpl implements TareaService {
	
	private TareaDAO tareaDAO;

	public TareaDAO getTareaDAO() {
		return tareaDAO;
	}

	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	}

}
