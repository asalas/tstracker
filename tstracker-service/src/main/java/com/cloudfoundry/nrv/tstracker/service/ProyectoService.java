package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.model.Desarrollador;
import com.cloudfoundry.nrv.tstracker.model.Proyecto;

/**
 * Servicio para la entidad Proyecto
 * @author asalas
 * 
 */
public interface ProyectoService {
	
	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador);

}
