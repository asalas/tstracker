package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Usuario;

public interface AuthenticationService {

	public Usuario getCurrentUserInSession();
	
	public void doLogin(String userName, String form);
	
	public void doLogout();
	
}
