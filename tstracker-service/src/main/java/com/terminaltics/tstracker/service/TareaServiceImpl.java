package com.terminaltics.tstracker.service;

import java.util.List;

import com.terminaltics.tstracker.dao.TareaDAO;
import com.terminaltics.tstracker.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion del servicio de la entidad Tarea
 * 
 * @author asalas
 * 
 */
@Service
public class TareaServiceImpl implements TareaService {
	
        @Autowired
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
        @Transactional(rollbackFor = Throwable.class)
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

}