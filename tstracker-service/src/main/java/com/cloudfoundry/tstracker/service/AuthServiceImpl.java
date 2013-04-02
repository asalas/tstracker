package com.cloudfoundry.tstracker.service;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

import com.cloudfoundry.tstracker.dao.UsuarioDAO;
import com.cloudfoundry.tstracker.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "authService")
public class AuthServiceImpl implements AuthService {

        @Autowired
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
	
}