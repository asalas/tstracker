package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolEnum;

public interface RolService {

	public Rol getByCodigoRol(RolEnum codigoRol);
	
}
