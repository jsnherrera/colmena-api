package com.api.colmena.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.colmena.dto.ResponseDelete;
import com.api.colmena.dto.ResponseVenta;
import com.api.colmena.dto.ResponseVentas;
import com.api.colmena.model.Venta;
import com.api.colmena.repository.IVentaRepo;

@Service
public class VentaService {

	@Autowired
	private IVentaRepo repo;

	public ResponseVenta getOne(long id) {
		ResponseVenta response = new ResponseVenta();
		try {
			Venta venta = this.repo.getOne(id);
			response.setVenta(venta);
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseVentas getVentas(Date fechaini, Date fechafin) {
		ResponseVentas response = new ResponseVentas();
		try {
			List<Venta> list = this.repo.findAll(fechaini, fechafin);
			response.setVentas(list);
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@Transactional
	public ResponseVenta save(Venta venta) {
		ResponseVenta response = new ResponseVenta();
		try {

			for (int i = 0; i < venta.getDetalles().size(); i++) {
				venta.getDetalles().get(i).setVenta(venta);
			}

			response.setVenta(this.repo.save(venta));
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	/*
	 * @Transactional public ResponseVenta save(Venta venta) { ResponseVenta
	 * response = new ResponseVenta(); try { Venta ventaRes = this.repo.save(venta);
	 * System.out.println(ventaRes.getId()); for (DetalleVenta detalleVenta :
	 * venta.getDetalles()) { detalleVenta.setVenta(ventaRes);
	 * this.detalleRepo.save(detalleVenta); } response.setVenta(ventaRes);
	 * response.setCodigo(0); response.setMensaje("Exito"); } catch (Exception e) {
	 * e.printStackTrace(); response.setCodigo(-1);
	 * response.setMensaje(e.toString()); } return response; }
	 */

	public ResponseDelete delete(Venta venta) {
		ResponseDelete responseDelete = new ResponseDelete();
		try {
			this.repo.delete(venta);
			responseDelete.setCodigo(0);
			responseDelete.setMensaje("Exito");
		} catch (Exception e) {
			responseDelete.setCodigo(-1);
			responseDelete.setMensaje(e.toString());
		}
		return responseDelete;
	}

}
