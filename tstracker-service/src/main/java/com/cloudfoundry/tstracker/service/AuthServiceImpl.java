package com.cloudfoundry.tstracker.service;

import org.zkoss.zk.ui.Executions;

import com.cloudfoundry.tstracker.dao.UsuarioDAO;
import com.cloudfoundry.tstracker.model.Usuario;

public class AuthServiceImpl implements AuthService {

	private UsuarioDAO usuarioDAO;
	
	
	@Override
	public Usuario getCurrentUserInSession() {
		
		Object currentUserName = Executions.getCurrent().getSession().getAttribute("current_user");
		
		Usuario currentUser = null;
		
		if(currentUserName != null) {
			currentUser = this.usuarioDAO.findById(currentUserName.toString());			
		}
		
		return currentUser;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}