package com.api.colmena.dto;

import java.util.List;

import com.api.colmena.model.DetalleVenta;
import com.api.colmena.model.Venta;

public class RequestVenta {

	private Venta venta;
	private List<DetalleVenta> detalleVentas;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

}
