package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Reporte;
import org.springframework.stereotype.Repository;

@Repository(value = "reporteDAO")
public class ReporteDAOImpl extends GenericDAOImpl<Reporte, Long> implements ReporteDAO {

}
