package com.terminaltics.tstracker.model;

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
	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "actividad", length = 150, nullable = false)
	private String actividad;

	@Column(name = "descripcion", length = 255, nullable = true)
	private String descripcion;

	@Column(name = "observaciones", length = 255, nullable = true)
	private String observaciones;
	
	@Column(name = "tiempo_hrs", nullable = false)
	private Integer tiempoHrs;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_reporte", referencedColumnName = "id_reporte")
	private Reporte reporte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date dia) {
		this.fecha = dia;
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

	public Integer getTiempoHrs() {
		return tiempoHrs;
	}

	public void setTiempoHrs(Integer horas) {
		this.tiempoHrs = horas;
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