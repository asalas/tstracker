package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.dao.RolDAO;
import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDAO rolDAO;

	@Override
	public Rol getByCodigoRol(RolEnum codigoRol) {
		return this.rolDAO.getByCodigoRol(codigoRol);
	}

}