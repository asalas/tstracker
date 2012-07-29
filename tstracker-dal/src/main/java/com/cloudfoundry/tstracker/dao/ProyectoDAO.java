package com.cloudfoundry.tstracker.dao;

import java.util.List;

import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.model.Proyecto;

public interface ProyectoDAO extends GenericDAO<Proyecto, Long> {

	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador);
	
}
