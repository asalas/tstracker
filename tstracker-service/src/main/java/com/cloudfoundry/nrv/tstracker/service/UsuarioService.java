package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.model.Usuario;

public interface UsuarioService {

	public void persist(Usuario usuario);
	
	public void merge(Usuario usuario);
	
	public void remove(Usuario usuario);
	
	public Usuario findById(String nombreUsuario);
	
	public List<Usuario> getAll();
	
}
