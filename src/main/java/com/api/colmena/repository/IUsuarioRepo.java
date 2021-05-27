package com.api.colmena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.colmena.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

	@Query("select user from Usuario user where user.estatus = 1")
	public List<Usuario> findAll();

	@Query("select user from Usuario user where user.nombreUsuario = ?1 or user.email = ?1")
	public Usuario findByNombreUsuario(String nombreUsuario);

}
