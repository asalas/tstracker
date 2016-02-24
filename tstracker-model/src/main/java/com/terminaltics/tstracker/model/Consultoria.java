package com.terminaltics.tstracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "consultoria_desarrollador", 
				joinColumns = { @JoinColumn(referencedColumnName = "id_consultoria", name="id_consultoria", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(referencedColumnName = "nombre_desarrollador", name="nombre_desarrollador", nullable = false, updatable = false) })
	private List<Desarrollador> listaDesarrolladores = new ArrayList<Desarrollador>();

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

	public List<Desarrollador> getListaDesarrolladores() {
		return listaDesarrolladores;
	}

	public void setListaDesarrolladores(List<Desarrollador> listaDesarrolladores) {
		this.listaDesarrolladores = listaDesarrolladores;
	}

}