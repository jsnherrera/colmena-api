package com.api.colmena.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.colmena.dto.ResponseDelete;
import com.api.colmena.dto.ResponseProductos;
import com.api.colmena.dto.ResponseUsuario;
import com.api.colmena.dto.ResponseUsuarios;
import com.api.colmena.dto.ResponseVenta;
import com.api.colmena.dto.ResponseVentas;
import com.api.colmena.dto.Response;
import com.api.colmena.model.Producto;
import com.api.colmena.model.Usuario;
import com.api.colmena.model.Venta;
import com.api.colmena.service.ProductoService;
import com.api.colmena.service.UsuarioService;
import com.api.colmena.service.VentaService;

@RestController
@RequestMapping(value = "/v1/api")
@CrossOrigin("*")
public class ColmenaController {

	@Autowired
	private ProductoService productoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private VentaService ventaService;

	@GetMapping(value = "/getProducto/{id}")
	public Response getProducto(@PathVariable long id) {
		Response response = new Response();
		try {
			response = this.productoService.getOne(id);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@GetMapping(value = "/getAllProductos")
	public ResponseProductos getAllProductos() {
		ResponseProductos responseProductos = new ResponseProductos();
		try {
			responseProductos = this.productoService.getProductos();
		} catch (Exception e) {
			responseProductos.setCodigo(-1);
			responseProductos.setMensaje(e.toString());
		}
		return responseProductos;
	}

	@PostMapping(value = "/saveProducto")
	public Response saveProducto(@RequestBody Producto producto) {
		Response response = new Response();
		try {
			response = this.productoService.save(producto);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@DeleteMapping(value = "/deleteProducto/{id}")
	public ResponseDelete deleteProducto(@PathVariable long id) {
		ResponseDelete responseDelete = new ResponseDelete();
		try {
			Response responseSave = getProducto(id);
			responseDelete = this.productoService.delete(responseSave.getProducto());
		} catch (Exception e) {
			responseDelete.setCodigo(-1);
			responseDelete.setMensaje(e.toString());
		}
		return responseDelete;
	}

	@GetMapping(value = "/getUsuarioLogin/{nombreUsuario}")
	public ResponseUsuario getUsuarioLogin(@PathVariable String nombreUsuario) {
		ResponseUsuario response = new ResponseUsuario();
		try {
			response = this.usuarioService.findUserByUsername(nombreUsuario);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@GetMapping(value = "/getUsuario/{id}")
	public ResponseUsuario getUsuario(@PathVariable long id) {
		ResponseUsuario response = new ResponseUsuario();
		try {
			response = this.usuarioService.getOne(id);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@GetMapping(value = "/getAllUsuarios")
	public ResponseUsuarios getAllUsuarios() {
		ResponseUsuarios responseProductos = new ResponseUsuarios();
		try {
			responseProductos = this.usuarioService.getUsuarios();
		} catch (Exception e) {
			responseProductos.setCodigo(-1);
			responseProductos.setMensaje(e.toString());
		}
		return responseProductos;
	}

	@PostMapping(value = "/saveUsuario")
	public ResponseUsuario saveUsuario(@RequestBody Usuario usuario) {
		ResponseUsuario response = new ResponseUsuario();
		try {
			response = this.usuarioService.save(usuario);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@DeleteMapping(value = "/deleteUsuario/{id}")
	public ResponseDelete deleteUsuario(@PathVariable long id) {
		ResponseDelete responseDelete = new ResponseDelete();
		try {
			ResponseUsuario responseUsuario = getUsuario(id);
			responseDelete = this.usuarioService.delete(responseUsuario.getUsuario());
		} catch (Exception e) {
			responseDelete.setCodigo(-1);
			responseDelete.setMensaje(e.toString());
		}
		return responseDelete;
	}

	@GetMapping(value = "/getVenta/{id}")
	public ResponseVenta getVenta(@PathVariable long id) {
		ResponseVenta response = new ResponseVenta();
		try {
			response = this.ventaService.getOne(id);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@GetMapping(value = "/getAllVentas/{fechaini}/{fechafin}")
	public ResponseVentas getAllVentas(@PathVariable Date fechaini, @PathVariable Date fechafin) {
		ResponseVentas response = new ResponseVentas();
		try {
			response = this.ventaService.getVentas(fechaini, fechafin);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	@PostMapping(value = "/saveVenta")
	public ResponseVenta saveVenta(@RequestBody Venta venta) {
		ResponseVenta response = new ResponseVenta();
		try {
			response = this.ventaService.save(venta);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	/*
	 * @PostMapping(value = "/saveVenta") public ResponseVenta
	 * saveVenta(@RequestBody RequestVenta venta) { ResponseVenta response = new
	 * ResponseVenta(); try { response = this.ventaService.save(venta); } catch
	 * (Exception e) { response.setCodigo(-1); response.setMensaje(e.toString()); }
	 * return response; }
	 */

	@DeleteMapping(value = "/deleteVenta/{id}")
	public ResponseDelete deleteVenta(@PathVariable long id) {
		ResponseDelete responseDelete = new ResponseDelete();
		try {
			ResponseVenta response = getVenta(id);
			responseDelete = this.ventaService.delete(response.getVenta());
		} catch (Exception e) {
			responseDelete.setCodigo(-1);
			responseDelete.setMensaje(e.toString());
		}
		return responseDelete;
	}

}
