package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Tarea;
import org.springframework.stereotype.Repository;

@Repository
public class TareaDAOImpl extends GenericDAOImpl<Tarea, Long> implements TareaDAO {

}
