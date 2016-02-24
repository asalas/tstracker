package com.terminaltics.tstracker.service;

import com.terminaltics.tstracker.dao.DesarrolladorDAO;
import com.terminaltics.tstracker.model.Desarrollador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio de la entidad Desarrollador
 * 
 * @author asalas
 * 
 */
@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

        @Autowired
	private DesarrolladorDAO desarrolladorDAO;
	
	@Override
	public Desarrollador findById(String nombreUsuario) {
		return this.desarrolladorDAO.findById(nombreUsuario);
	}

}
