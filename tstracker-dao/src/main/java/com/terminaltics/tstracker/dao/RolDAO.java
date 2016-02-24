package com.terminaltics.tstracker.dao;

import com.terminaltics.tstracker.model.Rol;
import com.terminaltics.tstracker.model.RolEnum;

/**
 * 
 * @author asalas
 *
 */
public interface RolDAO extends GenericDAO<Rol, Long> {

	public Rol getByCodigoRol(RolEnum codigoRol);
	
}
