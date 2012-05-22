package com.cloudfoundry.nrv.tstracker.service;

import com.cloudfoundry.nrv.tstracker.dao.ReporteDAO;

/**
 * Implementacion del servicio de la entidad Reporte
 * 
 * @author asalas
 * 
 */
public class ReporteServiceImpl implements ReporteService {
	
	private ReporteDAO reporteDAO;

	public ReporteDAO getReporteDAO() {
		return reporteDAO;
	}

	public void setReporteDAO(ReporteDAO reporteDAO) {
		this.reporteDAO = reporteDAO;
	}

}
