package com.cloudfoundry.tstracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta entidad representa a la Consultoria
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "consultoria")
public class Consultoria implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_consultoria")
	private Long id;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "direccion", length = 255, nullable = false)
	private String direccion;

	@Column(name = "ejecutivo_cuenta", length = 255, nullable = true)
	private String ejecutivoCuenta;

	@Column(name = "email", length = 100, nullable = false)
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