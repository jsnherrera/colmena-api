package com.api.colmena.dto;

import java.util.List;

import com.api.colmena.model.Venta;

public class ResponseVentas {

	private int codigo;
	private String mensaje;
	private List<Venta> ventas;

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

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

}
