package com.cloudfoundry.tstracker.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.cloudfoundry.tstracker.model.Consultoria;
import com.cloudfoundry.tstracker.model.Desarrollador;

import org.springframework.stereotype.Repository;

@Repository
public class ConsultoraDAOImpl extends GenericDAOImpl<Consultoria, Long>
		implements ConsultoraDAO {

	
	@Override
	public List<Consultoria> getByDesarrollador(Desarrollador desarrollador) {
		List<Consultoria> results = null;
		try {
			String hql = "SELECT "
					+ "cons "
					+ "FROM Consultoria AS cons "
					+ "JOIN cons.listaDesarrolladores AS devs "
					+ "WHERE devs.nombreUsuario = :userName";
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("userName", desarrollador.getNombreUsuario());
			results = (List<Consultoria>) query.getResultList();
		} catch (NoResultException e) {
		}
		return results;
	}
}
