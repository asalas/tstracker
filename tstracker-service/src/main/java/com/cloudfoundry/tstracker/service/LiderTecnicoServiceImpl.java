package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.dao.LiderTecnicoDAO;
import com.cloudfoundry.tstracker.model.LiderTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio de la entidad LiderTecnico
 * 
 * @author asalas
 * 
 */
@Service(value = "liderTecnicoService")
public class LiderTecnicoServiceImpl implements LiderTecnicoService {

        @Autowired
	private LiderTecnicoDAO liderTecnicoDAO;

	@Override
	public void persist(LiderTecnico liderTecnico) {
		this.liderTecnicoDAO.persist(liderTecnico);
		
	}

	@Override
	public void merge(LiderTecnico liderTecnico) {
		this.liderTecnicoDAO.merge(liderTecnico);		
	}

	@Override
	public void save(LiderTecnico liderTecnico) {
		LiderTecnico dbLiderTecnico = this.findById(liderTecnico.getId());
		if(dbLiderTecnico == null) {
			this.persist(liderTecnico);
		} else {
			this.merge(liderTecnico);
		}
	}

	@Override
	public void remove(LiderTecnico liderTecnico) {
		this.liderTecnicoDAO.remove(liderTecnico);		
	}

	@Override
	public LiderTecnico findById(Long liderTecnicoId) {
		return this.liderTecnicoDAO.findById(liderTecnicoId);
	}

	@Override
	public List<LiderTecnico> getAll() {
		return this.liderTecnicoDAO.findAll();
	}

}