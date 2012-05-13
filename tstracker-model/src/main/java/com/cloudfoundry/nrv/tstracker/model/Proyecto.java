package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;
import java.util.List;

/**
 * Esta entidad representa el Proyecto al cual está asignado un Desarrollador
 * @author WINTER42
 *
 */
public class Proyecto implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private LiderTecnico liderTecnico;
	
	private List<Desarrollador> listaDesarrolladores;
	
	private Integer duracionMeses;
	
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LiderTecnico getLiderTecnico() {
		return liderTecnico;
	}

	public void setLiderTecnico(LiderTecnico liderTecnico) {
		this.liderTecnico = liderTecnico;
	}

	public List<Desarrollador> getListaDesarrolladores() {
		return listaDesarrolladores;
	}

	public void setListaDesarrolladores(List<Desarrollador> listaDesarrolladores) {
		this.listaDesarrolladores = listaDesarrolladores;
	}

	public Integer getDuracionMeses() {
		return duracionMeses;
	}

	public void setDuracionMeses(Integer duracionMeses) {
		this.duracionMeses = duracionMeses;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
