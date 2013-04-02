package com.cloudfoundry.tstracker.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.cloudfoundry.tstracker.model.Rol;
import com.cloudfoundry.tstracker.model.RolesEnum;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author asalas
 *
 */
@Repository(value = "rolDAO")
public class RolDAOImpl extends GenericDAOImpl<Rol, Long> implements RolDAO {

	@Override
	public Rol getByCodigoRol(RolesEnum codigoRol) {
		Rol dbRol = null;
		
		try {
			Query query = getEntityManager().createQuery("from Rol where codigoRol = :codigoRol");
			query.setParameter("codigoRol", codigoRol);
			dbRol = (Rol) query.getSingleResult();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}	
		
		return dbRol;
	}
}
