package com.terminaltics.tstracker.dao;

import com.terminaltics.tstracker.model.Usuario;

/**
 * 
 * @author asalas
 *
 */
public interface UsuarioDAO extends GenericDAO<Usuario, String> {
	
	Usuario findByEmail(String email);
	
	Usuario findByUserName(String userName);
	
}
