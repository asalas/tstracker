package com.cloudfoundry.tstracker.service;

import com.cloudfoundry.tstracker.model.Usuario;

public interface AuthService {

	public Usuario getCurrentUserInSession();
	
}
