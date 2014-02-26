package com.cloudfoundry.tstracker.model;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * Entidad que representa los roles que puede tener un usuario
 * 
 * @author asalas
 *
 */
@Entity
@Table(name="rol")
public class Rol implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rol")
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "codigo_rol")
	private RolEnum codigoRol;
	
	@Column(name = "descripcion_rol")
	private String descripcionRol;
	
//	@ManyToMany(mappedBy="listaRoles", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private Set<Usuario> listaUsuarios = new HashSet<Usuario>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolEnum getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(RolEnum codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
//	public Set<Usuario> getListaUsuarios() {
//		return listaUsuarios;
//	}
//
//	public void setListaUsuarios(Set<Usuario> listUsuarios) {
//		this.listaUsuarios = listUsuarios;
//	}

	/* Se implementan los metodos de GrantedAuthority */
	@Override
	public String getAuthority() {
		return this.codigoRol != null ? this.codigoRol.toString() : null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rol [id=").append(id).append(", codigoRol=")
				.append(codigoRol).append(", descripcionRol=")
				.append(descripcionRol).append("]");
		return builder.toString();
	}
}