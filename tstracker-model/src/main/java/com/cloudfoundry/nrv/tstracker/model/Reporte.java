package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta entidad representa el Reporte generado para entregar los timesheets a la
 * Consultora
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "reporte")
public class Reporte implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_reporte")
	private Long id;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_inicial")
	private Date fechaInicial;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_inicial")
	private Date fechaFinal;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha_entrega")
	private Date fechaEntrega;

	@Column(name = "no_solicitud")
	private String noSolicitud;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_desarrollador", referencedColumnName = "id_desarrollador")
	private Desarrollador desarrollador;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "reporte_tareas", joinColumns = { @JoinColumn(referencedColumnName = "id_reporte") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "id_tarea") })
	private List<Tarea> listaTareas;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado")
	private EstadoEnum estado;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Proyecto.class)
	@JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
	private Proyecto proyecto;

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

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
