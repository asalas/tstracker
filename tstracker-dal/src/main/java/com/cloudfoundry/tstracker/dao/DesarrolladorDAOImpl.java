package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Desarrollador;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author asalas
 *
 */
@Repository(value = "desarrolladorDAO")
public class DesarrolladorDAOImpl extends GenericDAOImpl<Desarrollador, String> implements
		DesarrolladorDAO {

}
