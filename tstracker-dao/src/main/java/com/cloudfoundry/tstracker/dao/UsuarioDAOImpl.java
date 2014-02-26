package com.cloudfoundry.tstracker.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.cloudfoundry.tstracker.model.Usuario;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author asalas
 *
 */
@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, String> implements
		UsuarioDAO {

	@Override
	public Usuario findByEmail(String email) {
		
		Usuario dbUsuario = null;
		
		String hql = "FROM Usuario WHERE email = :email";
		
		try {
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("email", email);
			dbUsuario = (Usuario)query.getSingleResult();
		} catch (NoResultException e) {
		}		
		
		return dbUsuario;
	}
	
	@Override
	public Usuario findByUserName(String userName) {
		Usuario dbUsuario = null;
		
		String hql = "SELECT u FROM Usuario u JOIN u.listaRoles WHERE u.nombreUsuario = :userName";
		
		try {
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("userName", userName);
			dbUsuario = (Usuario)query.getSingleResult();
		} catch (NoResultException e) {
		}
		
		return dbUsuario;
	}
	
}
