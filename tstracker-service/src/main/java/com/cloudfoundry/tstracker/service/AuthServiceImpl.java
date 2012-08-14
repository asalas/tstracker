package com.cloudfoundry.tstracker.service;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

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
	
	@Override
	public void doLogin(String userName, String form) {
		Executions.getCurrent().getSession().setAttribute("current_user", userName);
		Clients.submitForm(form);		
	}
	
	@Override
	public void doLogout() {
		Executions.sendRedirect("/j_spring_security_logout");		
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}