package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolEnum;

/**
 * 
 * @author asalas
 *
 */
public interface RolDAO extends GenericDAO<Rol, Long> {

	public Rol getByCodigoRol(RolEnum codigoRol);
	
}
