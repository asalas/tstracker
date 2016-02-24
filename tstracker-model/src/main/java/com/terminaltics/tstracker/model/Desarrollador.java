package com.terminaltics.tstracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Esta entidad representa al Desarrollador que trabaja para la Consultoria
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "desarrollador")
@PrimaryKeyJoinColumn(name="nombre_desarrollador", referencedColumnName="nombre_usuario")
@OnDelete(action=OnDeleteAction.CASCADE)
public class Desarrollador extends Usuario implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;	

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "proyecto_desarrollador", 
//				joinColumns = { @JoinColumn(referencedColumnName = "nombre_usuario", name="nombre_desarrollador", nullable = false, updatable = false) }, 
//				inverseJoinColumns = { @JoinColumn(referencedColumnName = "id_proyecto", name="id_proyecto", nullable = false, updatable = false) })
//	private List<Proyecto> listaProyectos = new ArrayList<Proyecto>();

//	@ManyToMany(mappedBy = "listaDesarrolladores", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Consultoria> listaConsultorias = new HashSet<Consultoria>();
	
//	public List<Proyecto> getListaProyectos() {
//		return listaProyectos;
//	}
//
//	public void setListaProyectos(List<Proyecto> listaProyectos) {
//		this.listaProyectos = listaProyectos;
//	}

//	public Set<Consultoria> getListaConsultorias() {
//		return listaConsultorias;
//	}
//
//	public void setListaConsultorias(Set<Consultoria> listaConsultorias) {
//		this.listaConsultorias = listaConsultorias;
//	}

}