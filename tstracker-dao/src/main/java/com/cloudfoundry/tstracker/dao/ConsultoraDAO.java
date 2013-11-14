package com.cloudfoundry.tstracker.dao;

import java.util.List;

import com.cloudfoundry.tstracker.model.Consultoria;
import com.cloudfoundry.tstracker.model.Desarrollador;

public interface ConsultoraDAO extends GenericDAO<Consultoria, Long> {

	List<Consultoria> getByDesarrollador(Desarrollador desarrollador);
	
}
