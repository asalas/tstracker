package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Usuario;

public interface AuthService {

	public Usuario getCurrentUserInSession();
	
	public void doLogin(String userName, String form);
	
	public void doLogout();
	
}
