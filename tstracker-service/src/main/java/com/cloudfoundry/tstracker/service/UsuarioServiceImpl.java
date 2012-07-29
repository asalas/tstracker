package com.cloudfoundry.tstracker.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cloudfoundry.tstracker.dao.UsuarioDAO;
import com.cloudfoundry.tstracker.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	
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
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		
		Usuario usuario = this.findById(userName);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("No se encontro el usuario: " + userName);			
		}
		
		return usuario;
	}

}