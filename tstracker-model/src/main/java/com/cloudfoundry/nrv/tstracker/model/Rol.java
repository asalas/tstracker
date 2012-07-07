package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa los roles que puede tener un usuario
 * 
 * @author asalas
 *
 */

@Entity
@Table(name="rol")
public class Rol implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rol")
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "codigo_rol")
	private RolesEnum codigoRol;
	
	@Column(name = "descripcion_rol")
	private String descripcionRol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolesEnum getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(RolesEnum codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

}