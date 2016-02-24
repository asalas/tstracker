package com.terminaltics.tstracker.dao;

import java.util.List;

import com.terminaltics.tstracker.model.Desarrollador;
import com.terminaltics.tstracker.model.Proyecto;

public interface ProyectoDAO extends GenericDAO<Proyecto, Long> {

	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador);
	
}
