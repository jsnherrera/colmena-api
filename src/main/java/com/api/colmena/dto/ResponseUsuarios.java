package com.api.colmena.dto;

import java.util.List;

import com.api.colmena.model.Usuario;

public class ResponseUsuarios {

	private int codigo;
	private String mensaje;
	private List<Usuario> usuarios;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
