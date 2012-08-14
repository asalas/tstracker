package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolesEnum;

public interface RolService {

	public Rol getByCodigoRol(RolesEnum codigoRol);
	
}
