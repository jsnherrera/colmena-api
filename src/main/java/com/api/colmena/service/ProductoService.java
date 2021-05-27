package com.api.colmena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.colmena.dto.ResponseDelete;
import com.api.colmena.dto.ResponseProductos;
import com.api.colmena.dto.Response;
import com.api.colmena.model.Producto;
import com.api.colmena.repository.IProductoRepo;

@Service
public class ProductoService {

	@Autowired
	private IProductoRepo repo;

	public Response getOne(long id) {
		Response response = new Response();
		try {
			Producto producto = this.repo.getOne(id);
			response.setProducto(producto);
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseProductos getProductos() {
		ResponseProductos responseProductos = new ResponseProductos();
		try {
			List<Producto> list = this.repo.findAll();
			responseProductos.setProductos(list);
			responseProductos.setCodigo(0);
			responseProductos.setMensaje("Exito");
		} catch (Exception e) {
			responseProductos.setCodigo(-1);
			responseProductos.setMensaje(e.toString());
		}
		return responseProductos;
	}

	public Response save(Producto producto) {
		Response response = new Response();
		try {
			response.setProducto(this.repo.save(producto));
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseDelete delete(Producto producto) {
		ResponseDelete responseDelete = new ResponseDelete();
		try {
			this.repo.delete(producto);
			responseDelete.setCodigo(0);
			responseDelete.setMensaje("Exito");
		} catch (Exception e) {
			responseDelete.setCodigo(-1);
			responseDelete.setMensaje(e.toString());
		}
		return responseDelete;
	}

}
