package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Esta entidad representa las Tareas o actividades que realiza el Desarrollador
 * durante cierto periodo de tiempo
 * 
 * @author asalas
 * 
 */
public class Tarea implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Date dia;
	
	private String actividad;
	
	private String descripcion;
	
	private Integer horas;
	
	private String observaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}	

}