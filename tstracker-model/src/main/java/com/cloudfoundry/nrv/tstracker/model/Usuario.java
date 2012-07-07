package com.cloudfoundry.nrv.tstracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entidad que representa a un usuario autenticado de la aplicacion
 * @author asalas
 *
 */

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "roles_usuario", 
				joinColumns = { @JoinColumn(referencedColumnName = "nombre_usuario", name="nombre_usuario", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(referencedColumnName = "id_rol", name="id_rol", nullable = false, updatable = false) })
	private List<Rol> listaRoles = new ArrayList<Rol>();

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

}