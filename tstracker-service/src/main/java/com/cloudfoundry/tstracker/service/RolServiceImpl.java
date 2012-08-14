package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.dao.RolDAO;
import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolesEnum;

public class RolServiceImpl implements RolService {

	private RolDAO rolDAO;
	
	@Override
	public Rol getByCodigoRol(RolesEnum codigoRol) {
		return this.rolDAO.getByCodigoRol(codigoRol);
	}

	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

}