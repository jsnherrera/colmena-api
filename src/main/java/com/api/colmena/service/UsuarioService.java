package com.api.colmena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.colmena.dto.ResponseDelete;
import com.api.colmena.dto.ResponseUsuario;
import com.api.colmena.dto.ResponseUsuarios;
import com.api.colmena.model.Usuario;
import com.api.colmena.repository.IUsuarioRepo;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepo repo;

	public ResponseUsuario findUserByUsername(String nombreUsuario) {
		ResponseUsuario response = new ResponseUsuario();
		try {
			Usuario usuario = this.repo.findByNombreUsuario(nombreUsuario);
			response.setUsuario(usuario);
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseUsuario getOne(long id) {
		ResponseUsuario response = new ResponseUsuario();
		try {
			Usuario usuario = this.repo.getOne(id);
			response.setUsuario(usuario);
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseUsuarios getUsuarios() {
		ResponseUsuarios responseProductos = new ResponseUsuarios();
		try {
			List<Usuario> list = this.repo.findAll();
			responseProductos.setUsuarios(list);
			responseProductos.setCodigo(0);
			responseProductos.setMensaje("Exito");
		} catch (Exception e) {
			responseProductos.setCodigo(-1);
			responseProductos.setMensaje(e.toString());
		}
		return responseProductos;
	}

	public ResponseUsuario save(Usuario usuario) {
		ResponseUsuario response = new ResponseUsuario();
		try {
			response.setUsuario(this.repo.save(usuario));
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseDelete delete(Usuario usuario) {
		ResponseDelete responseDelete = new ResponseDelete();
		try {
			this.repo.delete(usuario);
			responseDelete.setCodigo(0);
			responseDelete.setMensaje("Exito");
		} catch (Exception e) {
			responseDelete.setCodigo(-1);
			responseDelete.setMensaje(e.toString());
		}
		return responseDelete;
	}

}
