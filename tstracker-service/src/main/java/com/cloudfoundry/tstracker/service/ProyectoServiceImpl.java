package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.dao.ProyectoDAO;
import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion del servicio de la entidad Proyecto
 * 
 * @author asalas
 * 
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

        @Autowired
	private ProyectoDAO proyectoDAO;
	
	@Override
	public void persist(Proyecto proyecto) {
		this.proyectoDAO.persist(proyecto);		
	}


	@Override
	public void merge(Proyecto proyecto) {
		this.proyectoDAO.merge(proyecto);		
	}


	@Override
        @Transactional(rollbackFor = Throwable.class)
	public void save(Proyecto proyecto) {
		Proyecto dbProyecto = this.findById(proyecto.getId());
		if(dbProyecto == null) {
			this.save(proyecto);
		} else {
			this.merge(proyecto);
		}		
	}


	@Override
	public void remove(Proyecto proyecto) {
		this.proyectoDAO.remove(proyecto);		
	}


	@Override
	public Proyecto findById(Long proyectoId) {
		return this.proyectoDAO.findById(proyectoId);
	}


	@Override
	public List<Proyecto> getAll() {
		return this.proyectoDAO.findAll();
	}
	
	@Override
	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador) {		
		return this.proyectoDAO.getAllByDesarrollador(desarrollador);
	}
	
}