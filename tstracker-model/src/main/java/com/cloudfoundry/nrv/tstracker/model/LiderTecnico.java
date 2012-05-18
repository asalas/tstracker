package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta entidad representa al Lider T�cnico del Desarrollador para el Proyecto
 * en el que est� asignado
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "lider_tecnico")
public class LiderTecnico implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lider_tecnico")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "email")
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
