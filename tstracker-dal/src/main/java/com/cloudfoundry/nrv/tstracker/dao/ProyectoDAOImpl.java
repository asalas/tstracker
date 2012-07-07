package com.cloudfoundry.nrv.tstracker.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.cloudfoundry.nrv.tstracker.model.Desarrollador;
import com.cloudfoundry.nrv.tstracker.model.Proyecto;

public class ProyectoDAOImpl extends GenericDAOImpl<Proyecto, Long> implements
		ProyectoDAO {

	@Override
	public List<Proyecto> getAllByDesarrollador(Desarrollador desarrollador) {

		List<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		
		try {
			Query query = getEntityManager().createQuery("SELECT p FROM Proyecto AS p JOIN p.listaDesarrolladores AS devs WHERE devs.nombreUsuario = :userName");
			query.setParameter("userName", desarrollador.getNombreUsuario());
			listaProyectos = (List<Proyecto>) query.getResultList();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}	
		
		return listaProyectos;
	}
	
}
