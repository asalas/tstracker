package com.terminaltics.tstracker.service;

import com.terminaltics.tstracker.model.Rol;
import com.terminaltics.tstracker.model.RolEnum;

public interface RolService {

	public Rol getByCodigoRol(RolEnum codigoRol);
	
}
