package com.terminaltics.tstracker.dao;

import java.util.List;

import com.terminaltics.tstracker.model.Consultoria;
import com.terminaltics.tstracker.model.Desarrollador;

public interface ConsultoraDAO extends GenericDAO<Consultoria, Long> {

	List<Consultoria> getByDesarrollador(Desarrollador desarrollador);
	
}
