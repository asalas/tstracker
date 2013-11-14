package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Usuario;

public interface AuthenticationService {

	Usuario getCurrentUserInSession();
	
	void doLogin(String userName, String form);
	
	void doLogout();
	
}
