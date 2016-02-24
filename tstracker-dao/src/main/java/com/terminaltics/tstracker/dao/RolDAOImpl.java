package com.terminaltics.tstracker.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.terminaltics.tstracker.model.Rol;
import com.terminaltics.tstracker.model.RolEnum;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author asalas
 *
 */
@Repository
public class RolDAOImpl extends GenericDAOImpl<Rol, Long> implements RolDAO {

	@Override
	public Rol getByCodigoRol(RolEnum codigoRol) {
		Rol dbRol = null;
		
		try {
			String hql = "FROM Rol WHERE codigoRol = :codigoRol";
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("codigoRol", codigoRol);
			dbRol = (Rol) query.getSingleResult();			
		} catch (NoResultException e) {
		}	
		
		return dbRol;
	}
}
