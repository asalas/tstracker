package com.cloudfoundry.tstracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cloudfoundry.tstracker.dao.UsuarioDAO;
import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolEnum;
import com.cloudfoundry.tstracker.model.Usuario;
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

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public Usuario findByEmail(String email) {
        return this.usuarioDAO.findByEmail(email);
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

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void registraNuevoDessarrollador(Usuario desarrollador) {
        this.persist(desarrollador);

		//El rol por defecto es el de desarrollador, por el momento no es posible asignar otro tipo de rol
		//ya que la herramienta esta diseniada para desarrolladores en su estado actual

        Rol dbRol = this.rolService.getByCodigoRol(RolEnum.DESARROLLADOR);
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