package com.terminaltics.tstracker.service;

import com.terminaltics.tstracker.model.Usuario;

public interface AuthenticationService {

	Usuario getCurrentUserInSession();
	
	void doLogin(String userName, String form);
	
	void doLogout();
	
}
