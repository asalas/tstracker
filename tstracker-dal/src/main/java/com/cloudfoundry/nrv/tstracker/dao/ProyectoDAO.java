package com.cloudfoundry.nrv.tstracker.dao;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.model.Desarrollador;
import com.cloudfoundry.nrv.tstracker.model.Proyecto;

public interface ProyectoDAO extends GenericDAO<Proyecto, Long> {

	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador);
	
}
