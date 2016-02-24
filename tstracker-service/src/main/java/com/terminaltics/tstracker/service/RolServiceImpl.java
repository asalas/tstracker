package com.terminaltics.tstracker.service;

import com.terminaltics.tstracker.dao.RolDAO;
import com.terminaltics.tstracker.model.Rol;
import com.terminaltics.tstracker.model.RolEnum;
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