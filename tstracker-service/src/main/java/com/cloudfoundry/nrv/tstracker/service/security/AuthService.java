package com.cloudfoundry.nrv.tstracker.service.security;

import java.util.Map;


/**
 * Servicio de Autenticacion y Autorizacion.
 * 
 * @author asalas
 *
 */
public interface AuthService {
	
	public String getUserName();
	
	public Map<String, String> getUserLoginAttributes();
	
	public void logOut();
	
}
