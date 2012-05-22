package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.LiderTecnicoDAO;

/**
 * Implementacion del servicio de la entidad LiderTecnico
 * 
 * @author asalas
 * 
 */
public class LiderTecnicoServiceImpl implements LiderTecnicoService {

	private LiderTecnicoDAO liderTecnicoDAO;

	public LiderTecnicoDAO getLiderTecnicoDAO() {
		return liderTecnicoDAO;
	}

	public void setLiderTecnicoDAO(LiderTecnicoDAO liderTecnicoDAO) {
		this.liderTecnicoDAO = liderTecnicoDAO;
	}
}
