package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Consultoria;
import org.springframework.stereotype.Repository;

@Repository(value = "consultoraDAO")
public class ConsultoraDAOImpl extends GenericDAOImpl<Consultoria, Long>
		implements ConsultoraDAO {

}
