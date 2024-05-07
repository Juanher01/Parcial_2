package com.usco.parcial.parcialpw.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.usco.parcial.parcialpw.modelo.Rol;



@Entity
@Table(name="usuario", uniqueConstraints = @UniqueConstraint(columnNames="username"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	
	//Hacemos la relacion
	@ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="usuario_rol", joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="rol_id", referencedColumnName="id")
			)
	private Collection<Rol> roles;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public Usuario(String nombre, String apellido, String username, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Usuario() {
		super();
	}
	
	

}
