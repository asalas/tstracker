package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;

/**
 * Esta entidad representa al Desarrollador (analista, recurso, programador,
 * etc) que trabaja para la Consultora
 * 
 * @author asalas
 * 
 */
public class Desarrollador implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String apellidos;
	
	private String direccion;
	
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
