package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;

/**
 * Esta entidad representa al Lider Técnico del Desarrollador para el Proyecto
 * en el que está asignado
 * 
 * @author asalas
 * 
 */
public class LiderTecnico implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
