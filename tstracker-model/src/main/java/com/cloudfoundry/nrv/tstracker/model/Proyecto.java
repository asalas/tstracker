package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Esta entidad representa el Proyecto al cual esta asignado un Desarrollador
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_proyecto")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToOne(fetch = FetchType.EAGER)
	private LiderTecnico liderTecnico;

	@Column(name = "duracion_meses")
	private Integer duracionMeses;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado")
	private EstadoEnum estado;

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

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

	public Integer getDuracionMeses() {
		return duracionMeses;
	}

	public void setDuracionMeses(Integer duracionMeses) {
		this.duracionMeses = duracionMeses;
	}

}