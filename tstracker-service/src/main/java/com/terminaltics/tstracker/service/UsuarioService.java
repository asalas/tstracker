package com.terminaltics.tstracker.service;

import java.util.List;

import com.terminaltics.tstracker.model.Usuario;

public interface UsuarioService {

	void persist(Usuario usuario);
	
	void merge(Usuario usuario);
	
	void remove(Usuario usuario);
	
	Usuario findById(String nombreUsuario);
	
	List<Usuario> getAll();
	
	Usuario findByEmail(String email);
	
	void registraNuevoDessarrollador(Usuario desarrollador);
	
	Usuario findByUserName(String nombreUsuario);
	
}
