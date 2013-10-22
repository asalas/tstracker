package com.cloudfoundry.tstracker.service;

import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.util.Clients;

import com.cloudfoundry.tstracker.dao.UsuarioDAO;
import com.cloudfoundry.tstracker.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "authService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario getCurrentUserInSession() {

		Execution executionCurrent = Executions.getCurrent();
		Session session = executionCurrent.getSession();
		Object currentUserName = session.getAttribute("current_user");

		Usuario currentUser = null;

		if (currentUserName != null) {
			currentUser = this.usuarioDAO.findById(currentUserName.toString());
		}

		return currentUser;
	}

	@Override
	public void doLogin(String userName, String form) {
		Execution current = Executions.getCurrent();
		Session session = current.getSession();
		session.setAttribute("current_user", userName);
		Clients.submitForm(form);
	}

	@Override
	public void doLogout() {
		Executions.sendRedirect("/j_spring_security_logout");
	}

}