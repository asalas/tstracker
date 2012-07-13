package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.dao.TareaDAO;
import com.cloudfoundry.nrv.tstracker.model.Tarea;

/**
 * Implementacion del servicio de la entidad Tarea
 * 
 * @author asalas
 * 
 */
public class TareaServiceImpl implements TareaService {
	
	private TareaDAO tareaDAO;	

	@Override
	public void persist(Tarea tarea) {
		this.tareaDAO.persist(tarea);		
	}

	@Override
	public void merge(Tarea tarea) {
		this.tareaDAO.merge(tarea);
	}

	@Override
	public void save(Tarea tarea) {
		Tarea dbTarea = this.findById(tarea.getId());
		if(dbTarea == null) {
			this.persist(tarea);
		} else {
			this.merge(tarea);
		}		
	}

	@Override
	public void remove(Tarea tarea) {
		this.tareaDAO.remove(tarea);	
	}

	@Override
	public Tarea findById(Long tareaId) {
		return this.tareaDAO.findById(tareaId);
	}

	@Override
	public List<Tarea> getAll() {
		return this.tareaDAO.findAll();
	}
	
	public TareaDAO getTareaDAO() {
		return tareaDAO;
	}

	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	}
}