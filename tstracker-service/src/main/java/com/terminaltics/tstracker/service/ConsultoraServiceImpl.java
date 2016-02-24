package com.terminaltics.tstracker.service;

import java.util.List;

import com.terminaltics.tstracker.dao.ConsultoraDAO;
import com.terminaltics.tstracker.model.Consultoria;
import com.terminaltics.tstracker.model.Desarrollador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion del servicio de la entidad Consultoria
 * 
 * @author asalas
 * 
 */
@Service(value = "consultoraService")
public class ConsultoraServiceImpl implements ConsultoraService {

	@Autowired
	private ConsultoraDAO consultoraDAO;

	@Override
	public void persist(Consultoria consultora) {
		consultora.setId(null);
		List<Desarrollador> listaDesarrolladores = consultora.getListaDesarrolladores();
		consultora.setListaDesarrolladores(null);
		
		this.consultoraDAO.persist(consultora);
		consultora.setListaDesarrolladores(listaDesarrolladores);
		this.consultoraDAO.merge(consultora);
	}

	@Override
	public void merge(Consultoria consultora) {
		this.consultoraDAO.merge(consultora);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void save(Consultoria consultora) {
		Consultoria dbConsultora = this.findById(consultora.getId());
		if (dbConsultora == null) {
			this.persist(consultora);
		} else {
			this.merge(consultora);
		}
	}

	@Override
	public void remove(Consultoria consultora) {
		this.consultoraDAO.remove(consultora);
	}

	@Override
	public Consultoria findById(Long consultoraId) {
		return this.consultoraDAO.findById(consultoraId);
	}

	@Override
	public List<Consultoria> getAll() {
		return this.consultoraDAO.findAll();
	}

	@Override
	public List<Consultoria> getByDesarrollador(Desarrollador desarrollador) {
		return this.consultoraDAO.getByDesarrollador(desarrollador);
	}

}