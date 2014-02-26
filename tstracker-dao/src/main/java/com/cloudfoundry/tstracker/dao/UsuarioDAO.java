package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Usuario;

/**
 * 
 * @author asalas
 *
 */
public interface UsuarioDAO extends GenericDAO<Usuario, String> {
	
	Usuario findByEmail(String email);
	
	Usuario findByUserName(String userName);
	
}
