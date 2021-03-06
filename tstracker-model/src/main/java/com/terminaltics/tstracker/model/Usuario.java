package com.terminaltics.tstracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Entidad que representa a un usuario registrado en el sistema
 * 
 * @author asalas
 * 
 */

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;

	@Column(name = "apellidos", length = 200, nullable = false)
	private String apellidos;

	@Column(name = "direccion", length = 255, nullable = false)
	private String direccion;

	@Column(name = "email", unique = true, length = 30, nullable = false)
	private String email;

	@Column(name = "telefono", nullable = true, length = 20)
	private String telefono;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_roles", 
				joinColumns = { @JoinColumn(referencedColumnName = "nombre_usuario", name = "nombre_usuario", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(referencedColumnName = "id_rol", name = "id_rol", nullable = false, updatable = false) })
	private List<Rol> listaRoles = new ArrayList<Rol>();

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
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

	/* Se implementan los metodos de UserDetailService */
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> listGrantedAuthority = new ArrayList<GrantedAuthority>();

		if (this.listaRoles != null && !this.listaRoles.isEmpty()) {
			for (Rol rol : this.listaRoles) {
				listGrantedAuthority.add(rol);
			}
		}

		return listGrantedAuthority;
	}

	@Override
	public String getUsername() {
		return this.nombreUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [nombreUsuario=").append(nombreUsuario)
				.append(", password=").append(password).append(", nombre=")
				.append(nombre).append(", apellidos=").append(apellidos)
				.append(", direccion=").append(direccion).append(", email=")
				.append(email).append(", telefono=").append(telefono)
				.append(", listaRoles=").append(listaRoles).append("]");
		return builder.toString();
	}
}