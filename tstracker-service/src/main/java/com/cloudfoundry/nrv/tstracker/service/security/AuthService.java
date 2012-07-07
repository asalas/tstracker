package com.cloudfoundry.nrv.tstracker.service.security;



/**
 * Servicio de Autenticacion y Autorizacion.
 * 
 * @author asalas
 *
 */
public interface AuthService {
	
	public String getUserName();
	
	public void logOut();
	
}
