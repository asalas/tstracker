package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa las Tareas o actividades que realiza el Desarrollador
 * durante cierto periodo de tiempo
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tarea")
	private Long id;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dia")
	private Date dia;

	@Column(name = "actividad")
	private String actividad;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "horas")
	private Integer horas;

	@Column(name = "observaciones")
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reporte", referencedColumnName = "id_reporte")
	private Reporte reporte;

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

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

}