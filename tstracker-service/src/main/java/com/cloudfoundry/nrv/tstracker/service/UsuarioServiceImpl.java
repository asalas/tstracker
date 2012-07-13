package com.cloudfoundry.nrv.tstracker.service;

import java.util.List;

import com.cloudfoundry.nrv.tstracker.dao.UsuarioDAO;
import com.cloudfoundry.nrv.tstracker.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO usuarioDAO;

	@Override
	public void persist(Usuario usuario) {
		this.usuarioDAO.persist(usuario);
	}

	@Override
	public void merge(Usuario usuario) {
		this.usuarioDAO.merge(usuario);
	}

	@Override
	public void remove(Usuario usuario) {
		this.usuarioDAO.remove(usuario);		
	}

	@Override
	public Usuario findById(String nombreUsuario) {
		return this.usuarioDAO.findById(nombreUsuario);
	}

	@Override
	public List<Usuario> getAll() {
		return this.usuarioDAO.findAll();
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}