package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Usuario;

/**
 * 
 * @author asalas
 *
 */
public interface UsuarioDAO extends GenericDAO<Usuario, String> {
	
	public Usuario findByEmail(String email);
	
}
