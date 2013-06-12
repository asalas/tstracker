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
		
		String hql = "from Usuario where email = :email";
		
		try {
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("email", email);
			dbUsuario = (Usuario)query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}		
		
		return dbUsuario;
	}
	
}
