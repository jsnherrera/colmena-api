package com.api.colmena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.colmena.model.Producto;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where p.estatus = 1")
	public List<Producto> findAll();

}
