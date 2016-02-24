package com.terminaltics.tstracker.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.terminaltics.tstracker.model.Desarrollador;
import com.terminaltics.tstracker.model.Proyecto;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectoDAOImpl extends GenericDAOImpl<Proyecto, Long> implements
		ProyectoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador) {

		List<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		
		try {
			String hql = "SELECT p "
					+ "FROM Proyecto AS p "
					+ "JOIN p.listaDesarrolladores AS devs "
					+ "WHERE "
					+ "devs.nombreUsuario = :userName";
			Query query = getEntityManager().createQuery(hql);
			query.setParameter("userName", desarrollador.getNombreUsuario());
			listaProyectos = (List<Proyecto>) query.getResultList();			
		} catch (NoResultException e) {
		}	
		
		return listaProyectos;
	}
	
}
