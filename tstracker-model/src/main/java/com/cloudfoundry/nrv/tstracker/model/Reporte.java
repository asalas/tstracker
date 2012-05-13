package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Esta entidad representa el Reporte generado para entregar los timesheets a la Consultora
 * @author WINTER42
 *
 */
public class Reporte implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Date fechaInicial;
	
	private Date fechaFinal;
	
	private String noSolicitud;
	
	private Desarrollador desarrollador;
	
	private List<Tarea> listaTareas;
	
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getNoSolicitud() {
		return noSolicitud;
	}

	public void setNoSolicitud(String noSolicitud) {
		this.noSolicitud = noSolicitud;
	}

	public Desarrollador getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(Desarrollador desarrollador) {
		this.desarrollador = desarrollador;
	}

	public List<Tarea> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
