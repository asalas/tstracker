package com.cloudfoundry.tstracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Esta entidad representa al Cliente que contrata los servicios de la
 * Consultoria
 * 
 * @author asalas
 * 
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente")
	private Long id;

	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "direccion", length = 255, nullable = false)
	private String direccion;
	
	@Column(name="telefono", length = 15, nullable = true)
	private String telefono;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_consultoria", referencedColumnName="id_consultoria", nullable = false)
	private Consultoria consultoria;

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Consultoria getConsultoria() {
		return consultoria;
	}

	public void setConsultoria(Consultoria consultoria) {
		this.consultoria = consultoria;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}