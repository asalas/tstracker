package com.cloudfoundry.tstracker.service;

import java.util.List;

import com.cloudfoundry.tstracker.model.Reporte;

/**
 * Servicio de la entidad Reporte
 * 
 * @author asalas
 * 
 */
public interface ReporteService {

	public void persist(Reporte reporte);
	
	public void merge(Reporte reporte);
	
	public void save(Reporte reporte);
	
	public void remove(Reporte reporte);
	
	public Reporte findById(Long reporteId);
	
	public List<Reporte> getAll();
}
