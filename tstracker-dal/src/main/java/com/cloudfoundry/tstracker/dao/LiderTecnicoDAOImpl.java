package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.LiderTecnico;
import org.springframework.stereotype.Repository;

@Repository(value = "liderTecnicoDAO")
public class LiderTecnicoDAOImpl extends GenericDAOImpl<LiderTecnico, Long>
		implements LiderTecnicoDAO {

}
