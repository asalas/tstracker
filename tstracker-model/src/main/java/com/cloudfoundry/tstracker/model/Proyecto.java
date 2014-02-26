package com.cloudfoundry.tstracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Column(name = "clave", length = 100, nullable = false)
	private String clave;

	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;

	@Column(name = "duracion_dias", nullable = false)
	private Integer duracion;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "estatus", length = 30, nullable = false)
	private EstatusEnum estatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_lider_tecnico", referencedColumnName = "id_lider_tecnico", nullable = false)
	private LiderTecnico liderTecnico;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "proyecto_desarrollador", 
				joinColumns = { @JoinColumn(referencedColumnName = "id_proyecto", name="id_proyecto", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(referencedColumnName = "nombre_usuario", name="nombre_desarrollador", nullable = false, updatable = false) })
	private List<Desarrollador> listaDesarrolladores = new ArrayList<Desarrollador>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
	private Cliente cliente;

	public EstatusEnum getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusEnum estatus) {
		this.estatus = estatus;
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

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracionMeses) {
		this.duracion = duracionMeses;
	}

	public List<Desarrollador> getListaDesarrolladores() {
		return listaDesarrolladores;
	}

	public void setListaDesarrolladores(List<Desarrollador> listaDesarrolladores) {
		this.listaDesarrolladores = listaDesarrolladores;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}