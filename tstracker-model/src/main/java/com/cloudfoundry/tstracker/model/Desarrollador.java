package com.cloudfoundry.tstracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
 * Esta entidad representa al Desarrollador que trabaja para la Consultora
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "desarrollador")
@PrimaryKeyJoinColumn(name="id_desarrollador", referencedColumnName="nombre_usuario")
@OnDelete(action=OnDeleteAction.CASCADE)
public class Desarrollador extends Usuario implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "desarrolladores_proyecto", 
				joinColumns = { @JoinColumn(referencedColumnName = "id_desarrollador", name="id_desarrollador_fk", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(referencedColumnName = "id_proyecto", name="id_proyecto_fk", nullable = false, updatable = false) })
	private List<Proyecto> listaProyectos = new ArrayList<Proyecto>();


	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<Proyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}

}