package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.dao.RolDAO;
import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

        @Autowired
	private RolDAO rolDAO;
	
	@Override
	public Rol getByCodigoRol(RolesEnum codigoRol) {
		return this.rolDAO.getByCodigoRol(codigoRol);
	}

}