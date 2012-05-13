package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;

/**
 * Esta entidad representa a la Consultora
 * 
 * @author asalas
 * 
 */
public class Consultora implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nombre;
	
	private String direccion;
	
	private String ejecutivoCuenta;
	
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEjecutivoCuenta() {
		return ejecutivoCuenta;
	}

	public void setEjecutivoCuenta(String ejecutivoCuenta) {
		this.ejecutivoCuenta = ejecutivoCuenta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
