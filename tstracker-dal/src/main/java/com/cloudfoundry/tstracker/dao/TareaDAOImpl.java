package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Tarea;
import org.springframework.stereotype.Repository;

@Repository(value = "tareaDAO")
public class TareaDAOImpl extends GenericDAOImpl<Tarea, Long> implements TareaDAO {

}
