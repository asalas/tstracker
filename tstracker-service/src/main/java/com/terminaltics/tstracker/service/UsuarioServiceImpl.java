package com.terminaltics.tstracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.terminaltics.tstracker.dao.UsuarioDAO;
import com.terminaltics.tstracker.model.Rol;
import com.terminaltics.tstracker.model.RolEnum;
import com.terminaltics.tstracker.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private RolService rolService;

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

    @Override
    public Usuario findByEmail(String email) {
        return this.usuarioDAO.findByEmail(email);
    }
    
    @Override
    public Usuario findByUserName(String nombreUsuario) {
    	return this.usuarioDAO.findByUserName(nombreUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException, DataAccessException {

        Usuario usuario = this.findByUserName(userName);

        if (usuario == null) {
            throw new UsernameNotFoundException("No se encontro el usuario: " + userName);
        }

        return usuario;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void registraNuevoDessarrollador(Usuario desarrollador) {
        this.persist(desarrollador);

        Rol dbRol = this.rolService.getByCodigoRol(RolEnum.ROL_DESARROLLADOR);
        List<Rol> roles = new ArrayList<Rol>();
        roles.add(dbRol);
        desarrollador.setListaRoles(roles);

        this.merge(desarrollador);
    }

    public RolService getRolService() {
        return rolService;
    }

    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }
}