package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.dao.ReporteDAO;
import com.cloudfoundry.tstracker.model.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio de la entidad Reporte
 * 
 * @author asalas
 * 
 */
@Service
public class ReporteServiceImpl implements ReporteService {
	
        @Autowired
	private ReporteDAO reporteDAO;	

	@Override
	public void persist(Reporte reporte) {
		this.reporteDAO.persist(reporte);		
	}

	@Override
	public void merge(Reporte reporte) {
		this.reporteDAO.merge(reporte);
	}

	@Override
	public void save(Reporte reporte) {
		Reporte dbReporte = this.findById(reporte.getId());
		if(dbReporte == null) {
			this.persist(reporte);
		} else {
			this.merge(reporte);
		}
	}

	@Override
	public void remove(Reporte reporte) {
		this.reporteDAO.remove(reporte);
	}

	@Override
	public Reporte findById(Long reporteId) {
		return this.reporteDAO.findById(reporteId);
	}

	@Override
	public List<Reporte> getAll() {
		return this.reporteDAO.findAll();
	}

}
