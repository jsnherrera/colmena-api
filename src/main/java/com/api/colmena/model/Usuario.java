package com.api.colmena.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 100, nullable = false, unique = true)
	private String nombreUsuario;
	@Column(length = 100, nullable = false)
	private String nombre;
	@Column(length = 50, nullable = false)
	private String email;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(nullable = false)
	private int estatus;
	@Column(nullable = false)
	private Date fechaaudit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Date getFechaaudit() {
		return fechaaudit;
	}

	public void setFechaaudit(Date fechaaudit) {
		this.fechaaudit = fechaaudit;
	}

}
